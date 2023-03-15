<%@ page contentType="text/html; charset=UTF-8"%>

<%@	page import="java.util.*,java.text.*,entity.*" %>

<%

	//セッションからエンティティを受取.
	Users users = (Users)session.getAttribute("users");

%>

<!DOCTYPE html>

<html>

	<head>
		<title>ユーザー登録確認</title>
	</head>

	<body>

		入力された情報は以下です。登録しますか？<br>

		<form action="/DBapp/UserNewRegistrationServlet" method="post">

			<table>

				<tr>
					<td align="right">ユーザーID：</td>
					<td><%=users.getUserId()%></td>
				</tr>

				<tr>
					<td align="right">パスワード：</td>
					<td><%=users.getPassword()%></td>
				</tr>

				<tr>
					<td align="right">氏名：</td>
					<td><%=users.getFamilyName()%> <%=users.getFirstName()%></td>
				</tr>

				<tr>
					<td align="right">フリガナ：</td>
					<td><%=users.getFamilyNameFurigana()%> <%=users.getFirstNameFurigana()%></td>
				</tr>

				<tr>
					<td align="right">生年月日：</td>
					<td><%=users.getBirthDay()%></td>
				</tr>

				<tr>
					<td align="right">住所：</td>
					<td><%=users.getAddressPrefectures()%><%=users.getAddressMunicipality()%></td>
				</tr>

				<tr>
					<td align="right">メールアドレス：</td>
					<td><%=users.getEmailAddress()%></td>
				</tr>

				<tr>
					<td align="right">電話番号：</td>
					<td><%=users.getPhoneNumber()%></td>
				</tr>

				<tr>
					<td></td>
					<td align="right"><input type="submit" value="登録する"> <a href="/DBapp/UserNewRegistrationServlet"><input type="button" value="キャンセル"></a></td>
				</tr>

			</table>

		</form>

	</body>

</html>