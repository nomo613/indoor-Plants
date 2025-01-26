package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.RegisteredPlantsDao;
import dto.Plant;

@WebServlet("/registered")
public class RegisteredServlet extends HttpServlet {

    private static final int MAX_PLANTS = 4;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            RegisteredPlantsDao dao = DaoFactory.createRegisteredPlantsDao();
            List<Plant> registeredPlants = dao.getRegisteredPlants();

            String idParam = req.getParameter("id");
            if (idParam != null) {
                int plantId = Integer.parseInt(idParam);

                if (registeredPlants.size() >= MAX_PLANTS) {
                    req.setAttribute("error", "登録件数は最大4つまでです。");
                } else {
                    dao.registerPlantById(plantId);
                    req.getSession().setAttribute("message", "植物を登録しました。");
                    resp.sendRedirect(req.getContextPath() + "/registered");
                    return;
                }
            }

            req.setAttribute("registeredPlants", registeredPlants);
            req.getRequestDispatcher("/WEB-INF/view/registered.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}


