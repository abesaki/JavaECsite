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
		<title>商品削除</title>
	</head>

	<body>

		削除する商品を選択してください。<br>

		<br>

		<form action="/DBapp/ProductDeletionServlet" method="post">

			<label for="name">商品名：</label>

			<select name="name" id="name">
<% 				for(int i = 0; i < productList.size() ; i++ ) {%>
					<option value="<%=productList.get(i).getName()%>"><%=productList.get(i).getName()%></option>
<% 				}%>
			</select>

			<input type="submit" value="削除">

		</form>

		<br>
		<a href="/DBapp/Product/menu_productManagement.jsp">前のページへ戻る</a><br>
		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ戻る</a>

	</body>

</html>