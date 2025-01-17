package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlantsListDao;
import dao.PlantsListDaoImpl;
import domain.Plant;


@WebServlet("/plantsList")
public class PlantsListServlet extends HttpServlet {

  
    public PlantsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PlantsListDao dao = new PlantsListDaoImpl();
	    try {
	        List<Plant> plants = dao.findAll();  // DAOから植物リストを取得
	        req.setAttribute("plants", plants); // JSPにデータを渡す
	    } catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("error", "データの取得に失敗しました。");
	    }
		req.getRequestDispatcher("/WEB-INF/view/plantsList.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    String plantName = req.getParameter("name");
	    String plantType = req.getParameter("type");
	    
	    Plant newPlant = new Plant();
	    newPlant.setName(plantName);
	    newPlant.setType(plantType);

	    PlantsListDao dao = new PlantsListDaoImpl();
	    try {
	        dao.insert(newPlant); // 新しい植物データを挿入
	        req.getSession().setAttribute("message", "新しい植物を登録しました！");
	        resp.sendRedirect("plantsList"); // データ挿入後にリストページにリダイレクト
	    } catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("error", "データの追加に失敗しました。");
	        req.getRequestDispatcher("/WEB-INF/view/plantsList.jsp").forward(req, resp);
	    }
	}

}