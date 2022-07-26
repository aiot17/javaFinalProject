<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁 HomePage</title>
<link rel="stylesheet" href="style/list.css" />
<style>
table {
	width: 400px;
	margin-left: 10px;
	line-height: 3em;
	font-weight: bolder;
}
.shift {
	width: 30%;
}
.staff {
	width: 40%;
}

#timeShow {
	width: 32%;
	border: none;
	text-align: center;
	border-radius: 25px;
	padding: 2%;
	margin: 5% auto 0 auto;
	box-shadow: 10px 10px 10px grey;
}

#timeShow p {
	font-size: 42px;
	font-weight: bolder;
	line-height: 1.5em;
	letter-spacing: 0.15em;
}

#shift {
	margin: 150px auto 0 auto;
	display: flex;
}
</style>
</head>
<body>
	<%
	String root = (String) session.getAttribute("root");
	String shift1 = "<tr><td class='shift'>早班</td><td class='staff'>呂文仁、張世杰</td></tr>";
	String shift2 = "<tr><td class='shift'>中班</td><td class='staff'>張釗銘、趙子堯</td></tr>";
	String shift3 = "<tr><td class='shift'>晚班</td><td class='staff'>江名修、黃睦竣</td></tr>";
	String shift[] = {shift1, shift2, shift3};
	%>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<c:if test="${root != null}">
				<%
				out.print("<div id='root'>----------已開啟ROOT模式----------</div>");
				%>
			</c:if>
			<div id="timeShow"></div>
			<div id="shift">
				<table>
					<tr>
						<th colspan='3'>7/25</th>
					</tr>
					<%
					for (int j = 0; j <= 2; j++) {
						out.print(shift[j]);
					}
					%>
				</table>
				<table>
					<tr>
						<th colspan='3'>7/26</th>
					</tr>
					<%
					for (int j = 0; j <= 2; j++) {
						out.print(shift[j]);
					}
					%>
				</table>
				<table>
					<tr>
						<th colspan='3'>7/27</th>
					</tr>
					<%
					for (int j = 0; j <= 2; j++) {
						out.print(shift[j]);
					}
					%>
				</table>
			</div>
		</div>
	</div>
	<script>
		var t = null;
		t = setTimeout(time, 1000);
		function time() {
			clearTimeout(t);
			dt = new Date();
			var y = dt.getYear() + 1900;
			var mm = dt.getMonth() + 1;
			var d = dt.getDate();
			var weekday = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", ];
			var day = dt.getDay();
			var h = dt.getHours();
			var m = dt.getMinutes();
			var s = dt.getSeconds();
			if (h < 10) {
				h = "0" + h;
			}
			if (m < 10) {
				m = "0" + m;
			}
			if (s < 10) {
				s = "0" + s;
			}
			document.getElementById("timeShow").innerHTML = "<div>" + "<p>" + y
					+ " 年 " + mm + " 月 " + d + " 日 " + "</p>" + "</div>"
					+ "<p>" + weekday[day] + "</p>" + "<p>" + h + " : " + m
					+ " : " + s + "</p>";
			t = setTimeout(time, 1000);
		}
	</script>
</body>
</html>