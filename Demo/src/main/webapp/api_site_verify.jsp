<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String activity = request.getParameter("activity");
String desc = request.getParameter("desc");
String date = request.getParameter("date");
%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/api_application.css" />
<head>
<meta charset="UTF-8">
<style>
.content {
	background-image: url('images/<%out.print(activity);%>.jpg');
}
table {
    width: 50%;
    margin: 2% auto 0 auto;
	border-collapse: collapse;
	border-radius: 50px;
    border: 10px solid transparent;
    text-align: center;
}
td {
	font-size: 42px;
	border: 10px solid transparent;
    background-color: rgba(93, 172, 189, .7);
	text-align: center;
	padding: 10px;
	font-weight: bolder;
}

.bkbtn {
	background-color: transparent;
	margin-left:80%;
	font-size: 6vmin;
	opacity:0.7;
}
</style>
</head>

<body>
	<div class="screen">
		<div class="content">
			<div class="content_cover">
			<button type="button" class="bkbtn" onclick="history.back()">上一頁</button>
				<div class="title">
					<%out.print(desc);%>
				</div>

				<table>
					<c:forEach var="site" items="${sites}">
						<tr>
							<td><c:out value="${site.period}" /></td>
							<c:if test="${site.verify  == true}">
							<td><img src="images/tick.png" /></td></c:if>
							<c:if test="${site.verify  == false}">
							<td>可預訂</td></c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>

</html>