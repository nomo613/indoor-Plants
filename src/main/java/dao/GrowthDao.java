package dao;

import java.sql.Timestamp;
import java.util.List;

import dto.Growth;

public interface GrowthDao {
	
	List<GrowthDao> selectAll() throws Exception;
	GrowthDao selectById(int id) throws Exception;
	void insert(GrowthDao growth) throws Exception;
	void setPlantName(String string);
	void setObservationAt(Timestamp timestamp);
	void insert(Growth growth) throws Exception;

}