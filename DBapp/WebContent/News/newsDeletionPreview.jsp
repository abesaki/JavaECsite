<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="entity.*,java.util.*" %>

<%
	//リクエストから処理結果メッセージ取得.
	String searchResult = (String)request.getAttribute("searchResult");

	//リクエストからリストの受取.
	List<News> newsList = (List<News>)request.getAttribute("newsList");

%>

<!DOCTYPE html>
<html>

	<head>
		<title>ニュース削除プレビュー</title>
		<style>
			table{border-collapse: collapse; height: 100px; width:1200px;}
			td{border: 1px solid; padding-left: 10px;}
		</style>
	</head>

	<body>

		<%=searchResult%><br>

<%		for ( int i = 0; i < newsList.size() ; i++){ %>
			<table>
				<tr><td width ="100px">日付：</td><td><%=newsList.get(i).getDate()%></td></tr>
				<tr><td width ="100px">タイトル：</td><td><%=newsList.get(i).getTitle()%></td></tr>
				<tr><td width ="100px">本文：</td><td><%=newsList.get(i).getBody()%></td></tr>
				<tr><td width ="100px">記述者：</td><td><%=newsList.get(i).getAuthor()%></td></tr>
			</table>
			<br>
<%		}%>

		<a href="/DBapp/NewsDeletionServlet?action=commit">確定する</a>　
		<a href="/DBapp/NewsDeletionServlet?action=rollback">キャンセル</a><br>
		<br>
		<a href="/DBapp/News/menu_newsmanagement.jsp">ニュース管理メニューへ戻る</a>

	</body>

</html>