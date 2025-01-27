package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import dto.Growth;
import dto.Plant;

public class GrowthDaoImpl implements GrowthDao{
	
	private DataSource ds;
	
	// DataSourceの準備は、
	// GrowthDaoImplを生成するクラスに委ねる
	public GrowthDaoImpl(DataSource ds) {
	   this.ds =ds;
    }

	@Override
	public List<GrowthDao> selectAll() throws Exception {
		List<GrowthDao> growths = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			// SQLを実行準備
			String sql = createSelectClauseWithJoin();
			var stmt = con.prepareStatement(sql);
			// SQLを実行
			ResultSet rs = stmt.executeQuery();
			// ResultSetをList<GrowthList>にする
			while(rs.next()) {
				// ResultSet ⇒ Growth
				GrowthDao growth = (GrowthDao) mapToGrowth(rs);
				// GrowthをListに加える
				growths.add((GrowthDao) mapToGrowth(rs));
			}			
		}
		return growths;
	}

	@Override
	public GrowthDao selectById(int id) throws Exception {
		GrowthDao growth = null;
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
			growth = (GrowthDao) mapToGrowth(rs);
		}
		}
		return growth;
	}

	@Override
	public void insert(Growth growth) throws Exception {
		try(Connection con = ds.getConnection()){
			// SQLを実行準備
			String sql = "INSERT INTO growth "
					+ " (observation_at, watering, "  
					+ "  record, plant_id) " 
					+ " VALUES(  NOW(), ?, ?, ?, ?) ";
			var stmt = con.prepareStatement(sql);
			// ?の設定
			Date observation = growth.getObservationAt();
			long longBd = observation.getTime();
			Timestamp tsBd = new Timestamp(longBd);
			stmt.setTimestamp(1, tsBd);
	        stmt.setString(2, growth.getWatering());
	        stmt.setString(3, growth.getRecord());
	        Plant plant = growth.getpPlant();
	        stmt.setObject(4, plant.getId(), Types.INTEGER);
	        
			 
			// SQLを実行
			stmt.executeUpdate();
		}
	}
	
	// ResultSet を Growthに変換
	private Growth mapToGrowth(ResultSet rs) throws SQLException {
	    Integer id = rs.getInt("id");
	    Date observationAt = rs.getTimestamp("observation_at");
	    String watering = rs.getString("watering");
	    String record = rs.getString("record");
	    
	    Integer plantId = (Integer) rs.getObject("plant_id");
	    String plantNumber = rs.getString("plant_nember");
	    String plantName = rs.getString("plant_name");
	    Plant plant = new Plant(plantId, plantNumber, plantName, null,null,null);
	    
	    return new Growth(id, observationAt, watering, record, plant);
	}
	
	// JOIN句までのSELECT文を生成
	private String createSelectClauseWithJoin() {
		return "SELECT\n"
				+ " plants.plant_name, "
				+ " g.observation_at,   "
				+ " g.watering, g.record "
				+ " FROM plants "
				+ " JOIN growths AS g "
				+ " ON plants.id = g.id;";
}

	@Override
	public Date getObservationAt() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getWatering() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getRecord() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setPlantName(String string) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void setObservationAt(Timestamp timestamp) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}


