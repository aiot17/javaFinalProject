<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員資訊 / Admin Info</title>
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
	border-style: solid;
	border-width: 2px;
}

th {
	padding: 10px;
	border-style: solid;
	border-width: 2px;
}

.box .btn {
	width: 170px;
	margin-right: 20px;
}
</style>
</head>
<body>
	<%
	String id = request.getParameter("id");
	%>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="title">管理員資訊 / Admin Information</div>
			<div class="box">
				<div class="control">
					<button class="btn">
						<%
						out.print("<a href='editadminform?id=" + id + "'>編輯 / Edit</a>");
						%>
					</button>
					<button class="btn">
						<%
						out.print("<a href='deleteadmin?id=" + id + "'>刪除 / Delete</a>");
						%>
					</button>
				</div>
				<br />
				<table>
					<tr>
						<th>管理員編號<br />Admin ID
						</th>
						<td><c:out value="${admin.id}" /></td>
					</tr>
					<tr>
						<th>名稱<br />Name
						</th>
						<td><c:out value="${admin.name}" /></td>
					</tr>
					<tr>
						<th>帳號<br />Account
						</th>
						<td><c:out value="${admin.account}" /></td>
					</tr>
					<tr>
						<th>密碼<br />Password
						</th>
						<td><c:out value="${admin.password}" /></td>
					</tr>
					<tr>
						<th>信箱<br />Email
						</th>
						<td><c:out value="${admin.email}" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
