<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.box2 .title {
	width: 50%;
	margin-left: 0%;
}

.box2 .box {
	width: 50%;
	margin-left: 0%;
}

.action {
	width: 170px;
}

.box2 .box td {
	padding-top: 7px;
	padding-bottom: 7px;
}
</style>
</head>
<body>
<div class="title">日期選擇 / Date Select</div>
    <div class="box">
	<table>
		<tr>
			<th>日期 / Date</th>
			<th class="action">動作 / Action</th>
		</tr>
		<%
		for (int i = 0; i < 14; i++) {
			LocalDate day = LocalDate.now().plusDays(i);
			String date = day.toString();
			out.print("<tr><td>" + date + "</td><td class='action'><button class='btn'>選擇 / Select</button></td></tr>");
		}
		%>
	</table>
	</div>
	<script src="js/jquery-3.6.0.js"></script>
	<script>
		$(".action").click(function() {
			var date_info = $(this).prev().text()
			$('input[name="date"]').val(date_info);
			$(".box2").html(" ");
			$("#site").val(" ");
		})
	</script>
</body>
</html>