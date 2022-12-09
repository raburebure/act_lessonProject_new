package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codeList.Authority;

@WebServlet("/Lesson2Servlet")
public class Lesson2Servlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// リクエスト情報の文字コードを変換
		req.setCharacterEncoding("UTF-8");

		// 出力項目
		String employeeName = "";
		int authority = 0;

		// 画面パラメータの取得 
		String employeeNum = req.getParameter("employeeNum");
		String password = req.getParameter("password");

		// propertiesファイルの読み込み
		ResourceBundle bundle = ResourceBundle.getBundle("info");

		// DB接続情報
		String URL = "jdbc:mysql://localhost:3306/portalappdb?allowPublicKeyRetrieval=true&useSSL=false";
		// プロパティファイルから値を取得
		String USER = bundle.getString("DB_CONNECT_USER");
		String PASS = bundle.getString("DB_CONNECT_PATH");

		try {
			// JDBCのドライバークラスをロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続
			Connection con = DriverManager.getConnection(URL, USER, PASS);

			// SQLの作成
			String sql = "select * from users where employeeNum=? and password=?;";

			// SQLにパラメータをセット
			PreparedStatement prepStmt = con.prepareStatement(sql);

			// 第一引数はパラメータインデックス、第二引数はパラメータ
			prepStmt.setString(1, employeeNum);
			prepStmt.setString(2, password);

			// SQL実行・実行結果取得
			ResultSet rs = prepStmt.executeQuery();

			// 取得した実行結果分だけ処理を実行
			if (rs.next()) {
				if (employeeNum.equals(rs.getString("employeeNum"))) {
					if (password.equals(rs.getString("password"))) {

						// 名前と権限情報を処理
						employeeName = rs.getString("employeeName");
						authority = rs.getInt("authority");

					}
				}
			}

			// 後始末。DB接続後にはcloseした接続を遮断すること。
			rs.close();
			prepStmt.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 次画面に渡すパラメータのセット
		req.setAttribute("employeeName", employeeName);
		req.setAttribute("authority", Authority.convertLabel(authority));

		// 画面遷移
		req.getRequestDispatcher("/lesson2.jsp").forward(req, res);

	}

}
