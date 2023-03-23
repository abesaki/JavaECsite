package productServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/StockCountAddServlet")
public class StockCountAddServlet extends HttpServlet {

	// フォワード用変数.
	String path = null;
	RequestDispatcher rd = null;
	int sqlProcessResult = -1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの受取.
		String name = request.getParameter("name");
		String tmpCount = request.getParameter("count");

		// String→intへ変換.
		int count = Integer.parseInt(tmpCount);

		try {

			ProductDao dao = new ProductDao();

			// 在庫数確認メソッド呼び出し.
			int productStock = dao.stockSearch(name);

			// 在庫数変更メソッド呼び出し.
			sqlProcessResult = dao.stockCountChange(name, (productStock + count));

			// リクエストにメッセージを格納.
			request.setAttribute("sqlProcessResult", sqlProcessResult + "個の商品情報を更新しました。：" + name + "(" + count + "個追加)");

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (sqlProcessResult > 0) {

			// 在庫管理画面へ.
			path = "/Product/menu_productManagement.jsp";

		} else {

			// エラーページへ.
			path = "/Error/errorPage.jsp";
		}

		// フォワード.
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
