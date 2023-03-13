<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,java.text.*,dao.*,entity.*"%>

<%
	//商品一覧メソッド呼び出し(プルダウン用).
	ProductDao dao = new ProductDao();
	List<Product> productList = dao.searchProductAll();

	//日時用フォーマット.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	//数字用フォーマット.
	NumberFormat commaFormat = NumberFormat.getNumberInstance(); //カンマ区切り

%>

<!DOCTYPE html>
<html>

	<head>
		<title>自動発注設定画面</title>
	</head>

	<body>

		自動で発注する数を入力してください。<br>
		<br><table>
			<tr  align="center"><td>ID</td><td>商品名</td><td>設定数</td><td>個数</td><td>更新日時</td></tr>

<% 			for(int i = 0 ; i < productList.size(); i++){%>

				<tr>
					<td align="right"><%=i+1%></td>
					<td align="center"><%=productList.get(i).getName()%></td>
					<td align="right"><%=commaFormat.format(productList.get(i).getPrice())%>円</td>
					<td align="right"><%=commaFormat.format(productList.get(i).getCount())%></td>
					<td align="right"><%=sdf.format(productList.get(i).getTimeStamp())%></td>
				</tr>

<%			} %>

		</table>

		<br>
		<a href="/DBapp/Product/menu_productManagement.jsp">前のページへ戻る</a><br>
		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ戻る</a>

	</body>

</html>