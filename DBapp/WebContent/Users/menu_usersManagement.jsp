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
				<li>アカウント一覧</li>
				<li>アカウント登録</li>
				<li>アカウント情報変更</li>
				<li>アカウント削除</li>
			</ul>

		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ</a>

	</body>


	</body>

</html>