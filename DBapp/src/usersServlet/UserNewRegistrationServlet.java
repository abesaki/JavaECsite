package usersServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;

//@WebServlet("/UserNewRegistrationServlet")
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
		List<Object> parametersList = (List<Object>) session.getAttribute("parametersList");



		UsersDao dao = null;

		try {

			// Daoインスタンス生成.
			dao = new UsersDao();

		} catch (Exception e) {

			e.printStackTrace();

		}

		// userテーブルへ登録(userid,password).
		int registrationResult1 = dao.userNewRegisterForUserTable(parametersList);

		// users_informationテーブルへ登録(password以外).
		int registrationResult2 = dao.userNewRegisterForUsersInformationTable(parametersList);

		if (registrationResult1 == 1 && registrationResult2 == 1) {

			// フォワード先変更（ログイン画面へ）
			path = "/login_logout/login.jsp";

			// 登録完了メッセージをリクエストへ格納,
			String registResultMessage = "登録しました：" + parametersList.get(0);
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
