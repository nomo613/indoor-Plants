package dao;

import java.util.List;

import dto.Plant;

public interface PlantsListDao {
    List<Plant> selectAll() throws Exception;
    Plant selectById(String plantName) throws Exception;
    
}
