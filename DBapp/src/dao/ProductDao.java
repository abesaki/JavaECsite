package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import entity.ProductSetting;

public class ProductDao {

	// 接続用定数.
	private static final String URL = "jdbc:mysql://localhost/dbapp";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	// 使いまわすのでフィールドに設置.
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// コンストラクタでコネクションする.
	public ProductDao() throws Exception {

		con = DriverManager.getConnection(URL, USER, PASSWORD);

	}

	// 商品名追加メソッド（戻り値：変更行数）.
	public int productRegister(String name, int price) throws Exception {

		// 戻り値用変数.
		int rows = -1;

		// SQL文送信（INSERT）.
		ps = con.prepareStatement("INSERT INTO product(name,price) VALUES (?,?)");

		// SQLに代入.
		ps.setString(1, name);
		ps.setInt(2, price);

		// SQL実行.
		rows = ps.executeUpdate();

		return rows;

	}

	// 商品名削除メソッド（戻り値：変更行数）.
	public int productDelete(String name) throws Exception {

		// 戻り値用変数.
		int rows = -1;

		// SQL文送信（INSERT）.
		ps = con.prepareStatement("DELETE FROM product WHERE name = ?");

		// SQLに代入.
		ps.setString(1, name);

		// SQL実行.
		rows = ps.executeUpdate();

		return rows;

	}

	// 在庫数変更メソッド.
	public int stockCountChange(String name, int count) throws Exception {

		// 戻り値用変数.
		int rows = -1;

		// SQL文送信（INSERT）.
		ps = con.prepareStatement("UPDATE product SET count = ? , timestamp = current_timestamp() WHERE name = ?");

		// SQLに代入.
		ps.setInt(1, count);
		ps.setString(2, name);

		// SQL実行.
		rows = ps.executeUpdate();

		return rows;

	}

	// 在庫数取得メソッド.
	public int stockSearch(String name) throws Exception {

		// 在庫数検索.
		ps = con.prepareStatement("SELECT count FROM product WHERE name = ?");
		ps.setString(1, name);

		// SELECT結果取得.
		rs = ps.executeQuery();

		// 結果格納.
		int count = 0;

		while (rs.next()) {

			count = rs.getInt("count");

		}

		return count;
	}

	// 商品一覧取得メソッド.
	public List<Product> searchProductAll() throws Exception {

		List<Product> productList = new ArrayList<Product>();

		// SQL文送信.
		ps = con.prepareStatement("SELECT * FROM product");

		// 検索結果取得.
		rs = ps.executeQuery();

		while (rs.next()) {

			// インスタンス生成.
			Product product = new Product();

			// カラムを取得して各setterへ送る.
			product.setNo(rs.getInt("no"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setCount(rs.getInt("count"));
			product.setTimeStamp(rs.getTimestamp("TimeStamp"));

			// リストに格納.
			productList.add(product);

		}

		return productList;

	}

	//自動在庫追加設定取得メソッド.
	public List<ProductSetting> productSettingGet() throws Exception {

		//戻り値用リスト.
		List<ProductSetting> productSettingList = new ArrayList<ProductSetting>();

		// 在庫数検索.
		ps = con.prepareStatement("SELECT * FROM product_setting");

		// 検索結果取得.
		rs = ps.executeQuery();

		while (rs.next()) {

			// インスタンス生成.
			Product product = new Product();

			// カラムを取得して各setterへ送る.
			product.setNo(rs.getInt("no"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setCount(rs.getInt("count"));
			product.setTimeStamp(rs.getTimestamp("TimeStamp"));

			// リストに格納.
			productList.add(product);

		}

		return autoAddStockCount;

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