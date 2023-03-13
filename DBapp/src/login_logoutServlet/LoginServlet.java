package login_logoutServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import entity.Users;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// フォワード先URL用変数.
		String path = null;

		try {

			// パラメータの受取.
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

			// 未入力の場合.
			if (userId.equals("") || password.equals("")) {

				// エラーメッセージをリクエストに格納.
				request.setAttribute("loginError", "入力されていない箇所があります。");

				// フォワード先を変更.
				path = "/login_logout/login.jsp";

			} else {

				// セッションの生成.
				HttpSession session = request.getSession(true);

				// Daoインスタンス生成.
				UsersDao dao = new UsersDao();

				// ログインメソッド呼び出し(リストに格納).
				Users user = dao.login(userId, password);

				if (user == null) {

					// エラーメッセージをリクエストに格納.
					request.setAttribute("loginError", "IDまたはパスワードが違います。");

					// フォワード先を変更.
					path = "/login_logout/login.jsp";

				} else {

					session.setAttribute("userId", userId);

					// 管理者か検証.
					if (userId.equals("root")) {

						path = "/Menu/menu_rootUser.jsp";

					} else {

						path = "/Menu/menu_normalUser.jsp";

					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		// フォワード.
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
