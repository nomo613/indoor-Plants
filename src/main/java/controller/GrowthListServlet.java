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
			
		} catch(Exception e) {
			throw new ServletException(e);
		
		}
		
	}

}
