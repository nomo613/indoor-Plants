package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PlantsDetailDao;
import dto.Plant;

@WebServlet("/plantsDetail")
public class PlantsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
            String plantIdStr = req.getParameter("id"); // URLパラメータの取得
            if (plantIdStr != null && !plantIdStr.isEmpty()) {
                int plantId = Integer.parseInt(plantIdStr);
                PlantsDetailDao dao = DaoFactory.createPlantsDetailDao();
                Plant plant = dao.selectById(plantId);
                
                if (plant != null) {
                    req.setAttribute("plants", List.of(plant)); // リスト化
                } else {
                    req.setAttribute("plants", new ArrayList<>()); // 空リスト
                }
            }
            req.getRequestDispatcher("/WEB-INF/view/plantsDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            log("Error fetching plant details", e);
            throw new ServletException(e);
        }
    }
}