package productServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/ProductRegistrationServlet")
public class ProductRegistrationServlet extends HttpServlet {

	// フォワード用変数.
	String path = null;
	RequestDispatcher rd = null;
	int sqlProcessResult = -1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの受取.
		String name = request.getParameter("name");
		String tmpPrice = request.getParameter("price");

		//String→intへ変換.
		int price = Integer.parseInt(tmpPrice);

		try {

			ProductDao dao = new ProductDao();

			// 商品名追加メソッド呼び出し.
			sqlProcessResult = dao.productRegister(name,price);

			// リクエストにメッセージを格納.
			request.setAttribute("sqlProcessResult", sqlProcessResult + "個の商品を登録しました。：" + name + "(" + price + "円)");

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
