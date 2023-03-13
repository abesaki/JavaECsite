<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="entity.*,java.util.*" %>

<%
	//リクエストから処理結果メッセージ取得.
	String createResult = (String)request.getAttribute("createResult");

	//リクエストから各種データの受取.
	String date = (String)request.getAttribute("date");
	String title = (String)request.getAttribute("title");
	String body = (String)request.getAttribute("body");
	String author = (String)request.getAttribute("author");

%>

<!DOCTYPE html>
<html>

	<head>
		<title>ニュース作成プレビュー</title>
	</head>

	<body>

		<%=createResult%><br>

		<table>
			<tr><td>日付：</td><td><%=date%><tr><td>
			<tr><td>タイトル：</td><td><%=title%><tr><td>
			<tr><td>本文：</td><td><%=body%><tr><td>
			<tr><td>記述者：</td><td><%=author%><tr><td>
		</table>

		<a href="/DBapp/NewsCreationServlet?action=commit">確定する</a>　
		<a href="/DBapp/NewsCreationServlet?action=rollback">キャンセル</a><br>
		<br>
		<a href="/DBapp/News/menu_newsmanagement.jsp">ニュース管理メニューへ戻る</a>

	</body>

</html>