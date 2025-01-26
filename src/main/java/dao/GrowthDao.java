package dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface GrowthDao {
	
	List<GrowthDao> selectAll() throws Exception;
	GrowthDao selectById(int id) throws Exception;
	void insert(GrowthDao growth) throws Exception;
	Date getObservationAt();
	String getWatering();
	String getRecord();
	void setPlantName(String string);
	void setObservationAt(Timestamp timestamp);

}