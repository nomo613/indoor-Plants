package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.GrowthListDao;
import dto.Growth;

@WebServlet("/growthList")
public class GrowthListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String plantName = req.getParameter("plantName");
		req.setAttribute("plantName", plantName);

		try {
			// GrowrhListの取得（DAOに依頼）
			GrowthListDao dao = DaoFactory.createGrowthListDao();

			// GrowrhListをリクエストスコープに格納
			req.setAttribute("growths", dao.selectAll());

			// フォワード
			req.getRequestDispatcher("/WEB-INF/view/growthList.jsp")
					.forward(req, resp);

		} catch (Exception e) {
			throw new ServletException(e);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 文字化け防止
		req.setCharacterEncoding("UTF-8");

		// 入力値の取得
		String observationAt = req.getParameter("observationAt");
		String watering = req.getParameter("watering");
		String record = req.getParameter("record");

		// バリデーション
		boolean isValidated = true;

		if (observationAt.isBlank()) {
			req.setAttribute("errorObservation", "観察年月日を入力してください");
			isValidated = false;
		}
		if (watering.length() > 30) {
			req.setAttribute("errorWatering", "30文字以内にしてください");
			isValidated = false;
		}

		try {
			// バリデーションNG
			if (!isValidated) {
				// フォーム再表示用初期値
				req.setAttribute("observationAt", observationAt);
				req.setAttribute("watering", watering);
				req.setAttribute("record", record);

				// growthListDaoを使い、リストを準備
				GrowthListDao dao = DaoFactory.createGrowthListDao();
				req.setAttribute("growths", dao.selectAll()); // 修正点：キーを正しく設定

				// フォームの再表示(フォワード)	
				req.getRequestDispatcher("/WEB-INF/view/growthList.jsp")
						.forward(req, resp);
				return;
			}

			// バリデーションOK
			// 入力値をGrowthにまとめる
			Date observation = new SimpleDateFormat("y-MM-dd").parse(observationAt);
			Growth growth = new Growth();
			growth.setObservationAt(observation);
			growth.setWatering(watering);
			growth.setRecord(record);

			// GrowthDaoを使い、Playerを保存
			DaoFactory.createGrowthDao().insert(growth);

			// 植物リストページにリダイレクト
			resp.sendRedirect("growthList");

		} catch (Exception e) {
			throw new ServletException(e);

		}

	}
}
