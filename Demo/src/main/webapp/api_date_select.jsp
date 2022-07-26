<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate"%>
<%
String activity = request.getParameter("activity");
String desc = request.getParameter("desc");
%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/api_application.css" />
<style>

.content {
	background-image: url('images/<%out.print(activity);%>.jpg');
}

a {
	color: black;
	text-decoration: none;
	font-weight: bolder;
	font-size: 42px;
	background-color: rgba(93, 172, 189, .7);
	border-radius: 50px;
	padding: 20px;
	margin-left: 30px;
	line-height: 3em;
}

div .row1 {
	display: flex;
	flex-direction: row;
	width: 100%;
	margin: auto;
	margin-top: 5%;
}

div .row2 {
	display: flex;
	flex-direction: row;
	width: 100%;
	margin: auto;
	margin-top: 6%;
}

.bkbtn {
	margin-left:80%;
	font-size: 6vmin;
	background-color: transparent;
	opacity:0.7;
}
</style>
</head>

<body>
	<div class="screen">
		<div class="content">
			<div class="content_cover">
			<button class="bkbtn" onclick="history.back()">上一頁</button>
				<div class="title">
					<%out.print(desc);%>
				</div>
				<div class="row1">
					<%
					for (int i = 0; i < 7; i++) {
						LocalDate day = LocalDate.now().plusDays(i);
						String date = day.toString();
						out.print("<a href='apisiteverify?activity=" + activity + "&desc=" + desc + "&date=" + date + "'>" + date + "</a>");
					}
					%>
				</div>
				<div class="row2">
					<%
					for (int i = 7; i < 14; i++) {
						LocalDate day = LocalDate.now().plusDays(i);
						String date = day.toString();
						out.print("<a href='apisiteverify?activity=" + activity + "&desc=" + desc + "&date=" + date + "'>" + date + "</a>");
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>

</html>