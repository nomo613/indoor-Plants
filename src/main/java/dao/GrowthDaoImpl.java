package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import dto.Plant;

public class GrowthDaoImpl implements Growth{
	
	private DataSource ds;
	
	// DataSourceの準備は、
	// GrowthDaoImplを生成するクラスに委ねる
	public GrowthDaoImpl(DataSource ds) {
	   this.ds =ds;
    }

	@Override
	public List<Growth> selectAll() throws Exception {
		List<Growth> growths = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			// SQLを実行準備
			String sql = createSelectClauseWithJoin();
			var stmt = con.prepareStatement(sql);
			// SQLを実行
			ResultSet rs = stmt.executeQuery();
			// ResultSetをList<GrowthList>にする
			while(rs.next()) {
				// ResultSet ⇒ Growth
				Growth growth = mapToGrowth(rs);
				// GrowthをListに加える
				growths.add(mapToGrowth(rs));
			}			
		}
		return growths;
	}

	@Override
	public Growth selectById(int id) throws Exception {
		Growth growth = null;
		try(Connection con = ds.getConnection()){
		// SQLを実行準備
		String sql = createSelectClauseWithJoin() 
				+ "WHERE p.id = ?";
		var stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		// SQLを実行
		ResultSet rs = stmt.executeQuery();
		// ResultSet を Growthに変換
		if(rs.next()) {
			growth = mapToGrowth(rs);
		}
		}
		return null;
	}

	@Override
	public void insert(Growth growth) throws Exception {
		try(Connection con = ds.getConnection()){
			// SQLを実行準備
			String sql = "INSERT INTO growth "
					+ " observation_at "  
					+ " watering,  record " 
					+ " VALUES( NOW(),?, ?)";
			var stmt = con.prepareStatement(sql);
			// ?の設定
			
			stmt.setString(2, growth.getWatering());
			stmt.setString(3, growth.getRecord());
			 
			// SQLを実行
		}
	}
	
	// ResultSet を Growthに変換
	private  Growth mapToGrowth(ResultSet rs) throws SQLException  {
		Integer id = (Integer) rs.getObject("id");
		Date observationAt = rs.getTimestamp("observation_at");
		String watering  = rs.getString("watering ");
		String record = rs.getString("record");
		
		Integer plantId = (Integer)rs.getObject("plant_id");
		String plantName = rs.getString("plant_name");
		Plant plant = new Plant(plantId, plantName, null, null);
		
		return new Growth(plantId, plantName, observationAt, watering, record);
	}
	
	// JOIN句までのSELECT文を生成
	private String createSelectClauseWithJoin() {
		return "SELECT\n"
				+ " plants.plant_id, plants.plant_name, "
				+ " g.observation_at,   "
				+ " g.watering, g.record "
				+ " FROM plants "
				+ " JOIN growths AS g "
				+ " ON plants.id = g.id;";
}

}



