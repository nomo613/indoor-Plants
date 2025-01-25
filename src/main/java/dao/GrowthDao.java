package dao;

import java.util.List;

import dto.Growth;

public interface GrowthDao {
	
	List<Growth> selectAll() throws Exception;
	GrowthDao selectById(int id) throws Exception;
	void insert(GrowthDao growth) throws Exception;

	void insert(Growth growth) throws Exception;

}
