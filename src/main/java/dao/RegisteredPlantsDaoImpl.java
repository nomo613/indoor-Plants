package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.Plant;

public class RegisteredPlantsDaoImpl implements RegisteredPlantsDao {
    private DataSource ds;

    public RegisteredPlantsDaoImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Plant> getRegisteredPlants() throws SQLException {
        String sql = """
            SELECT p.plant_id, p.plant_name, p.image_path, m.member_name 
            FROM plants p
            JOIN members m ON m.member_id = p.member_id
        """;

        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            List<Plant> registeredPlants = new ArrayList<>();
            while (rs.next()) {
                Plant plant = new Plant();
                plant.setId(rs.getInt("plant_id"));
                plant.setPlantName(rs.getString("plant_name"));
                plant.setImagePath(rs.getString("image_path"));
                plant.setMemberName(rs.getString("member_name"));
                registeredPlants.add(plant);
            }
            return registeredPlants;
        }
    }

    @Override
    public void registerPlantById(int plantId) throws SQLException {
        String sql = """
            UPDATE plants 
            SET is_registered = 1
            WHERE plant_id = ?
        """;

        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, plantId);
            stmt.executeUpdate();
        }
    }
}
