<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

	<head>
		<title>商品追加</title>
		<style>ul{list-style:none; padding-left: 0;}</style>
	</head>

	<body>

		新しく登録する商品名を入力してください。<br>
		<font color="red">※既に登録されている名前の場合はエラーになります。</font><br>

		<form action="/DBapp/ProductRegistrationServlet" method="post">

			<ul>
				<li><label for="name">商品名：</label>
					<input type="text" name="name" id="name" size="30" maxlength="30" required></li>

				<li><label for="price">価格：</label>
					<input type="number" name="price" id="price" size="10" maxlength="255" required></li>
			</ul>

				<input type="submit" value="登録">

		</form>

		<br>
		<a href="/DBapp/Product/menu_productManagement.jsp">前のページへ戻る</a><br>
		<a href="/DBapp/Menu/menu_rootUser.jsp">メニュー画面へ戻る</a>

	</body>

</html>