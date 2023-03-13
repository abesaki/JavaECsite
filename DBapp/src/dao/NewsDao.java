package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.News;

public class NewsDao {

	// 接続用定数(URLは各メソッドで変更する).
	private static final String URL = "jdbc:mysql://localhost/dbapp";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	// 使いまわすのでフィールドに設置.
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;

	// 最新ニュース取得メソッド.
	public static News latestNewsAcquisition() {

		News news = new News();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB接続.
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {

			System.out.print("接続処理で異常が発生しました。：");
			e.printStackTrace();

		}

		try {

			// SQL文送信（最も大きいNoを検索）.
			ps = con.prepareStatement("SELECT * FROM news WHERE no = (SELECT MAX(no) FROM news)");

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// カラムを取得して各setterへ送る.
				news.setNo(rs.getInt("no"));
				news.setDate(rs.getDate("date"));
				news.setTitle(rs.getString("title"));
				news.setBody(rs.getString("body"));
				news.setAuthor(rs.getString("author"));

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		} finally {

			// データベースとの接続終了.
			try {

				ps.close();
				con.close();

			} catch (Exception e) {

				System.out.print("終了処理で異常が発生しました。：");
				e.printStackTrace();
				return null;

			}
		}

		return news;

	}

	// 新規記事作成メソッド（戻り値：変更行数）.
	public static int newsCreate(Date sqlDate, String title, String body, String author) throws Exception {

		// 戻り値用変数.
		int rows = -1;

		Class.forName("com.mysql.cj.jdbc.Driver");

		// DB接続.
		con = DriverManager.getConnection(URL, USER, PASSWORD);

		// トランザクション開始.
		beginTransaction();

		// SQL文送信（INSERT）.
		ps = con.prepareStatement("INSERT INTO news(date,title,body,author) VALUES (?,?,?,?)");

		// SQLに代入.
		ps.setDate(1, sqlDate);
		ps.setString(2, title);
		ps.setString(3, body);
		ps.setString(4, author);

		// SQL実行.
		rows = ps.executeUpdate();

		return rows;

	}

	// ニュース検索メソッド_全記事取得(オーバーロード1).
	public static List<News> searchNews() {

		List<News> newsList = new ArrayList<News>();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB接続.
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {

			System.out.print("接続処理で異常が発生しました。：");
			e.printStackTrace();

		}

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT * FROM news");

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// インスタンス生成.
				News news = new News();

				// カラムを取得して各setterへ送る.
				news.setNo(rs.getInt("no"));
				news.setDate(rs.getDate("date"));
				news.setTitle(rs.getString("title"));
				news.setBody(rs.getString("body"));
				news.setAuthor(rs.getString("author"));

				// リストに格納.
				newsList.add(news);

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return newsList;

	}

	// ニュース検索メソッド_全条件付き(オーバーロード2).
	public static List<News> searchNews(Date sqlDate, String title, String body, String author) {

		List<News> newsList = new ArrayList<News>();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB接続.
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {

			System.out.print("接続処理で異常が発生しました。：");
			e.printStackTrace();

		}

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT * FROM news WHERE date = ? AND title = ? AND body = ? AND author = ?");

			// SQLに代入.
			ps.setDate(1, sqlDate);
			ps.setString(2, title);
			ps.setString(3, body);
			ps.setString(4, author);

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// インスタンス生成.
				News news = new News();

				// カラムを取得して各setterへ送る.
				news.setNo(rs.getInt("no"));
				news.setDate(rs.getDate("date"));
				news.setTitle(rs.getString("title"));
				news.setBody(rs.getString("body"));
				news.setAuthor(rs.getString("author"));

				// リストに格納.
				newsList.add(news);

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return newsList;

	}

	// ニュース検索メソッド_文字列検索(オーバーロード3).
	public static List<News> searchNews(String inputString) {

		List<News> newsList = new ArrayList<News>();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB接続.
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {

			System.out.print("接続処理で異常が発生しました。：");
			e.printStackTrace();

		}

		try {

			String sql = "%" + inputString + "%";

			// SQL文送信.
			ps = con.prepareStatement("SELECT * FROM news WHERE title LIKE ? OR body LIKE ?");

			// SQLに代入.
			ps.setString(1, sql);
			ps.setString(2, sql);

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// インスタンス生成.
				News news = new News();

				// カラムを取得して各setterへ送る.
				news.setNo(rs.getInt("no"));
				news.setDate(rs.getDate("date"));
				news.setTitle(rs.getString("title"));
				news.setBody(rs.getString("body"));
				news.setAuthor(rs.getString("author"));

				// リストに格納.
				newsList.add(news);

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return newsList;

	}

	// ニュースソートメソッド(引数で昇順・降順分岐).
	public static List<News> sortNews(String sortDate) {

		List<News> newsList = new ArrayList<News>();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB接続.
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {

			System.out.print("接続処理で異常が発生しました。：");
			e.printStackTrace();

		}

		try {

			String sqlCommand = "SELECT * FROM news ORDER BY date";

			// SQLに代入.
			if (sortDate.contains("降")) {

				sqlCommand = sqlCommand + " DESC";

			}

			// SQL文送信.
			ps = con.prepareStatement(sqlCommand);

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// インスタンス生成.
				News news = new News();

				// カラムを取得して各setterへ送る.
				news.setNo(rs.getInt("no"));
				news.setDate(rs.getDate("date"));
				news.setTitle(rs.getString("title"));
				news.setBody(rs.getString("body"));
				news.setAuthor(rs.getString("author"));

				// リストに格納.
				newsList.add(news);

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return newsList;

	}

	// 記事削除メソッド.
	public static int newsDelete(String inputString) {

		// 戻り値用変数.
		int rows = -1;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB接続.
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {

			System.out.print("接続処理で異常が発生しました。：");
			e.printStackTrace();

		}

		try {

			String sql = "%" + inputString + "%";

			// SQL文送信（INSERT）.
			ps = con.prepareStatement("DELETE FROM news WHERE title LIKE ? OR body LIKE ?");

			// SQLに代入.
			ps.setString(1, sql);
			ps.setString(2, sql);

			// SQL実行.
			rows = ps.executeUpdate();

		} catch (Exception e) {

			System.out.print("削除処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return rows;

	}

	// トランザクションメソッド.
	public static void beginTransaction() throws SQLException {

		// 自動コミットオフ.
		con.setAutoCommit(false);

	}

	// コミットメソッド.
	public static void daoCommit() throws SQLException {

		// コミット.
		con.commit();

		// コネクション終了.
		closeConnection();

	}

	// ロールバックメソッド.
	public static void daoRollback() throws SQLException {

		// ロールバック.
		con.rollback();

		// コネクション終了.
		closeConnection();

	}

	// コネクションをクローズする.
	public static void closeConnection() {

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