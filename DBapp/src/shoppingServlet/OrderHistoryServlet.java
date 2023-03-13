package shoppingServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShoppingDao;
import entity.Orders;

//@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//注文履歴用リスト.
		List<Orders> ordersHistoryList = null;

		try {

			// セッション取得.
			HttpSession session = request.getSession(false);

			//セッションからidを受取.
			String userId = (String)session.getAttribute("userId");

			// IDを条件に注文履歴を取得..
			ShoppingDao dao = new ShoppingDao();
			ordersHistoryList = dao.orderHistorySearch(userId);

			// リクエストに注文履歴を送る.
			request.setAttribute("ordersHistoryList", ordersHistoryList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		// フォワード.
		RequestDispatcher rd = request.getRequestDispatcher("/Shopping/ordersHistory.jsp");
		rd.forward(request, response);

	}

}
