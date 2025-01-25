package dao;


import java.util.List;

import dto.Plant;

public interface PlantsListDao {

	List<Plant> selectAll() throws Exception;

	int countPlants();

	void insert(Plant plant);
	
}
