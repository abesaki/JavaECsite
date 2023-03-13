<%@ page contentType="text/html; charset=UTF-8"%>

<%@	page import="java.util.*,java.text.*" %>

<%

	//セッションから各種パラメータを受取.
	List<Object> parametersList = (List<Object>)session.getAttribute("parametersList");

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
					<td align="right"><label for="userId">ユーザーID：</label></td>
					<td><%=parametersList.get(0)%></td>
				</tr>

				<tr>
					<td align="right"><label for="password">パスワード：</label></td>
					<td><%=parametersList.get(1)%></td>
				</tr>

				<tr>
					<td align="right"><label for="name">氏名：</label></td>
					<td><%=parametersList.get(2)%> <%=parametersList.get(3)%></td>
				</tr>

				<tr>
					<td align="right"><label for="furigana">フリガナ：</label></td>
					<td><%=parametersList.get(4)%> <%=parametersList.get(5)%></td>
				</tr>

				<tr>
					<td align="right"><label for="gender">性別：</label></td>
					<td><%=parametersList.get(6)%></td>
				</tr>

				<tr>
					<td align="right"><label for="birthday">生年月日：</label></td>
					<td><%=parametersList.get(7)%></td>
				</tr>

				<tr>
					<td align="right"><label for="address">住所：</label></td>
					<td><%=parametersList.get(8)%><%=parametersList.get(9)%></td>
				</tr>

				<tr>
					<td align="right"><label for="emailAddress">メールアドレス：</label></td>
					<td><%=parametersList.get(10)%></td>
				</tr>

				<tr>
					<td align="right"><label for="phonenumber">電話番号：</label></td>
					<td><%=parametersList.get(11)%></td>
				</tr>

				<tr>
					<td></td>
					<td align="right"><input type="submit" value="登録する"> <a href="/DBapp/UserNewRegistrationServlet"><input type="button" value="キャンセル"></a></td>
				</tr>

			</table>

		</form>

	</body>

</html>