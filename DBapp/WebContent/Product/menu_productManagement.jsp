<%@ page contentType="text/html; charset=UTF-8"%>
<%

	//リクエストから処理結果メッセージ取得.
	String sqlProcessResult = (String)request.getAttribute("sqlProcessResult");

%>
<!DOCTYPE html>
<html>

	<head>
		<title>商品管理画面</title>
	</head>

	<body>

<%		if(sqlProcessResult != null) {%>

			<%=sqlProcessResult%>

<% 		}%>

			<ul>
				<li><a href="/DBapp/Product/productRegistration.jsp">商品登録</a></li>
				<li><a href="/DBapp/ProductListSearchServlet">在庫確認</a></li>
				<li><a href="/DBapp/Product/stockCountAdd.jsp">在庫数追加</a></li>
				<li><a href="/DBapp/Product/productDeletion.jsp">商品削除</a></li>
				<li><a href="/DBapp/Product/autoAddStockSetting.jsp">自動在庫追加設定</a></li>
			</ul>

		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ</a>

	</body>


	</body>

</html>