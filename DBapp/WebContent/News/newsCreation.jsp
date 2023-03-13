<%@ page contentType="text/html; charset=UTF-8"%>

<%@	page import="java.util.*,java.text.*" %>

<%
	//デフォルト値用：日付取得.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(new Date());

%>

<!DOCTYPE html>
<html>

	<head>
		<title>記事作成</title>
	</head>

	<body>
		<form action="/DBapp/NewsCreationServlet" method="post">

			<label for="date">日付：</label>
			<input type="date" name="date" id="date" value="<%=today%>" required><br>
			<br>

			<label for="title">タイトル：</label>最大50文字<br>
			<input type="text" name="title" id="title" size="30" maxlength="50" required><br>
			<br>

			<label for="body">本文：</label>最大500文字<br>
			<input type="text" name="body" id="body" size="100" maxlength="500" required><br>
			<br>

			<label for="author">作成者：</label>最大50文字<br>
			<input type="text" name="author" id="author" size="30" maxlength="50" required><br>
			<br>

			<input type="submit" value="作成">　<input type="reset"value="リセット"><br>

		</form>
	</body>

</html>