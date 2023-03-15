package usersServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import entity.Users;

//@WebServlet("/RegistrationConfirmationServlet")
//ユーザー登録情報の整合性確認用Servlet.
public class RegistrationConfirmationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// フォワード先URL用変数.
		String path = null;

		// 各種パラメータ受取.
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String familyName = request.getParameter("familyName");
		String firstName = request.getParameter("firstName");
		String familyNameFurigana = request.getParameter("familyNameFurigana");
		String firstNameFurigana = request.getParameter("firstNameFurigana");
		String birthday = request.getParameter("birthday");
		String addressPrefectures = request.getParameter("addressPrefectures");
		String addressMunicipality = request.getParameter("addressMunicipality");
		String emailAddress = request.getParameter("emailAddress");
		String phonenumber = request.getParameter("phonenumber");
		//int phonenumber3 = Integer.parseInt(request.getParameter("phonenumber"));

		//検証用.
		//int phoneNumber1 = Integer.parseInt("10");
		int phoneNumber2 = Integer.parseInt(phonenumber,10);
		//NumberFormat commaFormat = NumberFormat.getNumberInstance(); //カンマ区切り
		//String phoneNumber = commaFormat.format(phonenumber);

		// 未入力検証用配列.
		String[] parameters = { userId, password, familyName, firstName, familyNameFurigana, firstNameFurigana,
				birthday, addressPrefectures, addressMunicipality, emailAddress, phonenumber };

		// 表示メッセージ用リスト.
		List<String> attentionMessageList = new ArrayList<String>();

		// エンティティクラス宣言.
		Users users = null;

		// 整合性確認用変数.（正しいブロックを通るたびに+1される：最大値7）
		int integrityCheckFlag = 0;

		// 未入力検証用変数.
		boolean blankCheckFlag = false;

		// 全体検証：空欄確認.
		for (String p : parameters) {

			if (p == null || p == "" || p.equals("") || p.isEmpty()) {

				// 未入力フラグオン.
				blankCheckFlag = true;

				// 1箇所見つかった時点で抜ける.
				break;

			}

		}

		// 未入力フラグがオンの場合は各検証を飛ばす.
		if (blankCheckFlag == true) {

			// 注意メッセージ格納.
			attentionMessageList.add("未記入の箇所があります。");

		} else {

			// エンティティへ格納.
			users = new Users();
			users.setUserId(userId);
			users.setPassword(password);
			users.setUserId(userId);
			users.setFamilyName(familyName);
			users.setFirstName(firstName);
			users.setFamilyNameFurigana(familyNameFurigana);
			users.setFirstNameFurigana(firstNameFurigana);
			users.setBirthDay(java.sql.Date.valueOf(birthday));
			users.setAddressPrefectures(addressPrefectures);
			users.setAddressMunicipality(addressMunicipality);
			users.setEmailAddress(emailAddress);
			//users.setPhoneNumber(Integer.parseInt(phonenumber));
			users.setPhoneNumber(phoneNumber2);

			// 検証1：ユーザーID.

			// ユーザーID重複検証.

			// 検証用変数.
			boolean userIdCheakFlag = false;

			UsersDao dao = null;

			try {

				dao = new UsersDao();

			} catch (Exception e) {
				e.printStackTrace();

			}

			// DaoメソッドでユーザーIDを全部取得.
			List<String> userIdAllList = dao.userIdAllGet();

			for (int i = 0; i < userIdAllList.size(); i++) {

				// リスト内のIDと合致するか検証.
				if (userIdAllList.get(i).equals(userId)) {

					// フラグオン.
					userIdCheakFlag = true;

					// 合致したら抜ける.
					break;

				}

			}

			if (userIdCheakFlag) {

				// 注意メッセージ格納.
				attentionMessageList.add("ユーザーID：すでに登録されています。");

			} else {

				// ユーザーID：文字数.
				if (3 <= userId.length() && userId.length() <= 10) {

					integrityCheckFlag++;

				} else {

					// 注意メッセージ格納.
					attentionMessageList.add("ユーザーID：文字数を確認してください。");

				}
			}

			// 検証2：パスワード(文字数).
			if (10 <= password.length() && password.length() <= 20) {

				integrityCheckFlag++;

			} else {

				// 注意メッセージ格納.
				attentionMessageList.add("パスワード：文字数を確認してください。");

			}

			// 検証3：氏名(文字数).
			if (familyName.length() <= 10 && firstName.length() <= 10 && familyNameFurigana.length() <= 10
					&& firstNameFurigana.length() <= 10) {

				integrityCheckFlag++;

			} else {

				// 注意メッセージ格納.
				attentionMessageList.add("氏名・フリガナ：文字数を確認してください。");

			}

			// 検証4：生年月日.
			// 日付比較用変数.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date upperLimitBirthday = null;
			Date lowerLimitBirthday = null;
			Date dateBirthday = null;

			// 上限：本日(+1).
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_MONTH, +1);
			upperLimitBirthday = calendar1.getTime();

			// 下限：人類の最高齢は122歳らしいので120年を限度とする.
			Calendar calendar2 = Calendar.getInstance();
			calendar2.add(Calendar.YEAR, -120);
			lowerLimitBirthday = calendar2.getTime();

			// 比較値；入力値.
			try {

				dateBirthday = sdf.parse(birthday);

			} catch (Exception e) {

				e.printStackTrace();
			}

			// Date型で比較.
			if (lowerLimitBirthday.before(dateBirthday) && upperLimitBirthday.after(dateBirthday)) {

				integrityCheckFlag++;

			} else {

				// 注意メッセージ格納.
				attentionMessageList.add("生年月日：無効な日付です。");

			}

			// 検証5：住所.

			// 都道府県配列.
			String[] japanPrefectures = { "北海道", "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県", "茨城県", "栃木県", "群馬県", "埼玉県",
					"千葉県", "東京都", "神奈川県", "新潟県", "富山県", "石川県", "福井県", "山梨県", "長野県", "岐阜県", "静岡県", "愛知県", "三重県", "滋賀県",
					"京都府", "大阪府", "兵庫県", "奈良県", "和歌山県", "鳥取県", "島根県", "岡山県", "広島県", "山口県", "徳島県", "香川県", "愛媛県", "高知県",
					"福岡県", "佐賀県", "長崎県", "熊本県", "大分県", "宮崎県", "鹿児島県", "沖縄県" };

			// 都道府県検証用変数.
			boolean prefecturesCheckFlag = false;

			for (String prefectures : japanPrefectures) {

				if (prefectures.equals(addressPrefectures)) {

					// 都道府県フラグオン.
					prefecturesCheckFlag = true;

					// 合致したら抜ける.
					break;

				}

			}

			if (!prefecturesCheckFlag) {

				// 注意メッセージ格納.
				attentionMessageList.add("住所：無効な選択肢です。");

			} else {

				// 住所：文字数.
				if (addressMunicipality.length() <= 100) {

					integrityCheckFlag++;

				} else {

					// 注意メッセージ格納.
					attentionMessageList.add("住所：文字数を確認してください。");

				}

			}

			// 検証6：メールアドレス.
			if (emailAddress.contains("@gmail.com")) {

				if (emailAddress.length() <= 50) {

					integrityCheckFlag++;

				} else {

					// 注意メッセージ格納.
					attentionMessageList.add("メールアドレス：文字数を確認してください。");

				}

			} else {

				// 注意メッセージ格納.
				attentionMessageList.add("メールアドレス：gmailのアドレスを入れてください。");

			}

			// 検証7：電話番号.
			if (phonenumber.contains("0120") || phonenumber.contains("090")) {

				if (phonenumber.length() <= 15) {

					integrityCheckFlag++;

				} else {

					// 注意メッセージ格納.
					attentionMessageList.add("電話番号：文字数を確認してください。");

				}

			} else {

				// 注意メッセージ格納.
				attentionMessageList.add("電話番号：090または0120から始まる番号を入れてください。");

			}

		}

		// 検証結果総合判断.(チェックフラグの数で分岐).
		if (integrityCheckFlag == 7) {

			// エンティティをセッションへ送る.
			HttpSession session = request.getSession(true);
			session.setAttribute("users", users);

			// フォワード先変更(プレビュー画面へ).
			path = "/Users/userNewRegistrationPreview.jsp";

		} else {

			// 注意メッセージをリクエストへ送る.
			request.setAttribute("attentionMessageList", attentionMessageList);

			// フォワード先変更(登録画面へ).
			path = "/Users/userNewRegistration.jsp";

		}

		// フォワード.
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
