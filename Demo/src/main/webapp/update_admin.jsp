<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯管理員 EditAdmin</title>
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
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="title">
				<c:if test="${admin != null}">
            			編輯管理員 / Edit Admin
            		</c:if>
				<c:if test="${admin == null}">
            			新增管理員 / New Admin
            		</c:if>
			</div>
			<c:if test="${admin != null}">
				<form action="editadmin" method="post">
			</c:if>
			<c:if test="${admin == null}">
				<form action="createadmin" method="post">
			</c:if>
			<c:if test="${admin != null}">
				<input type="hidden" name="id" value="<c:out value='${admin.id}' />" />
			</c:if>
			<div class="box">
				<table>
					<tr>
						<th><label for="name">管理員名稱<br />Admin Name
						</label></th>
						<td><input id="name" type="text"
							value="<c:out value='${admin.name}' />" name="name"
							required="required" autocomplete="new-text" autofocus></td>
					</tr>
					<tr>
						<th><label for="account">帳號<br />Account
						</label></th>
						<td><input id="account" type="text"
							value="<c:out value='${admin.account}' />" name="account"
							required="required" autocomplete="new-text"></td>
					</tr>
					<tr>
						<th><label for="password">密碼<br />Password
						</label></th>
						<td><input id="password" type=text
							value="<c:out value='${admin.password}' />" name="password"
							required="required" autocomplete="new-text"></td>
					</tr>
					<tr>
						<th><label for="email">信箱<br />Email
						</label></th>
						<td><input id="email" type="email"
							value="<c:out value='${admin.email}' />" name="email"
							autocomplete="new-text"></td>
					</tr>
				</table>
				<br /> <input class="btn" type="submit" value="提交 / Submit" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
