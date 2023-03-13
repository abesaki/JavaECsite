<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="dao.*,entity.*,java.util.*,java.text.*" %>

<%

	//セッションからidを受取.
	String userId = (String)session.getAttribute("userId");

	//DAOの最新ニュース取得メソッド呼び出し.
	News latestNews = NewsDao.latestNewsAcquisition();

	//現在時刻.
	Date date = new Date();

	//時計用フォーマット.
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy年MM月dd日");
	SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");

	String today = yyyyMMdd.format(date);
	String clock = hhmm.format(date);

	//メッセージ取得.
	String message = (String)request.getAttribute("message");

%>

<!DOCTYPE html>
<html>

	<head>
		<title>ようこそ</title>
	</head>

	<body>
		ようこそ <%=userId%> さん<br>
		<br>
		<%=today%> <%=clock%><br>

<%		if(message != null) {%>

			<p style="color: red"><%=message%></p>

<% 		}%>

<% 		if(latestNews.getTitle() == null || latestNews.getBody()  == null || latestNews.getAuthor() == null ){%>
			<p style="color: red;">ニュースを取得できませんでした。</p>

<% 		} else {%>
			<marquee scrollamount="3" width="500px">ニュース：【<%=latestNews.getTitle()%>】<%=latestNews.getBody()%>（<%=latestNews.getAuthor()%>）</marquee>

<%		} %>

		<ul>
			<li><a href="/DBapp/ProductListSearchServlet">商品一覧</a></li>
			<li><a href="/DBapp/Shopping/shoppingCart.jsp">カートを見る</a></li>
			<li><a href="/DBapp/OrderHistoryServlet">注文履歴</a></li>
			<li>会員メニュー</li>
		</ul>

		<a href="/DBapp/LogoutServlet">ログアウトする</a>
	</body>

</html>