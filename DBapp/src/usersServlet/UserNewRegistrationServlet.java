package usersServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import entity.Users;

@WebServlet("/UserNewRegistrationServlet")
public class UserNewRegistrationServlet extends HttpServlet {

	// フォワード用変数.
	RequestDispatcher rd = null;
	String path = null;

	// 登録ボタン.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションをfalseで取得.
		HttpSession session = request.getSession(false);

		// セッションから各種パラメータを受取.
		Users users = (Users) session.getAttribute("users");

		// Dao変数宣言.
		UsersDao dao = null;

		// 登録処理数結果（正常なら1）
		int registrationResult = 0;

		try {

			// Daoインスタンス生成.
			dao = new UsersDao();

			// データベースへ登録.
			registrationResult = dao.usersNewRegister(users);

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (registrationResult == 1) {

			// フォワード先変更（ログイン画面へ）
			path = "/login_logout/login.jsp";

			// 登録完了メッセージをリクエストへ格納,
			String registResultMessage = "登録しました：" + users.getUserId();
			request.setAttribute("registResultMessage", registResultMessage);

		} else {

			// フォワード先変更（エラー画面へ）
			path = "/Error/errorPage.jsp";

		}

		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	// キャンセルボタン.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションをfalseで取得.
		HttpSession session = request.getSession(false);

		// セッション破棄.
		session.invalidate();

		// 表示メッセージ用リスト.
		List<String> attentionMessageList = new ArrayList<String>();

		// 注意メッセージ格納.
		attentionMessageList.add("登録をキャンセルしました。");

		// 注意メッセージをリクエストへ送る.
		request.setAttribute("attentionMessageList", attentionMessageList);

		// フォワード.
		rd = request.getRequestDispatcher("/Users/userNewRegistration.jsp");
		rd.forward(request, response);

	}

}
