package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Plant;

public interface RegisteredPlantsDao {
    List<Plant> getRegisteredPlants() throws SQLException;
    void registerPlantById(int plantId) throws SQLException;
}
