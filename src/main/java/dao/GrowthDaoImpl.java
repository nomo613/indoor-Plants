package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import dto.Growth;

public class GrowthDaoImpl implements GrowthDao{
	
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
	public GrowthDao selectById(int id) throws Exception {
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
			growth = (Growth) mapToGrowth(rs);
		}
		}
		return null;
	}

	@Override
	public void insert(Growth growth) throws Exception {
	    try (Connection con = ds.getConnection()) {
	        String sql = "INSERT INTO growths "
	                + "(observation_at, watering, record) "
	                + "VALUES (?, ?, ?)";
	        var stmt = con.prepareStatement(sql);
	        stmt.setTimestamp(1, new java.sql.Timestamp(growth.getObservationAt().getTime()));
	        stmt.setString(2, growth.getWatering());
	        stmt.setString(3, growth.getRecord());
	        
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
	    return new Growth(id, observationAt, watering, record);
	}
	
	// JOIN句までのSELECT文を生成
	private String createSelectClauseWithJoin() {
		return "SELECT "
				+ " plants.plant_name, "
				+ " g.observation_at,   "
				+ " g.watering, g.record "
				+ " FROM plants "
				+ " JOIN growths AS g "
				+ " ON plants.id = g.id;";
}



	@Override
	public void insert(GrowthDao growth) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}



