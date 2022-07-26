<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>班表 Shift Table</title>
<link rel="stylesheet" href="style/list.css" />
<style>
.title {
	width: 30%;
}

.box {
	width: 30%;
}

.shift {
	width: 80px;
}

.staff {
	width: 160px;
}
.box .btn {
	width: 180px;
}
</style>
</head>
<body>
	<%
	String root = (String) session.getAttribute("root");
	String shift1 = "<tr><td class='shift'>早班</td><td class='staff'>呂文仁、張世杰</td></tr>";
	String shift2 = "<tr><td class='shift'>中班</td><td class='staff'>張釗銘、趙子堯</td></tr>";
	String shift3 = "<tr><td class='shift'>晚班</td><td class='staff'>江名修、黃睦竣</td></tr>";
	String shift[] = { shift1, shift2, shift3 };
	%>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<c:if test="${root != null}">
				<%
				out.print("<div id='root'>----------已開啟ROOT模式----------</div>");
				%>
			</c:if>
			<div class="title">班表 / Shift Table</div>
			<div class="box">
			<c:if test="${root != null }">
				<button class="btn">編輯 / Edit</button>
			</c:if>
			<c:if test="${root == null }">
				<button class="btn null_btn">編輯 / Edit</button>
			</c:if>
			<br />
				<table>
					<%
					for (int i = 1; i <= 31; i++) {
						out.print("<tr><th colspan='3'>7/" + i + "</th></tr>");
						for (int j = 0; j <= 2; j++) {
							out.print(shift[j]);
						}
					}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>