package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Users;

public class UsersDao {

	// 接続用定数.
	private final String URL = "jdbc:mysql://localhost/users";
	private final String USER = "root";
	private final String PASSWORD = "";

	// 使いまわすのでフィールドに設置.
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// コンストラクタでコネクションする.
	public UsersDao() throws Exception {

		// ProcessBuilderインスタンスを生成する.
		ProcessBuilder apacheStart = new ProcessBuilder("C:\\xampp\\apache_start.bat");
		ProcessBuilder mysqlStart = new ProcessBuilder("C:\\xampp\\mysql_start.bat");

		// Mysql自動開始（手動で起動する場合はコメントオフすること）.
		apacheStart.start();
		mysqlStart.start();

		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(URL, USER, PASSWORD);

	}

	// ログインメソッド.
	public Users login(String userId, String password) {

		// エンティティクラスのインスタンス生成.
		Users user = new Users();

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT * FROM user WHERE userid = ? AND password = ?");

			// SQLに代入.
			ps.setString(1, userId);
			ps.setString(2, password);

			// 検索結果取得.
			rs = ps.executeQuery();

			// レコードがあれば格納.
			if (rs.next()) {

				// カラムを取得して各setterへ送る.
				user.setNo(rs.getInt("no"));
				user.setUserId(rs.getString("userid"));
				user.setPassword(rs.getString("password"));

			} else {

				return null;
			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return user;

	}

	// ユーザーID全取得メソッド.
	public List<String> userIdAllGet() {

		// 戻り値用リスト.
		List<String> userIdAllList = new ArrayList<String>();

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT userid FROM user");

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// IDカラムをリストに入れていく.
				userIdAllList.add(rs.getString("userid"));

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return userIdAllList;
	}

	// ユーザー新規登録メソッド(userテーブル).
	public int userNewRegisterForUserTable(List<Object> parametersList) {

		// 戻り値用変数.
		int rows = -1;

		try {

			// SQL文送信（INSERT）.
			ps = con.prepareStatement("INSERT INTO user(userid,password) VALUES (?,?)");

			// SQLに代入.
			ps.setString(1, (String)parametersList.get(0));
			ps.setString(2, (String)parametersList.get(1));

			// SQL実行.
			rows = ps.executeUpdate();

		} catch (Exception e) {

			System.out.print("登録処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return rows;

	}

	// ユーザー新規登録メソッド(users_informationテーブル).
	public int userNewRegisterForUsersInformationTable(List<Object> parametersList) {

		// 戻り値用変数.
		int rows = -1;

		try {

			// SQL文送信（INSERT）.
			ps = con.prepareStatement(
					"INSERT INTO users_information(userid,familyname,firstname,familyname_furigana,firstname_furigana,gender,birthday,address_prefectures,address_municipality,email_address,phone_number) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			// SQLに代入.
			ps.setString(1, (String)parametersList.get(0));
			ps.setString(2, (String)parametersList.get(2));
			ps.setString(3, (String)parametersList.get(3));
			ps.setString(4, (String)parametersList.get(4));
			ps.setString(5, (String)parametersList.get(5));
			ps.setString(6, (String)parametersList.get(6));
			ps.setDate(7, (Date)parametersList.get(7));
			ps.setString(8, (String)parametersList.get(8));
			ps.setString(9, (String)parametersList.get(9));
			ps.setString(10, (String)parametersList.get(10));
			ps.setString(11, (String)parametersList.get(11));

			// SQL実行.
			rows = ps.executeUpdate();

		} catch (Exception e) {

			System.out.print("登録処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return rows;

	}

}