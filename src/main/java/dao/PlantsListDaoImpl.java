package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.Plant;

public class PlantsListDaoImpl implements PlantsListDao {

	private DataSource ds;

	public PlantsListDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Plant> selectAll() throws SQLException {
		List<Plant> plants = new ArrayList<>();
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

	@Override
	public Plant selectById(int id) throws Exception {
		Plant plant = null;
		try (Connection con = ds.getConnection()) {
			// SQLを実行準備
			String sql = createSelectClauseWithJoin()
					+ " WHERE p.id = ?";
			var stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			// SQLを実行
			ResultSet rs = stmt.executeQuery();

			// ResultSet ⇒　Plantに変換
			if (rs.next()) {
				plant = mapToPlant(rs);
			}

		}
		return plant;
	}

	private String createSelectClauseWithJoin() {
		 return "SELECT "
				   + " p.id, p.plant_cpl, p.plant_name, "
				   + " g.id, g.observation_at, "
				   + " g.watering, g.record  "
				   + " FROM plants As pgrowths "
				   + " JOIN growths As g "
				   + " ON  p.plant_cpl = g.plant_cpl ";

}

	@Override
	public Plant selectById(String plantName) throws Exception {
		Plant plant = null;
		try (Connection con = ds.getConnection()){
			// SQLを実行準備
			String sql = createSelectClauseWithJoin()+ "WHERE p.plant_name = ?";
			var stmt = con.prepareStatement(sql);
			stmt.setString(1, plantName);
			// SQLを実行
			ResultSet rs = stmt.executeQuery();
			// ResultSet ⇒ Playerに変換
            if(rs.next()) {
            	plant = mapToPlant(rs);
            }
			
		}
		
		return plant;
	}
}























