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
	width: 35%;
}

.box {
	width: 35%;
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
	margin: auto;
}
</style>
</head>
<body>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="title">
				<c:if test="${aPackage == null }">新增包裹 / Add Package<form
						action="createPackage" method="post">
				</c:if>
				<c:if test="${aPackage != null }">編輯包裹資料 / Edit Package Info<form
						action="updatePackage" method="post">
				</c:if>
				<c:if test="${aPackage != null }">
					<input type="hidden" name="packageId"
						value="<c:out value='${aPackage.package_id}' />">
				</c:if>
			</div>
			<div class="box">
				<table>
					<tr>
						<th><label for="userName">收件人<br />Recipient</label></th>
						<td><input id="userName" type="text" name="userName"
							value="<c:out value='${aPackage.user_name}' />" autocomplete="new-text" autofocus /></td>
					</tr>
					<tr>
						<c:if test="${aPackage == null }">
							<th><label>收件地址：</label></th>
							<td><input id="userAddress" type="text" name="userAddress" value="<c:out value='${userAddress}' />" autocomplete="new-text" /></td>
						</c:if>
						<c:if test="${aPackage != null }">
							<th><label for="userAddress">收件地址<br />Address</label></th>
							<td><input id="userAddress" type="text" name="userAddress" value="<c:out value='${aPackage.user_address}' />" autocomplete="new-text" /></td>
						</c:if>
					</tr>
					<tr>
						<th><label for="package_number">物流編號<br />TRK Number</label></th>
						<td><input id="package_number" type="text" name="packageNumber"
							value="<c:out value='${aPackage.package_number}' />" autocomplete="new-text" /></td>
					</tr>
				</table>
				<br /> <input class="btn" type="submit" value="提交 / Submit" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>