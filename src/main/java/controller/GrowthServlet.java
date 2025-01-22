package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/growth")
public class GrowthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
 
		req.getRequestDispatcher("/WEB-INF/view/growth.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//文字化け防止
		req.setCharacterEncoding("UTF-8");
		
		//入力値の取得
		String tested_at = req.getParameter("testedAt");
		String watering_frequency = req.getParameter("watering_frequency");
		String summary = req.getParameter("summary");
		
		System.out.println(tested_at);
		System.out.println(watering_frequency);
		System.out.println(summary);
		
		
		//バリデーション
        boolean isValid = true;
		if (tested_at.isBlank()) {
			System.out.println("年月日が不正");
			isValid = false;
		}
		
		if(watering_frequency .isBlank() || watering_frequency .length() > 30) {
			System.out.println("水やり回数不正");	
			isValid = false;
			
		}
		if(summary.isBlank() || summary.length() > 500) {
			System.out.println("入力不正");
			isValid = false;
		}	
		
		if(!isValid){
			//　フォームを再表示
			req.getRequestDispatcher("/WEB-INF/view/growth.jsp")
					.forward(req, resp);
		}
			
		//年月日をdata型に変数
		
		
		//DBに保存
		
		
		//一覧頁に保存
		
	}

}
