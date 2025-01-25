package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PlantsListDao;
import dto.Plant;


@WebServlet("/plantsList")
public class PlantsListServlet extends HttpServlet {

  

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			// 植物の取得（DAOに依頼）
			PlantsListDao dao = DaoFactory.createPlantsListDao();

			// 植物リストをリクエストスコープに格納
			req.setAttribute("plants", dao.selectAll());

			// フォワード
			req.getRequestDispatcher("/WEB-INF/view/plantsList.jsp")
				.forward(req, resp);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    try {
	        // DAOから現在登録されている植物リストを取得
	        PlantsListDao dao = DaoFactory.createPlantsListDao();
	        List<Plant> registeredPlants = dao.selectAll();

	        // 最大登録数を定義
	        final int MAX_PLANTS = 4;

	        if (registeredPlants.size() >= MAX_PLANTS) {
	            // 最大登録数に達している場合の処理
	            req.setAttribute("error", "最大登録数に達しました。これ以上登録できません。");
	            req.getRequestDispatcher("/WEB-INF/view/plantsList.jsp")
	                .forward(req, resp);
	            return;
	        }
	        for (Plant plant : dao.selectAll()) {
	            System.out.println("Image Path: " + plant.getImagePath());
	        }


	        // 新規登録の処理を続ける
	        String plantName = req.getParameter("plantName");
	        dao.insert(new Plant(MAX_PLANTS, plantName, plantName, plantName, plantName, plantName, plantName, plantName)); // 新しい植物を登録
	        resp.sendRedirect(req.getContextPath() + "/plantsList");

	    } catch (Exception e) {
	        throw new ServletException(e);
	    }
	}


}