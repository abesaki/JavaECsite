<%@ page contentType="text/html; charset=UTF-8"%>

<%
	//エラーメッセージ取得.
	String loginError = (String)request.getAttribute("loginError");

	//登録メッセージ取得.
	String registResultMessage = (String)request.getAttribute("registResultMessage");

	//<label>の<for>と<input>の<id>は同名（リンクさせる）

%>

<!DOCTYPE html>
<html>

	<head>

		<title>ログイン画面</title>

	</head>

	<body>

		IDとパスワードを入力してください。　<font size="2">	新規登録は<a href="/DBapp//Users/userNewRegistration.jsp">こちら</a></font><br>


<%		if(loginError != null) {%>

			<p style="color: red;"><%=loginError%></p>

<%		}%>

<%		if(registResultMessage != null) {%>

			<p style="color: red;"><%=registResultMessage%></p>

<%		}%>

		<form action="/DBapp/LoginServlet" method="post">

		<table>

			<tr>
				<td><label for="userId">ユーザーID：</label></td>
				<td><input type="text" name="userId" id="userId" size="9"></td>
			</tr>

			<tr>
				<td><label for="password">パスワード：</label></td>
				<td><input type="password" name="password" id="password" size="10"></td>
			</tr>

		</table>

		<input type="submit" value="ログイン"><br>

		</form>

	</body>

</html>