package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql = "SELECT * FROM plants";
        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            List<Plant> plantList = new ArrayList<>();
            while (rs.next()) {
                plantList.add(mapPlant(rs));
            }
            return plantList;
        }
    }

    private Plant mapPlant(ResultSet rs) throws SQLException {
        return new Plant(
            rs.getInt("id"),
            rs.getString("plant_number"),
            rs.getString("plant_name"),
            rs.getString("japanese_name"),
            rs.getString("scientific_name"),
            rs.getString("genus_name"),
            rs.getString("description"),
            rs.getString("image_path")
        );
    }


    @Override
    public List<Plant> getRegisteredPlants() throws SQLException {
        String sql = "SELECT * FROM registered_plants";
        try (Connection conn = ds.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            List<Plant> plantList = new ArrayList<>();
            while (rs.next()) {
                plantList.add(mapPlant(rs));
            }
            return plantList;
        }
        }

    @Override
    public void registerPlantById(int plantId) throws SQLException {
        String sql = "INSERT INTO registered_plants (SELECT * FROM plants WHERE id = ?)";
        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, plantId);
            pstmt.executeUpdate();
        }
    }
    }

    

