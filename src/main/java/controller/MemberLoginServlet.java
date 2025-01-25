package controller;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.MemberDao;



@WebServlet("/memberlogin")
public class MemberLoginServlet extends HttpServlet {

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
			MemberDao memberDao = DaoFactory.createMemberDao();
			Member member =
			    memberDao.findByLoginIdAndLoginPass(loginId, loginPass);
			if (member != null) {
				req.getSession().setAttribute("loginId",member.getLoginId());
				resp.sendRedirect("plantsList");
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
