<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,java.text.*,dao.*,entity.*"%>

<%

	//自動発注設定取得メソッド呼び出し.
	ProductDao dao = new ProductDao();
	List<Product> productSettingList = dao.productSettingGet();

	//日時用フォーマット.

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	//数字用フォーマット.
	NumberFormat commaFormat = NumberFormat.getNumberInstance(); //カンマ区切り

%>

<!DOCTYPE html>
<html>

	<head>
		<title>自動発注設定画面</title>
		<style>
			table{margin-top: 20px; border-collapse: collapse;}
			table td{border: 1px solid; border-collapse: collapse; padding: 10px;}
		</style>
	</head>

	<body>

		自動で発注する数を入力してください。<br>
		<table>
			<tr  align="center"><td>ID</td><td>商品名</td><td>在庫数</td><td>下限数</td><td>発注数</td><td>更新日時</td></tr>

<% 		for(int i = 0 ; i < productSettingList.size(); i++){%>

				<tr>
					<td align="right"><%=i+1%></td>
					<td align="center"><%=productSettingList.get(i).getName()%></td>
					<td align="right"><%=commaFormat.format(productSettingList.get(i).getStock())%>個</td>
					<td align="right"><%=commaFormat.format(productSettingList.get(i).getStockLowerLimit())%>個</td>
					<td align="right"><%=commaFormat.format(productSettingList.get(i).getAutoAddStockCount())%>個</td>
					<td align="right"><%=sdf.format(productSettingList.get(i).getSettingChangeTime())%></td>
				</tr>

<% 		} %>

		</table>

		<br>
		<a href="/DBapp/Product/menu_productManagement.jsp">前のページへ戻る</a><br>
		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ戻る</a>

	</body>

</html>