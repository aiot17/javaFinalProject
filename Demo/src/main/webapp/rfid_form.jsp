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
			<c:if test="${rfid == null }">
				<div class="title">新增RFID / Create RFID</div>
				<form action="createRFID" method="post">
			</c:if>
			<c:if test="${rfid != null }">
				<div class="title">編輯RFID / Edit RFID</div>
				<form action="updateRFID" method="post">
			</c:if>
			<c:if test="${rfid != null }">
				<input type="hidden" name="rfidId"
					value="<c:out value='${rfid.rfidId}' />">
			</c:if>

			<div class="box">
				<table>
					<tr>
						<th><label for="address">地址<br />Address
						</label></th>
						<td><input id="address" type="text" name="address"
							value="<c:out value='${rfid.userAddress}' />" autofocus
							autocomplete="new-text" /></td>
					</tr>
					<tr>
						<th><label for="name">姓名<br />Name
						</label></th>
						<td><input id="name" type="text" name="name"
							value="<c:out value='${rfid.rfidName}' />"
							autocomplete="new-text" /></td>
					</tr>
					<tr>
						<th><label for="number">電子標籤<br />RFID
						</label></th>
						<td><input id="number" type="text" name="number"
							value="<c:out value='${rfid.rfidNum}' />" autocomplete="new-text" /></td>
					</tr>
				</table>
				<br /> <input class="btn" type="submit" value="提交 / 送出" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>