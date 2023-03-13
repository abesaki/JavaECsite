package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Orders;

public class ShoppingDao {

	// 接続用定数.
	private final String URL = "jdbc:mysql://localhost/dbapp";
	private final String USER = "root";
	private final String PASSWORD = "";

	// 使いまわすのでフィールドに設置.
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// コンストラクタでコネクションする.
	public ShoppingDao() throws Exception {

		con = DriverManager.getConnection(URL, USER, PASSWORD);

	}

	// 注文メソッド（戻り値：変更行数）.
	public int orderHistoryAdd(String userId, String productName, int price, int buyCount) throws Exception {

		// 戻り値用変数.
		int rows = -1;

		// SQL文送信（INSERT）.
		ps = con.prepareStatement("INSERT INTO order_history(userId,productName,price,buyCount) VALUES (?,?,?,?)");

		// SQLに代入.
		ps.setString(1, userId);
		ps.setString(2, productName);
		ps.setInt(3, price);
		ps.setInt(4, buyCount);

		// SQL実行.
		rows = ps.executeUpdate();

		return rows;

	}

	// 注文履歴検索メソッド.
	public List<Orders> orderHistorySearch(String userId) throws Exception {

		//戻り値用リスト.
		List<Orders> ordersHistoryList = new ArrayList<Orders>();

		// SQL文送信.
		ps = con.prepareStatement("SELECT * FROM order_history WHERE userId = ?");

		// SQL代入.
		ps.setString(1, userId);

		// SELECT結果取得.
		rs = ps.executeQuery();

		// 結果格納.
		while (rs.next()) {

			//エンティティクラス型インスタンス生成.
			Orders orders = new Orders();

			//各カラムをsetterへ送る.
			orders.setNo(rs.getInt("no"));
			orders.setUserId(rs.getString("userId"));
			orders.setProductName(rs.getString("productName"));
			orders.setPrice(rs.getInt("price"));
			orders.setBuyCount(rs.getInt("buyCount"));
			orders.setTimeStamp(rs.getTimestamp("timestamp"));

			//エンティティをリストに追加.
			ordersHistoryList.add(orders);

		}

		return ordersHistoryList;

	}

	// トランザクションメソッド.
	public void beginTransaction() throws SQLException {

		// 自動コミットオフ.
		con.setAutoCommit(false);

	}

	// コミットメソッド.
	public void daoCommit() throws SQLException {

		// コミット.
		con.commit();

		// コネクション終了.
		closeConnection();

	}

	// ロールバックメソッド.
	public void daoRollback() throws SQLException {

		// ロールバック.
		con.rollback();

		// コネクション終了.
		closeConnection();

	}

	// コネクションクローズメソッド.
	public void closeConnection() {

		try {

			if (con != null) {

				// クローズ.
				con.close();

				// nullに戻す.
				con = null;

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}