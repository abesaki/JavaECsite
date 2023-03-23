package newsServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import entity.News;

@WebServlet("/NewsDeletionServlet")
public class NewsDeletionServlet extends HttpServlet {

	// フォワード用変数.
	String path = null;
	RequestDispatcher rd = null;
	List<News> newsList = null;
	static String inputString = null;

	// newsDeletion.jspから飛んでくるのはこっち(Postメソッド).
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// パラメータの受取.
			inputString = request.getParameter("inputString");

			// 記事検索メソッド呼び出し.
			newsList = NewsDao.searchNews(inputString);

			// リクエストにメッセージを格納.
			request.setAttribute("searchResult", newsList.size() + "件の記事がヒットしました。");

			//リクエストにリストを格納.
			request.setAttribute("newsList", newsList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (newsList == null) {

			// エラーページへ.
			path = "/Error/errorPage.jsp";

		} else {

			// プレビューページへ.
			path = "/News/newsDeletionPreview.jsp";

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

				// リクエストにメッセージ格納.
				request.setAttribute("transactionResultMessage", "削除をキャンセルしました。");

			} else {

				// 削除メソッド呼び出し.
				NewsDao.newsDelete(inputString);

				// リクエストにメッセージ格納.
				request.setAttribute("transactionResultMessage", "記事を削除しました。");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (newsList == null) {

			// エラーページへ.
			path = "/Error/errorPage.jsp";

		} else {

			// ニュース管理画面へ.
			path = "/News/menu_newsManagement.jsp";

		}

		// フォワード.
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
