package shoppingServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dao.ShoppingDao;
import entity.Orders;

//@WebServlet("/ProductBuyServlet")
public class ProductBuyServlet extends HttpServlet {

	// フォワード用変数.
	RequestDispatcher rd = null;
	int addResult = 0;

	// 購入するボタン用.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッション取得.
		HttpSession session = request.getSession(false);

		// セッションからリストを取得.
		List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");

		// 在庫数用変数.
		int productStock = 0;

		try {

			// インスタンス生成.
			ShoppingDao shoppingDao = new ShoppingDao();
			ProductDao productDao = new ProductDao();

			for (int i = 0; i < ordersList.size(); i++) {

				// 注文数1以上.
				if (ordersList.get(i).getBuyCount() >= 1) {

					// 注文履歴登録.
					addResult = addResult + (shoppingDao.orderHistoryAdd(ordersList.get(i).getUserId(),
							ordersList.get(i).getProductName(), ordersList.get(i).getPrice(),
							ordersList.get(i).getBuyCount()));

					// 在庫数取得.
					productStock = productDao.stockSearch(ordersList.get(i).getProductName());

					// 在庫数変更.
					productDao.stockCountChange(ordersList.get(i).getProductName(),
							(productStock - ordersList.get(i).getBuyCount()));

					// 注文段階で在庫数が10個を下回った場合.
					if ((productStock - ordersList.get(i).getBuyCount()) <= 10) {

						// 自動追加個数設定確認.
						int autoAddStockCount = productDao.autoAddStockCountGet(ordersList.get(i).getProductName());

						// 商品発注(在庫数変更)メソッド呼び出し.
						productDao.stockCountChange(ordersList.get(i).getProductName(),
								(productStock + autoAddStockCount));

					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		request.setAttribute("message", "商品を注文しました。:" + addResult + "件");

		// セッションのリストを新規リストで上書き.
		session.setAttribute("ordersList", new ArrayList<>());

		// フォワード(メニュー画面へ).
		rd = request.getRequestDispatcher("/Menu/menu_normalUser.jsp");
		rd.forward(request, response);
	}

	// キャンセルボタン用.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		// セッションのリストを新規リストで上書き.
		session.setAttribute("ordersList", new ArrayList<>());

		request.setAttribute("message", "注文をキャンセルしました。");

		// フォワード(メニュー画面へ).
		rd = request.getRequestDispatcher("/Menu/menu_normalUser.jsp");
		rd.forward(request, response);

	}

}
