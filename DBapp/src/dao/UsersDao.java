package dao;

import java.sql.Connection;
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

		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(URL, USER, PASSWORD);

	}

	// ログインメソッド.
	public Users login(String userId, String password) {

		// エンティティクラスのインスタンス生成.
		Users users = new Users();

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT * FROM users WHERE userid = ? AND password = ?");

			// SQLに代入.
			ps.setString(1, userId);
			ps.setString(2, password);

			// 検索結果取得.
			rs = ps.executeQuery();

			// レコードがあれば格納.
			if (rs.next()) {

				// カラムを取得して各setterへ送る.
				users.setId(rs.getInt("id"));
				users.setUserId(rs.getString("userid"));
				users.setPassword(rs.getString("password"));

			} else {

				return null;
			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return users;

	}

	// ユーザーID全取得メソッド.
	public List<String> usersIdAllGet() {

		// 戻り値用リスト.
		List<String> userIdAllList = new ArrayList<String>();

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT userid FROM users");

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

	// ユーザー新規登録メソッド.
	public int usersNewRegister(Users users) {

		// 戻り値用変数.
		int rows = -1;

		try {

			// SQL文送信（INSERT）.
			ps = con.prepareStatement(
					"INSERT INTO users(userid,password,familyname,firstname,familyname_furigana,firstname_furigana,birthDay,address_prefectures,address_municipality,email_address,phone_number) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			// SQLに代入.
			ps.setString(1, users.getUserId());
			ps.setString(2, users.getPassword());
			ps.setString(3, users.getFamilyName());
			ps.setString(4, users.getFirstName());
			ps.setString(5, users.getFamilyNameFurigana());
			ps.setString(6, users.getFirstNameFurigana());
			ps.setDate(7, users.getBirthDay());
			ps.setString(8, users.getAddressPrefectures());
			ps.setString(9, users.getAddressMunicipality());
			ps.setString(10, users.getEmailAddress());
			ps.setString(11, users.getPhoneNumber());

			// SQL実行.
			rows = ps.executeUpdate();

		} catch (Exception e) {

			System.out.print("登録処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return rows;

	}

	// 登録ユーザー情報全件取得メソッド.
	public List<Users> usersInformationAllGet() {

		// 戻り値用リスト.
		List<Users> usersInformationAllList = new ArrayList<Users>();

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT * FROM users");

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// エンティティクラスのインスタンス生成.
				Users users = new Users();

				// カラムを取得して各setterへ送る.
				users.setId(rs.getInt("id"));
				users.setUserId(rs.getString("userid"));
				users.setPassword(rs.getString("password"));
				users.setFamilyName(rs.getString("familyName"));
				users.setFirstName(rs.getString("firstName"));
				users.setFamilyNameFurigana(rs.getString("familyname_furigana"));
				users.setFirstNameFurigana(rs.getString("firstname_furigana"));
				users.setBirthDay(rs.getDate("birthDay"));
				users.setAddressPrefectures(rs.getString("address_prefectures"));
				users.setAddressMunicipality(rs.getString("address_municipality"));
				users.setEmailAddress(rs.getString("email_address"));
				users.setPhoneNumber(rs.getString("phone_number"));
				users.setRegistrationDate(rs.getTimestamp("registration_date"));
				users.setUpdatedDate(rs.getTimestamp("updated_date"));

				// エンティティをリストに追加.
				usersInformationAllList.add(users);

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return usersInformationAllList;
	}

	// ユーザーIDで検索するメソッド.
	public Users usersInformationSearchByUserId(String userid) {

		// 戻り値用.
		Users users = new Users();

		try {

			// SQL文送信.
			ps = con.prepareStatement("SELECT * FROM users WHERE userid = ?");

			// SQLに代入.
			ps.setString(1, userid);

			// 検索結果取得.
			rs = ps.executeQuery();

			while (rs.next()) {

				// カラムを取得して各setterへ送る.
				users.setId(rs.getInt("id"));
				users.setUserId(rs.getString("userid"));
				users.setPassword(rs.getString("password"));
				users.setFamilyName(rs.getString("familyName"));
				users.setFirstName(rs.getString("firstName"));
				users.setFamilyNameFurigana(rs.getString("familyname_furigana"));
				users.setFirstNameFurigana(rs.getString("firstname_furigana"));
				users.setBirthDay(rs.getDate("birthDay"));
				users.setAddressPrefectures(rs.getString("address_prefectures"));
				users.setAddressMunicipality(rs.getString("address_municipality"));
				users.setEmailAddress(rs.getString("email_address"));
				users.setPhoneNumber(rs.getString("phone_number"));
				users.setRegistrationDate(rs.getTimestamp("registration_date"));
				users.setUpdatedDate(rs.getTimestamp("updated_date"));

			}

		} catch (Exception e) {

			System.out.print("検索処理で異常が発生しました。：");
			e.printStackTrace();

		}

		return users;

	}

}