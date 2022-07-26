<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>場地租借 / BookingService</title>
<link rel="stylesheet" href="style/list.css" />
<style>
.title {
	width: 40%;
}

.box {
	width: 40%;
}

td {
	text-align: left;
	padding-left: 20px;
	border-width: 2px;
	border-style: solid;
}

th {
	padding: 10px;
	border-width: 2px;
	border-style: solid;
}

.box .btn {
	width: 170px;
	margin: auto;
}
</style>
</head>
<body>
	<%
	String user_name = request.getParameter("user_name");
	String activity = request.getParameter("activity");
	String date = request.getParameter("date");
	String time = request.getParameter("time");
	String site = request.getParameter("site");
	%>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="title">場地租借 / Booking Service</div>
			<form action="createbooking" method="get">
				<div class="box">
					<table>
						<tr>
							<th><label for="user_name">住戶編號<br />User ID</label></th>
							<td><input id="user_name" type="text"
								value="<%out.print(user_name);%>" name="user_name" readonly></td>
						</tr>
						<tr>
							<th><label for="activity">類別<br />Activity</label></th>
							<td><input id="activity" type="text"
								value="<%out.print(activity);%>" name="activity" readonly></td>
						</tr>
						<tr>
							<th><label for="date">日期<br />Date</label></th>
							<td><input id="date" type="text"
								value="<%out.print(date);%>" name="date" readonly></td>
						</tr>
						<tr>
							<th><label for="site">場地<br />Site</label></th>
							<td><input id="site" type="text"
								value="<%out.print(site);%>" name="site" readonly></td>
						</tr>
					</table>
					<br /> <input class="btn" type="submit" value="提交 / Submit" />
			</form>
		</div>
	</div>
	</div>
</body>
</html>