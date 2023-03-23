<%@ page contentType="text/html; charset=UTF-8"%>
<%

	//リクエストから処理結果メッセージ取得.
	String sqlProcessResult = (String)request.getAttribute("sqlProcessResult");

%>
<!DOCTYPE html>
<html>

	<head>
		<title>ユーザー管理画面</title>
	</head>

	<body>

<%		if(sqlProcessResult != null) {%>

			<%=sqlProcessResult%>

<% 		}%>

			<ul>
				<li><a href="/DBapp/Users/registeredUsersInformationView.jsp">アカウント一覧</a></li>
				<li><a href="/DBapp/Users/userNewRegistration.jsp">アカウント登録</a></li>
				<li>アカウント情報変更</li>
				<li><a href="/DBapp/Users/userDeletionSelect.jsp">アカウント削除</a></li>
			</ul>

		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ</a>

	</body>


	</body>

</html>