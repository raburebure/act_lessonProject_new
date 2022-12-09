package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lesson1Servlet")
public class Lesson1Servlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 画面パラメータの取得
		String inputValue = req.getParameter("input1");

		// 次画面に渡すパラメータのセット
		req.setAttribute("output1", inputValue);

		// 表示するJSPをセット
		RequestDispatcher nextPage = req.getRequestDispatcher("/lesson1-2.jsp");

		// 指定した画面へ遷移
		nextPage.forward(req, res);

	}

}
