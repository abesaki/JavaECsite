<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,dao.*,entity.*" %>

<%
	//商品一覧メソッド呼び出し(プルダウン用).
	ProductDao dao = new ProductDao();
	List<Product> productList = dao.searchProductAll();
%>

<!DOCTYPE html>
<html>

	<head>
		<title>在庫数追加</title>
	</head>

	<body>

		追加する商品名を選び、個数を入力してください。<br>
		<br>

		<form action="/DBapp/StockCountAddServlet" method="post">

			<table>
				<tr align="right">
					<td><label for="name">商品名：</label></td>
					<td><select name="name" id="name">
<% 						for(int i = 0; i < productList.size() ; i++ ) {%>
							<option value="<%=productList.get(i).getName()%>"><%=productList.get(i).getName()%></option>
<% 						}%>
						</select>
					</td>
				</tr>

				<tr>
					<td><label for="count">個数：</label></td>
					<td><input type="number" name="count" id="count" min="0" max="10000" required></td>
				</tr>

			</table>

			<input type="submit" value="追加">

		</form>

		<br>
		<a href="/DBapp/Product/menu_productManagement.jsp">前のページへ戻る</a><br>
		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ戻る</a>

	</body>

</html>