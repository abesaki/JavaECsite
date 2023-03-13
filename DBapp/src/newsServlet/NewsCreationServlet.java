package newsServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;

//@WebServlet("/NewsCreationServlet")
public class NewsCreationServlet extends HttpServlet {

	// フォワード用変数.
	String path = null;
	RequestDispatcher rd = null;
	int createResult = -1;

	// newsCreation.jspから飛んでくるのはこっち。
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// パラメータの受取.
			String date = request.getParameter("date");
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			String author = request.getParameter("author");

			// String→sql.Dateへ変換.
			java.sql.Date sqlDate = java.sql.Date.valueOf(date);

			// 記事作成メソッド呼び出し.
			createResult = NewsDao.newsCreate(sqlDate, title, body, author);

			// リクエストにメッセージを格納.
			request.setAttribute("createResult", createResult + "件の記事を作成しました。");

			// リクエストにプレビュー用の各種データ格納.
			request.setAttribute("date", date);
			request.setAttribute("title", title);
			request.setAttribute("body", body);
			request.setAttribute("author", author);

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (createResult > 0) {

			// プレビューページへ.
			path = "/News/newsCreationPreview.jsp";

		} else {

			// エラーページへ.
			path = "/Error/errorPage.jsp";
		}

		// フォワード.
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	// 確定ボタン・キャンセルボタン分岐用.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// フォワード用変数.
		String path = null;
		RequestDispatcher rd = null;

		try {

			// リンクリクエストパラメータ受取.
			String action = request.getParameter("action");

			// 条件分岐に応じたコミット/ロールバック.
			if (action != null && action.equals("rollback")) {

				// ロールバックメソッド呼び出し.
				NewsDao.daoRollback();

				// リクエストにメッセージ格納.
				request.setAttribute("transactionResultMessage", "登録をキャンセルしました。");

			} else {

				// コミットメソッド呼び出し.
				NewsDao.daoCommit();

				// リクエストにメッセージ格納.
				request.setAttribute("transactionResultMessage", "記事を登録しました。");
			}

		} catch (Exception e) {

			e.printStackTrace();

			try {

				// DAOインスタンス生成.
				//newsdao = new NewsDao();

				// ロールバックメソッド呼び出し.
				NewsDao.daoRollback();

			} catch (Exception e2) {

				e2.printStackTrace();
			}

		}

		if (createResult > 0) {

			// ニュース管理画面へ.
			path = "/News/menu_newsManagement.jsp";

		} else {

			// エラーページへ.
			path = "/Error/errorPage.jsp";
		}

		// フォワード.
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
