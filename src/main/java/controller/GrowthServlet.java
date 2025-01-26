package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.GrowthDao;

@WebServlet("/growth")
public class GrowthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/growth.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//文字化け防止
		req.setCharacterEncoding("UTF-8");

		//入力値の取得
		String observation = req.getParameter("observationAt");
		String watering = req.getParameter("watering");
		String record = req.getParameter("record");

		System.out.println(observation);
		System.out.println(watering);
		System.out.println(record);

		//バリデーション
		boolean isValid = true;
		if (observation.isBlank()) {
			System.out.println("年月日が不正");
			isValid = false;
		}

		if (watering.isBlank() || watering.length() > 30) {
			System.out.println("水やり回数不正");
			isValid = false;

		}
		if (record.isBlank() || record.length() > 500) {
			System.out.println("入力不正");
			isValid = false;
		}

		if (!isValid) {
			// フォームを再表示
			req.getRequestDispatcher("/WEB-INF/view/growth.jsp")
					.forward(req, resp);
			return;
		}

		//年月日をjava.util.Data型に変数
		Date observationAt = convertDate(observation);

		//DBに保存
		save(observationAt, watering, record);

		// ここでgrowthオブジェクトを取得
	    GrowthDao growth = getGrowth();  // 必要に応じて取得するメソッドを追加

	    // Growthオブジェクトをリクエストにセット
	    req.setAttribute("growth", growth);  // GrowthオブジェクトをJSPに渡す

	    // growth.jspに遷移
	    req.getRequestDispatcher("/WEB-INF/view/growth.jsp").forward(req, resp);
	}

	private GrowthDao getGrowth() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	// 情報をDataに保存するメソッド
	private void save(Date observation, String watering, String record) {

		try {
			var ctx = new InitialContext();
			var ds = (DataSource) ctx.lookup("java:comp/env/jdbc/indoor_plsnts_db");

			// DBに接続 ⇒DB接続を切る
			try (Connection con = ds.getConnection()) {
				// SQLを実行する
				String sql = "INSERT INTO growths " 
						+ " (observation_at,watering,record) " 
						+ " VALUES (?, ?, ?)"; 

				// 1. SQLを実行準備状態にする
				var stmt = con.prepareStatement(sql);
				stmt.setTimestamp(1, new Timestamp(observation.getTime()));
				stmt.setString(2, watering);
				stmt.setString(3, record);
				
				// 2. SQLを実行
				stmt.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 文字列をDate型に変換するメソッド
	private Date convertDate(String date) {
		var sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return d;

	}
}


