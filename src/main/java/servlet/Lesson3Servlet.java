package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.UsersEntity;

@WebServlet("/Lesson3Servlet")
public class Lesson3Servlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// リクエストとレスポンスの文字コードをUTF-8に指定
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");

		// 送信されたJSONの取得
		BufferedReader buffer = new BufferedReader(req.getReader());
		// 取得したJSONデータをString型に置き換え
		String reqJson = buffer.readLine();

		ObjectMapper mapper = new ObjectMapper();
		// JSONデータをMapに格納
		Map<String, String> reqMap = mapper.readValue(reqJson, new TypeReference<Map<String, String>>() {
		});

		// 画面パラメータの取得 
		String employeeNum = reqMap.get("employeeNum");
		String password = reqMap.get("password");

		// propertiesファイルの読み込み
		ResourceBundle bundle = ResourceBundle.getBundle("info");

		// DB接続情報
		String URL = "jdbc:mysql://localhost:3306/portalappdb?allowPublicKeyRetrieval=true&useSSL=false";
		// プロパティファイルから値を取得
		String USER = bundle.getString("DB_CONNECT_USER");
		String PASS = bundle.getString("DB_CONNECT_PATH");

		// Entityクラスのインスタンス生成
		UsersEntity usersEntity = new UsersEntity();

		try {
			// JDBCのドライバークラスをロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続
			Connection con = DriverManager.getConnection(URL, USER, PASS);

			String sql = "select * from users where employeeNum=? and password=?;";
			PreparedStatement prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, employeeNum);
			prepStmt.setString(2, password);

			// SQL実行・実行結果取得
			ResultSet rs = prepStmt.executeQuery();

			if (rs.next()) {
				if (employeeNum.equals(rs.getString("employeeNum"))) {
					if (password.equals(rs.getString("password"))) {

						// Usersエンティティにパラメータをセット
						String employeeName = rs.getString("employeeName");
						int authority = rs.getInt("authority");
						usersEntity.setEmployeeName(rs.getString("employeeName"));
						usersEntity.setAuthority(rs.getInt("authority"));

						ObjectMapper responseMapper = new ObjectMapper();
						// Usersエンティティの情報をJSON形式に変換する。
						String jsonAsString = responseMapper.writeValueAsString(usersEntity);
						
						PrintWriter out = res.getWriter();
						res.setContentType("application/json");

						out.print(jsonAsString);
						out.flush();
					}
				}
			}

			// 後始末
			rs.close();
			prepStmt.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
