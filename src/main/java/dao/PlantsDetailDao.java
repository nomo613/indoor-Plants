package dao;

import java.util.List;

import dto.Plant;

public interface PlantsDetailDao {

	 List<Plant> selectAll() throws Exception;
	    Plant selectById(String plantName) throws Exception;
		Plant selectById(int id) throws Exception;

}
