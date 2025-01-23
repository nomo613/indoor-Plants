package dao;

import java.util.List;

public interface Growth {
	
	List<Growth> selectAll() throws Exception;
	Growth selectById(int id) throws Exception;
	void insert(Growth growth) throws Exception;

}
