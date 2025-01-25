package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PlantsListDao;
import dto.Plant;


@WebServlet("/registerPlant")
public class RegisterPlantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            // 入力パラメータ取得
            String name = req.getParameter("name");
            String description = req.getParameter("description");

            // バリデーション
            if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
                req.setAttribute("error", "すべての項目を入力してください。");
                req.getRequestDispatcher("/WEB-INF/view/plantsList.jsp").forward(req, resp);
                return;
            }

            // 登録件数の確認（最大4件まで）
            PlantsListDao dao = DaoFactory.createPlantsListDao();
            if (dao.countPlants() >= 4) {
                req.setAttribute("error", "登録可能な植物は最大4つまでです。");
                req.getRequestDispatcher("/WEB-INF/view/plantsList.jsp").forward(req, resp);
                return;
            }

            // 登録処理
            dao.insert(new Plant(name, description));
            resp.sendRedirect("plantsList");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
