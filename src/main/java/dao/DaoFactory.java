package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {
	public static PlantsListDao createPlantsListDao() {
		return new PlantsListDaoImpl(getDataSource());
	}

	public static AdminDao createAdminDao() {
		return new AdminDaoImpl(getDataSource());
	}
	
	public static GrowthDao createGrowthDao() {
		return new GrowthDaoImpl(getDataSource());
		
	}
	
	public static GrowthListDao createGrowthListDao() {
		return new GrowthListDaoImpl(getDataSource());
		
	}
	
	public static MemberDao createMemberDao() {
		return new MemberDaoImpl(getDataSource());
	}
	
	public static PlantsDetailDao createPlantsDetailDao() {
		return new PlantsDetailDaoImpl(getDataSource());
	}
	
	

	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		try {
			 ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/indoor_plsnts_db");
		} catch (NamingException e) {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e1) {
					throw new RuntimeException(e1);
				}
			}
			throw new RuntimeException(e);
		}
		return ds;
	}




}
