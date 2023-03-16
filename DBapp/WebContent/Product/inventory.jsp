<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,entity.*,java.text.*"%>
<%

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

		<table>
			<tr  align="center"><td>ID</td><td>商品名</td><td>価格</td><td>個数</td><td>更新日時</td></tr>

<% 			for(int i = 0 ; i < productList.size(); i++){%>

				<tr>
					<td align="right"><%=i+1%></td>
					<td align="center"><%=productList.get(i).getName()%></td>
					<td align="right"><%=commaFormat.format(productList.get(i).getPrice())%>円</td>
					<td align="right"><%=commaFormat.format(productList.get(i).getStock())%></td>
					<td align="right"><%=sdf.format(productList.get(i).getStockUpdateTime())%></td>
				</tr>

<%			} %>

		</table>

		<br>
		<a href="/DBapp/Product/menu_productManagement.jsp">商品管理画面へ</a>

	</body>

</html>