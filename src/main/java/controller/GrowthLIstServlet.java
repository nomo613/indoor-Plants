package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dto.GrowthList;

@WebServlet("/growthList")
public class GrowthLIstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GrowthList<Growth> growths = new ArrayList<>();

		try {
			var ctx = new InitialContext();
			var ds = (DataSource) ctx.lookup("java:comp/env/jdbc/indoor_plants_db");

			// DBに接続close処理
			try (Connection con = ds.getConnection()) {

				// SELECT文を実行
				String sql = "SELECT * FROM growths";
				var stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();

				// ⇒ 実行結果(ResultSet)をGrowthList<Growth>にする
				while (rs.next()) {
					// 1行分のデータ⇒Growthに変換
					GrowthList growth = mapToGrowth(rs);
					// Growthをリストに加える
					growths.add(growth);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		// growsListをリクエストスコープに格納
		req.setAttribute("growths", growths);

		// list.jspにフォワード
		req.getRequestDispatcher("/WEB-INF/view/growthList.jsp")
				.forward(req, resp);
	}

	// 1行分のデータをGrowth型に変換するメソッド
	private GrowthList mapToGrowth(ResultSet rs) throws SQLException {
				Integer id = (Integer) rs.getObject("id");
				Date observation = rs.getTimestamp("observation_at");
				String watering = rs.getString("watering");
				String record = rs.getString("record");
				return new Growth(id, observation, watering, record);

	  }	
	}
	