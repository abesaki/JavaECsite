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

import entity.Orders;

//@WebServlet("/ShoppingCartAddServlet")
public class ShoppingCartAddServlet extends HttpServlet {

	// フォワード用変数.
	RequestDispatcher rd = null;
	String path = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッション取得.
		HttpSession session = request.getSession(false);

		//セッションからidを受取.
		String userId = (String)session.getAttribute("userId");

		//パラメータ受取.
		String[] name = request.getParameterValues("name");
		String[] price = request.getParameterValues("price");
		String[] buyCount = request.getParameterValues("buyCount");

		//リスト作成.
		List<Orders> ordersList = new ArrayList<Orders> ();

		for(int i = 0; i < name.length ; i++) {

			//インスタンス生成.
			Orders orders = new Orders();

			//各setterに送る.
			orders.setUserId(userId);
			orders.setProductName(name[i]);
			orders.setPrice(Integer.parseInt(price[i]));
			orders.setBuyCount(Integer.parseInt(buyCount[i]));

			//リストにエンティティクラスを格納.
			ordersList.add(orders);

		}

		//リストをセッションに送る.
		session.setAttribute("ordersList", ordersList);

		//フォワード先変更.
		path = "/Shopping/shoppingCart.jsp";

		// フォワード.
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
