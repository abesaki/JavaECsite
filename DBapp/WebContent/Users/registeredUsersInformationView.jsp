<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dao.*,entity.*,java.util.*,java.text.*" %>

<%

	//登録ユーザー全件取得.
	UsersDao dao = new UsersDao();
	List<Users> usersInformationAllList = dao.usersInformationAllGet();

	//生年月日用フォーマット.
	SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy年MM月dd日");

	//タイムスタンプ用フォーマット.
	SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>

<!DOCTYPE html>
<html>

	<head>
		<title>登録ユーザー一覧</title>
		<link rel="stylesheet" type="text/css" href="../CSS/common.css">
	</head>

	<body>
		<table>
			<tr align="center"><td>ID</td><td>ユーザーID</td><td>パスワード</td><td>名字</td><td>名前</td><td>ミョウジ</td><td>ナマエ</td><td>生年月日</td><td>都道府県</td><td>住所</td><td>メールアドレス</td><td>電話番号</td><td>登録日</td><td>更新日</td></tr>

<% 			for(int i = 0 ; i < usersInformationAllList.size(); i++){%>

				<tr align="center">
					<td align="right"><%=i+1%></td>
					<td><%=usersInformationAllList.get(i).getUserId()%></td>
					<td><%=usersInformationAllList.get(i).getPassword()%></td>
					<td><%=usersInformationAllList.get(i).getFamilyName()%></td>
					<td><%=usersInformationAllList.get(i).getFirstName()%></td>
					<td><%=usersInformationAllList.get(i).getFamilyNameFurigana()%></td>
					<td><%=usersInformationAllList.get(i).getFirstNameFurigana()%></td>

<%					//rootのNULLで引っかかるので条件分岐してフォーマットする. %>
<%					if(usersInformationAllList.get(i).getBirthDay() == null) { %>

						<td><%=usersInformationAllList.get(i).getBirthDay()%></td>

<%					} else {%>

						<td><%=birthDayFormat.format(usersInformationAllList.get(i).getBirthDay())%></td>

<%					} %>

					<td><%=usersInformationAllList.get(i).getAddressPrefectures()%></td>
					<td><%=usersInformationAllList.get(i).getAddressMunicipality()%></td>
					<td><%=usersInformationAllList.get(i).getEmailAddress()%></td>
					<td><%=usersInformationAllList.get(i).getPhoneNumber()%></td>
					<td><%=timeStampFormat.format(usersInformationAllList.get(i).getRegistrationDate())%></td>
					<td><%=timeStampFormat.format(usersInformationAllList.get(i).getUpdatedDate())%></td>
				</tr>

<%			} %>

		</table>

		<br>
		<a href="/DBapp/Users/menu_usersManagement.jsp">ユーザー管理画面へ</a>

	</body>

</html>