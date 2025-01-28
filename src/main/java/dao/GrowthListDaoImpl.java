package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import dto.GrowthList;

public class GrowthListDaoImpl implements GrowthListDao{
	
	private DataSource ds;
	
	public GrowthListDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public List<GrowthList> selectAll() throws Exception {
		List<GrowthList> growths = new ArrayList<>();
		try(Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM growths";
			var stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				GrowthList growthList = mapToGrowthList(rs);
				growths.add(growthList);
			}
		}
		
		return growths;
	}

	private GrowthList mapToGrowthList(ResultSet rs) throws SQLException{
		Integer id = (Integer) rs.getObject("id");
		Date observationAt = rs.getTimestamp("observation_at");
		String watering = rs.getString("watering");
		String record = rs.getString("record");
		
		return new GrowthList(id,observationAt, watering, record);
	}

}























