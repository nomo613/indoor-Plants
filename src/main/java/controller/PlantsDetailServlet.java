package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PlantsDetailDao;

@WebServlet("/plantsDetail")
public class PlantsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			// 植物詳細を取得
			PlantsDetailDao dao = DaoFactory.createPlantsDetailDao();
			req.setAttribute("detail", dao.selectAll());
			System.out.println(dao.selectAll());

			// フォワードでリスト表示
			req.getRequestDispatcher("/WEB-INF/view/plantsdetail.jsp")
					.forward(req, resp);

		} catch (Exception e) {
			// 例外発生時にログを記録
			log("Error fetching detail list", e);
			throw new ServletException(e);

		}

	}
}