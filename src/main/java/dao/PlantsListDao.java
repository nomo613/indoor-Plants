package dao;

import java.util.List;

import dto.Plant;

public interface PlantsListDao {
    List<Plant> selectAll() throws Exception;
    List<Plant> getRegisteredPlants() throws Exception;
    void registerPlantById(int plantId) throws Exception;
}
