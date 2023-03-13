<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.text.*,entity.*" %>

<%

	List<Orders> ordersList = (List<Orders>)session.getAttribute("ordersList");

	//セッションからidを受取.
	String userId = (String)session.getAttribute("userId");

	//数字用フォーマット.
	NumberFormat commaFormat = NumberFormat.getNumberInstance(); //カンマ区切り

%>

<!DOCTYPE html>
<html>

	<head>
		<title>カート</title>
		<style>
			table{margin-top: 20px; border-collapse: collapse;}
			table td{border: 1px solid; border-collapse: collapse; padding: 10px;}
		</style>
	</head>

	<body>

		<%=userId %>さん<br>
		<br>

<% 		if(ordersList == null || ordersList.size() == 0 ){%>

			<p style="color: red">カート内に商品はありません。</p>

<% 		} else	{%>

		カート内の商品<br>

		<form action="/DBapp/ProductBuyServlet" method="post">
		<table>

			<tr align="center"><td>商品名</td><td>価格</td><td>購入数</td><td>合計</td></tr>

<% 		for(int i = 0; i < ordersList.size(); i++){%>

<% 			if(ordersList.get(i).getBuyCount() != 0) {%>

			<tr align="right">
				<td align="center"><%=ordersList.get(i).getProductName() %></td>
				<td><%=commaFormat.format(ordersList.get(i).getPrice()) %>円</td>
				<td><%=commaFormat.format(ordersList.get(i).getBuyCount()) %>個</td>
				<td><%=commaFormat.format((ordersList.get(i).getPrice()) * ordersList.get(i).getBuyCount())%>円</td>
			</tr>

<% 			}%>
<%		} %>

		</table>

		<br>
			<input type="submit" value="購入する">　<a href="/DBapp/ProductBuyServlet"><button type="button">キャンセルする</button></a>
		</form>
<%		} %>
		<br>
		<a href="/DBapp/Menu/menu_normalUser.jsp">前の画面に戻る</a>
	</body>

</html>