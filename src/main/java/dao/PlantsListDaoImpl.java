package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.Plant;

public class PlantsListDaoImpl implements PlantsListDao {

	@Override
	public List<Plant> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
    public void insert(Plant plant) throws SQLException {
        String sql = "INSERT INTO plants (name, type) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plant.getName());
            stmt.setString(2, plant.getType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting plant: " + e.getMessage());
            throw e;
        }
	}

	private Connection getConnection() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}	
	

}
