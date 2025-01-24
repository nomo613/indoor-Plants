package dao;

import java.util.Date;
import java.util.List;

public interface GrowthDao {
	
	List<GrowthDao> selectAll() throws Exception;
	GrowthDao selectById(int id) throws Exception;
	void insert(GrowthDao growth) throws Exception;
	Date getObservationAt();
	String getWatering();
	String getRecord();

}
