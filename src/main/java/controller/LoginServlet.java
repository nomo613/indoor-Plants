package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			//ログイン情報の取得//
			String loginId = req.getParameter("loginId");
			String loginPass = req.getParameter("loginPass");

			//データベースの操作//
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin =
			    adminDao.findByLoginIdAndLoginPass(loginId, loginPass);
			if (admin != null) {
				req.getSession().setAttribute("loginId",admin.getLoginId());
			} else {
				req.setAttribute("error", true);
				req.getRequestDispatcher("/WEB-INF/view/login.jsp")
						.forward(req, resp);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
