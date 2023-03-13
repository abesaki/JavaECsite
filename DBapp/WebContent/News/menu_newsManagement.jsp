<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String transactionResultMessage = (String)request.getAttribute("transactionResultMessage");

%>

<!DOCTYPE html>
<html>

	<head>
		<title>ニュース管理画面</title>
	</head>

	<body>

<% 			if (transactionResultMessage != null) {%>

				<%=transactionResultMessage%>

<%			}%>

			<ul>
				<li><a href="/DBapp/News/newsCreation.jsp">記事作成</a></li>
				<li><a href="/DBapp/News/newsView.jsp">記事閲覧</a></li>
				<li><a href="/DBapp/News/newsDeletion.jsp">記事削除</a></li>
				<li><a href="/DBapp/Menu/menu_rootUser.jsp">メニューに戻る</a></li>
			</ul>

	</body>

</html>