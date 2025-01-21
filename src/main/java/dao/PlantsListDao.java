package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Plant;

public interface PlantsListDao {

	List<Plant> findAll();

	void insert(Plant newPlant) throws SQLException;

	

	
}
