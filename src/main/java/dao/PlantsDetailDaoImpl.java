 package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.Plant;

public class PlantsDetailDaoImpl implements PlantsDetailDao {

	private DataSource ds;

	public PlantsDetailDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Plant> selectAll() throws Exception {
		List<Plant> plants =  new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM plants";
			var stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Plant plant = mapToPlant(rs);
				plants.add(plant);
			}
		}
		return plants;
	}

	private Plant mapToPlant(ResultSet rs) throws SQLException {
		 Integer id = (Integer) rs.getObject("id");
		 String plantCpl = rs.getString("plant_cpl");
		 String plantName = rs.getString("plant_name");
		String japaneseName = rs.getString("japanese_name");
		String scientificName = rs.getString("scientific_name");
		String genusName = rs.getString("genus_name");
		String description = rs.getString("description");
		String imagePath = rs.getString("image_path");
		return new Plant(id, plantCpl, plantName, japaneseName, scientificName, genusName, description, imagePath);
	}



	private String createSelectClauseWithJoin() {
		return "SELECT "
				+ " + p.id, p.plant_cpl, p.plant_name, p.japanese_name, p.scientific_name, p.genus_name, p.description, p.image_path, "
				+ " + g.id AS growth_id, g.observation_at, "
				+ " g.watering, g.record  "
				+ " FROM plants As p "
				+ " LEFT JOIN growths As g "
				+ " ON  p.plant_cpl = g.plant_cpl ";

	}
	
	@Override
	public Plant selectById(int id) throws Exception {
	    return selectByCondition("p.id", id);
	}

	@Override
	public Plant selectById(String plantName) throws Exception {
	    return selectByCondition("p.plant_name", plantName);
	}

	private Plant selectByCondition(String column, Object value) throws Exception {
	    Plant plant = null;
	    try (Connection con = ds.getConnection()) {
	        String sql = createSelectClauseWithJoin() + " WHERE " + column + " = ?";
	        var stmt = con.prepareStatement(sql);
	        
	        if (value instanceof Integer) {
	            stmt.setInt(1, (Integer) value);
	        } else {
	            stmt.setString(1, value.toString());
	        }
	        
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            plant = mapToPlant(rs);
	        }
	    }
	    return plant;
	}
}
