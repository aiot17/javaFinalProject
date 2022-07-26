<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/application.css" />
<link rel="stylesheet" href="style/list.css" />
<style>
.screen {
    background-image: none;
}
.title {
	width: 90%;
}

.box {
	width: 90%;
}

td {
	text-align: left;
	padding-left: 20px;
	border-width: 2px;
	border-style: solid;
}

th {
	width: 200px;
	padding: 10px;
	border-width: 2px;
	border-style: solid;
}

.box .btn {
	width: 170px;
	margin-right: 20px;
}

.info {
	vertical-align: top;
	height: 230px;
}

</style>
</head>
<body>
	<%
	String id = request.getParameter("id");
	%>
	<div class="screen">
		<div class="content">
			<div class="box">
				<table>
					<tr>
						<th>公告編號<br />Info ID
						</th>
						<td><c:out value="${board.id}" /></td>
					</tr>
					<tr>
						<th>日期<br />Date
						</th>
						<td><c:out value="${board.date}" /></td>
					</tr>
					<tr>
						<th>標題<br />Title
						</th>
						<td><c:out value="${board.title}" /></td>
					</tr>
					<tr class="info">
						<th>資訊<br />Information
						</th>
						<td><c:out value="${board.info}" /></td>
					</tr>
					<tr>
						<th>更新時間<br />Update Time
						</th>
						<td><c:out value="${board.last_modified}" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
