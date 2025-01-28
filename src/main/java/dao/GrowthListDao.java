package dao;

import java.util.List;

import dto.GrowthList;

public interface GrowthListDao {

	List<GrowthList> selectAll() throws Exception;

}
