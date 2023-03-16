<%@ page contentType="text/html; charset=UTF-8"%>

<%@	page import="java.util.*,java.text.*" %>

<%
	//デフォルト値用：日付取得.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(new Date());

	//日付；下限.
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.YEAR,-120);
	String lowerLimitBirthday = sdf.format(calendar.getTime());

	//プルダウン用配列.
	String[] japanPrefectures = {"北海道", "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県", "茨城県", "栃木県", "群馬県", "埼玉県", "千葉県",
									"東京都", "神奈川県", "新潟県", "富山県", "石川県",	"福井県", "山梨県",	"長野県", "岐阜県",	"静岡県", "愛知県",	"三重県",
									"滋賀県", "京都府",	"大阪府", "兵庫県",	"奈良県", "和歌山県", "鳥取県", "島根県", "岡山県", "広島県", "山口県", "徳島県",
									"香川県", "愛媛県",	"高知県", "福岡県",	"佐賀県", "長崎県",	"熊本県", "大分県",	"宮崎県", "鹿児島県", "沖縄県"};

	//リクエストから注意メッセージを受取.
	List<String> attentionMessageList = (List<String>)request.getAttribute("attentionMessageList");

%>


<!DOCTYPE html>

<html>

	<head>
		<title>新規登録ページ</title>
	</head>

	<body>

		新規登録画面へようこそ！
		<font size="2">　登録済みユーザーの方は<a href="/DBapp/login_logout/login.jsp">こちら</a></font><br>

<% 		if( attentionMessageList != null) {%>

<%			for(int i = 0; i < attentionMessageList.size() ; i++) { %>

				<font color="red"><%=attentionMessageList.get(i) %></font><br>

<%			} %>

<%		} else {%>

			<br>

<% 		} %>

		登録に必要な情報を記入してください。<br>

		<form action="/DBapp/RegistrationConfirmationServlet" method="post">

			<table>
				<tr>
					<td align="right"><label for="userId">ユーザーID：</label></td>
					<td><input type="text" name="userId" id="userId" placeholder="3～10文字" size="10"></td>
				</tr>

				<tr>
					<td align="right"><label for="password">パスワード：</label></td>
					<td><input type="password" name="password" id="password" placeholder="10～20文字"" size="20"></td>
				</tr>

				<tr>
					<td align="right"><label for="name">氏名：</label></td>
					<td><input type="text" name="familyName" id="name" size="6" placeholder="苗字">
						<input type="text" name="firstName" id="name" size="6" placeholder="名前"></td>
				</tr>

				<tr>
					<td align="right"><label for="furigana">フリガナ：</label></td>
					<td><input type="text" name="familyNameFurigana" id="furigana" size="6" placeholder="ミョウジ">
						<input type="text" name="firstNameFurigana" id="furigana" size="6" placeholder="ナマエ"></td>
				</tr>

				<tr>
					<td align="right"><label for="birthday">生年月日：</label></td>
					<td><input type="date" name="birthday" id="birthday"></td>
				</tr>

				<tr>
					<td align="right"><label for="address">住所：</label></td>
					<td><select name="addressPrefectures" id="address">
<% 							for(int i = 0; i < japanPrefectures.length ; i++ ) {%>
								<option value="<%=japanPrefectures[i]%>"><%=japanPrefectures[i]%></option>
<% 							}%>
						</select>
						<input type="text" name="addressMunicipality" id="address" placeholder="市町村以降"></td>
				</tr>

				<tr>
					<td align="right"><label for="emailAddress">メールアドレス：</label></td>
					<td><input type="text" name="emailAddress" id="emailAddress" placeholder="abc@example.com"></td>
				</tr>

				<tr>
					<td align="right"><label for="phonenumber">電話番号：</label></td>
					<td><input type="tel" name="phonenumber" id="phonenumber" placeholder="0123-4567-8900"></td>
				</tr>

			</table>

			<input type="submit" value="確認する">　<input type="reset">

		</form>

	</body>

</html>