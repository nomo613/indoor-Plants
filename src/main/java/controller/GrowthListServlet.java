package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.GrowthListDao;

@WebServlet("/growthList")
public class GrowthListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

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
			String observation = req.getParameter("observationAt");
			String watering = req.getParameter("watering");
			String record = req.getParameter("record");
			
			
			// バリデーション
			boolean isValidated = true;
			
			try {
				// バリデーションNG
				if(!isValidated) {
					// フォーム再表示用初期値
					req.setAttribute("observationAt", observation );
					req.setAttribute("watering", watering );
					req.setAttribute("record", record );
					
					// growthListDaoを使い、リストを準備
					GrowthListDao dao = DaoFactory.createGrowthListDao();
					req.setAttribute("growts", dao.selectAll());
					
					// フォームの再表示(フォワード)	
					
			req.getRequestDispatcher("/WEB-INF/view/growthList.jsp")
					.forward(req, resp);
			return;}
			
		    // バリデーションOK
			// 入力値をGrowthにまとめ
	} catch(Exception e) {
		throw new ServletException(e);

				
	}
			
	}}	
			
		
		


