package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PlantsListDao;

@WebServlet("/plantsList")
public class PlantsListServlet extends HttpServlet {
	

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            // 植物リストを取得
            PlantsListDao dao = DaoFactory.createPlantsListDao();
            req.setAttribute("plants", dao.selectAll());

            // フォワードでリスト表示
            req.getRequestDispatcher("/WEB-INF/view/plantsList.jsp")
                .forward(req, resp);
        } catch (Exception e) {
        	// 例外発生時にログを記録
        	log("Error fetching plant list", e);
            throw new ServletException(e);
        }
    }
    
}



