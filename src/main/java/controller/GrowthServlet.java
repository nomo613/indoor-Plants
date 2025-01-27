package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PlantsListDao;

@WebServlet("/growth")
public class GrowthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String plantName = req.getParameter("plant_name");
        
		try {
			 PlantsListDao dao = DaoFactory.createPlantsListDao();
	            System.out.println(dao.selectAll());
	            req.setAttribute("growth", dao.selectById(plantName));	
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		// list.jspにフォワード
		req.getRequestDispatcher("/WEB-INF/view/growth.jsp")
				.forward(req, resp);
	}


}

