<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.*,entity.*" %>

<%
	//リクエストからリストを取得.
	List<Orders> ordersHistoryList = (List<Orders>)request.getAttribute("ordersHistoryList");

	//日時用フォーマット.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	//数字用フォーマット.
	NumberFormat commaFormat = NumberFormat.getNumberInstance(); //カンマ区切り
%>

<!DOCTYPE html>
<html>

	<head>
		<title>注文履歴</title>
		<style>
			table{margin-top: 20px; border-collapse: collapse;}
			table td{border: 1px solid; border-collapse: collapse; padding: 10px;}
		</style>
	</head>

	<body>

		<table>

			<tr align="center"><td>No</td><td>商品名</td><td>価格</td><td>個数</td><td>合計</td><td>注文日</td></tr>

<% 		for(int i = 0 ; i < ordersHistoryList.size(); i++){%>

			<tr align="right">
				<td><%=i+1%></td>
				<td align="center"><%=ordersHistoryList.get(i).getProductName()%></td>
				<td><%=commaFormat.format(ordersHistoryList.get(i).getPrice())%>円</td>
				<td><%=commaFormat.format(ordersHistoryList.get(i).getBuyCount())%>個</td>
				<td><%=commaFormat.format((ordersHistoryList.get(i).getPrice()) * ordersHistoryList.get(i).getBuyCount())%>円</td>
				<td><%=sdf.format(ordersHistoryList.get(i).getTimeStamp()) %></td>
				</tr>

<%		} %>

		</table>

		<br>

		<a href="/DBapp/Menu/menu_normalUser.jsp">メニュー画面へ</a>

	</body>
</html>