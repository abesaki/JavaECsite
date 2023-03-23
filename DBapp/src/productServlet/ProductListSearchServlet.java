package productServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import entity.Product;

@WebServlet("/ProductListSearchServlet")
public class ProductListSearchServlet extends HttpServlet {

	// フォワード用変数.
	String path = null;
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			//全件検索で戻り値の商品リストを格納.
			ProductDao dao = new ProductDao();
			List<Product> productList = dao.searchProductAll();

			//リクエストにリストを送る.
			request.setAttribute("productList", productList);

			//セッション取得.
			HttpSession session = request.getSession(true);
			if(session.getAttribute("userId").equals("root")) {

				// 在庫管理画面へ.
				path = "/Product/inventory.jsp";

			} else {

				// 商品一覧画面へ.
				path = "/Shopping/productList.jsp";
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		// フォワード.
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
