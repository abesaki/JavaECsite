<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.text.*,dao.*,entity.*" %>

<%
	//パラメータの受取
	String userid = request.getParameter("userid");

	//受け取ったユーザーIDを使ってユーザー情報を取得.
	UsersDao dao = new UsersDao();
	Users users = dao.usersInformationSearchByUserId(userid);

	//生年月日用フォーマット.
	SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy年MM月dd日");

	//タイムスタンプ用フォーマット.
	SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>

<!DOCTYPE html>
<html>

	<head>
		<title>アカウント削除画面</title>
		<link rel="stylesheet" type="text/css" href="../CSS/common.css">
	</head>

	<body>
		削除するユーザーの情報は以下です。<br>

		<br>

		<form action="/DBapp/UserDeletionServlet" method="post">

		<table>

			<tr align="center"><td>ユーザーID</td><td>パスワード</td><td>名字</td><td>名前</td><td>ミョウジ</td><td>ナマエ</td><td>生年月日</td><td>都道府県</td><td>住所</td><td>メールアドレス</td><td>電話番号</td><td>登録日</td><td>更新日</td></tr>

			<tr>
				<td><input type="hidden" value="<%=users.getUserId()%>"><%=users.getUserId()%></td>
				<td><input type="hidden" value="<%=users.getPassword()%>"><%=users.getPassword()%></td>
				<td><input type="hidden" value="<%=users.getFamilyName()%>"><%=users.getFamilyName()%></td>
				<td><input type="hidden" value="<%=users.getFirstName()%>"><%=users.getFirstName()%></td>
				<td><input type="hidden" value="<%=users.getFamilyNameFurigana()%>"><%=users.getFamilyNameFurigana()%></td>
				<td><input type="hidden" value="<%=users.getFirstNameFurigana()%>"><%=users.getFirstNameFurigana()%></td>


				<td><input type="hidden" value="<%=users.getBirthDay()%>">

<%				//rootのnull対策用if分岐(フォーマット). %>

<%				if(users.getBirthDay() == null){ %>

					<%=birthDayFormat.format(users.getBirthDay())%>

<%				} else { %>

					<%=users.getBirthDay()%>

<%				} %>

				</td>
				<td><input type="hidden" value="<%=users.getAddressPrefectures()%>"><%=users.getAddressPrefectures()%></td>
				<td><input type="hidden" value="<%=users.getAddressMunicipality()%>"><%=users.getAddressMunicipality()%></td>
				<td><input type="hidden" value="<%=users.getEmailAddress()%>"><%=users.getEmailAddress()%></td>
				<td><input type="hidden" value="<%=users.getPhoneNumber()%>"><%=users.getPhoneNumber()%></td>
				<td><input type="hidden" value="<%=users.getRegistrationDate()%>"><%=timeStampFormat.format(users.getRegistrationDate())%></td>
				<td><input type="hidden" value="<%=users.getUpdatedDate()%>"><%=timeStampFormat.format(users.getUpdatedDate())%></td>
			</tr>

		</table>

			<input type="submit" value="削除">

		</form>

		<br>
		<a href="/DBapp/Users/menu_usersManagement.jsp">前のページへ戻る</a><br>
		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ戻る</a>

	</body>

</html>