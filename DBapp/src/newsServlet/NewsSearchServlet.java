package newsServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import entity.News;

//@WebServlet("/NewsSearchServlet")
public class NewsSearchServlet extends HttpServlet {

	// フォワード用変数.
	String path = null;
	RequestDispatcher rd = null;
	List<News> newsList = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// パラメータの受取.
			String inputString = request.getParameter("inputString");

			// 記事ソートメソッド呼び出し.
			newsList = NewsDao.searchNews(inputString);

			// リクエストにメッセージを格納.
			request.setAttribute("searchResult", newsList.size() + "件ヒットしました。");

			// リクエストにリストを格納.
			request.setAttribute("newsList", newsList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (newsList == null) {

			// エラーページへ.
			path = "/Error/errorPage.jsp";

		} else {

			// 記事閲覧ページへ.
			path = "/News/newsView.jsp";

		}

		// フォワード.
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
