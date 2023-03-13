<%@ page contentType="text/html; charset=UTF-8"%>

<%@	page import="java.util.*,java.text.*" %>

<!DOCTYPE html>
<html>

	<head>
		<title>削除記事検索</title>
	</head>

	<body>

			削除したい記事の情報を入力してください。<br>
			<br>

		<form action="/DBapp/NewsDeletionServlet" method="post">
    		<input type="text"size="100" name="inputString" placeholder="タイトルか本文に含まれる文字を入力してください。">
			<input type="submit" value="検索">　<input type="reset"value="リセット"><br>
		</form>

	</body>

</html>