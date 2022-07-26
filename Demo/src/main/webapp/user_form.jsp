<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<c:if test="${user == null }">
				<div class="title">新增住戶 / Add User</div>
				<form action="createUser" method="post">
			</c:if>
			<c:if test="${user != null }">
				<div class="title">編輯住戶資料 / Edit User</div>
				<form action="updateUser" method="post">
			</c:if>
			<c:if test="${user != null }">
				<input type="hidden" name="userId"
					value="<c:out value='${user.user_id}' />">
			</c:if>
			<div class="box">
				<table>
					<tr>
						<th><label for="userName">姓名<br />Name
						</label></th>
						<td><input id="userName" type="text" name="userName"
							value="<c:out value='${user.user_name}' />"
							autocomplete="new-text" autofocus required /></td>
					</tr>
					<tr>
						<th><label for="userFaceId">人臉識別ID<br />FR ID
						</label></th>
						<td><input id="userFaceId" type="text" name="userFaceId"
							value="<c:out value='${user.facial_recognition}' />"
							autocomplete="new-text" /></td>
					</tr>
					<tr>
						<th><label for="userAddress">地址<br />Address
						</label></th>
						<td><input id="userAddress" type="text" name="userAddress"
							value="<c:out value='${user.user_address}' />"
							autocomplete="new-text" required /></td>
					</tr>
					<tr>
						<th><label for="userTel">聯絡電話<br>Phone Num
						</label></th>
						<td><input id="userTel" type="text" name="userTel"
							value="<c:out value='${user.user_tel}' />"
							autocomplete="new-text" /></td>
					</tr>
				</table>
				<br /> <input class="btn" type="submit" value="提交 / Submit" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>