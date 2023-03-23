<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,dao.*,entity.*" %>

<%

	//ユーザーID一覧メソッド呼び出し（プルダウン用）.
	UsersDao dao = new UsersDao();
	List<String> userIdAllList = dao.usersIdAllGet();

%>

<!DOCTYPE html>
<html>

	<head>
		<title>アカウント削除画面</title>
	</head>

	<body>
		削除するユーザーを選択してください。<br>

		<br>

		<form action="/DBapp//Users/userDeletionPreview.jsp">

			<label for="userid">ユーザーID：</label>

			<select name="userid" id="userid">
<% 				for(int i = 0; i < userIdAllList.size() ; i++ ) {%>
					<option value="<%=userIdAllList.get(i)%>"><%=userIdAllList.get(i)%></option>
<% 				}%>
			</select>

			<input type="submit" value="削除">

		</form>

		<br>
		<a href="/DBapp/Users/menu_usersManagement.jsp">前のページへ戻る</a><br>
		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ戻る</a>

	</body>

</html>