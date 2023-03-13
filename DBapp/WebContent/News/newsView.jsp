<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="entity.*,dao.*,java.util.*" %>

<%

	//リクエストから処理結果メッセージ取得.
	String sortResult = (String)request.getAttribute("sortResult");

	//リクエストから処理結果メッセージ取得.
	String searchResult = (String)request.getAttribute("searchResult");

	//リストを置いておく.
	List<News> newsList = null;

	//パターンフラグ.
	boolean sortFlag = false;
	boolean searchFlag = false;

%>

<!DOCTYPE html>
<html>

	<head>
		<title>ニュース閲覧</title>
		<style>
			table{border-collapse: collapse; height: 100px; width:1200px;}
			td{border: 1px solid; padding-left: 10px;}
		</style>
	</head>

	<body>

		<br>
		<form method="post">
    		<input type="submit" value="日付（昇順）" name="dateButton" formaction="/DBapp/NewsSortServlet">
    		<input type="submit" value="日付（降順）" name="dateButton" formaction="/DBapp/NewsSortServlet">
    		<input type="submit" value="元に戻す" formaction="/DBapp/News/newsView.jsp">
    		<input type="text"size="50" name="inputString" placeholder="検索したい文字を入力してください。">
    		<input type="submit" value="検索" formaction="/DBapp/NewsSearchServlet">
		</form>
		<br>

<% 		if(searchResult != null) {

			newsList = (List<News>)request.getAttribute("newsList");
			searchFlag = true;%>

			<%=searchResult%><br>

<% 		}%>

<%		if(sortResult != null) {

			//リクエストからリストの受取.
			newsList = (List<News>)request.getAttribute("newsList");
			sortFlag = true;%>

			<%=sortResult%><br>

<%		}

		if (!searchFlag && !sortFlag) {

			// 記事全件検索メソッド呼び出し.
			newsList = NewsDao.searchNews();

		}

		for ( int i = 0; i < newsList.size() ; i++){ %>
				<table>
					<tr><td width ="100px">日付：</td><td><%=newsList.get(i).getDate()%></td></tr>
					<tr><td width ="100px">タイトル：</td><td><%=newsList.get(i).getTitle()%></td></tr>
					<tr><td width ="100px">本文：</td><td><%=newsList.get(i).getBody()%></td></tr>
					<tr><td width ="100px">記述者：</td><td><%=newsList.get(i).getAuthor()%></td></tr>
				</table>
				<br>

<% 		}%>

		<a href="/DBapp/News/menu_newsManagement.jsp">ニュース管理メニューへ戻る</a>

	</body>

</html>