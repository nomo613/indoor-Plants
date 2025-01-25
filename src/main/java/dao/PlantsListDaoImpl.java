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

	// DataSourceの準備は、
	// GrowthDaoImplを生成するクラスに委ねる
	public PlantsListDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Plant> selectAll() throws SQLException {
		String sql = "SELECT * FROM plants";
		try (Connection conn = ds.getConnection();
				ResultSet rs = conn.createStatement().executeQuery(sql)) {
			List<Plant> plantList = new ArrayList<>();
			while (rs.next()) {
				Plant plant = new Plant();
				plant.setId(rs.getInt("id"));
				plant.setPlantNumber(rs.getString("plant_number"));
				plant.setPlantName(rs.getString("plant_name"));
				plant.setJapaneseName(rs.getString("japanese_name"));
				plant.setScientificName(rs.getString("scientific_name"));
				plant.setGenusName(rs.getString("genus_name"));
				plant.setDescription(rs.getString("description"));
				plant.setImagePath(rs.getString("image_path"));
				plantList.add(plant);
				System.out.println("Image Path: " + rs.getString("image_path"));

			}
			return plantList;
		}
	}

	@Override
	public int countPlants() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void insert(Plant plant) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
