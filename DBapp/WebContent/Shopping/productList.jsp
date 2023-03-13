<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,entity.*,java.text.*" %>

<%
	//画像は直リン<img src="https://source.unsplash.com/xxxxxx">.

	//リクエストからリストを取得.
	List<Product> productList = (List<Product>)request.getAttribute("productList");

	//日時用フォーマット.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	//数字用フォーマット.
	NumberFormat commaFormat = NumberFormat.getNumberInstance(); //カンマ区切り

%>

<!DOCTYPE html>
<html>

	<head>
		<title>在庫一覧</title>
		<style>
			table{margin-top: 20px; border-collapse: collapse;}
			table td{border: 1px solid; border-collapse: collapse; padding: 10px;}
		</style>
	</head>

	<body>

		<form action="/DBapp/ShoppingCartAddServlet" method="post">

			<table>

				<tr align="center"><td>ID</td><td>商品名</td><td>価格</td><td>在庫数</td><td>購入数</td></tr>

<% 			for(int i = 0 ; i < productList.size(); i++){%>

				<tr align="right">
					<td><%=i+1%></td>
					<td align="center"><input type="hidden" name="name" value="<%=productList.get(i).getName()%>"><%=productList.get(i).getName()%></td>
					<td><input type="hidden" name="price" value="<%=productList.get(i).getPrice()%>"><%=commaFormat.format(productList.get(i).getPrice())%>円</td>
					<td><%=commaFormat.format(productList.get(i).getCount())%></td>
					<td align="right"><input type="number" name="buyCount" size="5" min="0" max="10000" value="0"></td>
				</tr>

<%			} %>

			</table>

			<br>
			<input type="submit" value="カートに入れる">

		</form>

		<br>
		<a href="/DBapp/Menu/menu_normalUser.jsp">メニュー画面へ</a>

	</body>
</html>