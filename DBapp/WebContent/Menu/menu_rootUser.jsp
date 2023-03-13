<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="dao.*,entity.*,java.util.*,java.text.*" %>

<%
	//セッションからidを受取.
	String userId = (String)session.getAttribute("userId");

	//DAOの最新ニュース取得メソッド呼び出し.
	//NewsDao newsdao = new NewsDao();
	News latestNews = NewsDao.latestNewsAcquisition();

	//現在時刻.
	Date date = new Date();

	//時計用フォーマット.
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy年MM月dd日");
	SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");

	String today = yyyyMMdd.format(date);
	String clock = hhmm.format(date);

%>

<!DOCTYPE html>
<html>

	<head>
		<title>ようこそ</title>
	</head>

	<body>
		ようこそ <%=userId%> さん<br>
		<br>
		<%=today%> <span id="real-time"></span><br>

		  <script type="text/javascript">
				function Time() {
   					var realTime = new Date();
   					var hour = realTime.getHours();
  					var minutes  = realTime.getMinutes();
   					var text = hour + ":" + minutes;
   					document.getElementById("real-time").innerHTML = text;
				}
				setInterval('Time()',1000);
  		</script>

<% 		if(latestNews.getTitle() == null || latestNews.getBody()  == null || latestNews.getAuthor() == null ){%>
			<p style="color: red;">ニュースを取得できませんでした。</p>

<% 		} else {%>
			<marquee scrollamount="3" width="500px">ニュース：【<%=latestNews.getTitle()%>】<%=latestNews.getBody()%>（<%=latestNews.getAuthor()%>）</marquee>

<%		} %>

		<ul>
			<li><a href="/DBapp/Product/menu_productManagement.jsp">商品管理</a></li>
			<li><a href="/DBapp/News/menu_newsManagement.jsp">ニュース管理</a></li>
			<li>ユーザー管理</li>
		</ul>

		<a href="/DBapp/LogoutServlet">ログアウトする</a>
	</body>

</html>