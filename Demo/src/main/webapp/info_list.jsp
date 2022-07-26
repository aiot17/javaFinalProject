<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>公告清單 InfoList</title>
<link rel="stylesheet" href="style/list.css" />
<style>
td {
	padding: 20px;
}

.table_title {
	width: 200px;
}

.table_title div {
	width: 200px;
	overflow: hidden;
}

.table_info {
	width: 400px;
}

.table_info div {
	width: 400px;
	height: 200px;
	overflow: hidden;
}

.time {
	width: 190px;
}
</style>
</head>
<body>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="title">公告清單 / InfoList</div>
			<div class="box">
				<button class="btn">
					<%
					out.print("<a href='update_board.jsp'>新增公告 / Create Info</a>");
					%>
				</button>
				<br />
				<table>
					<thead>
						<tr>
							<th>公告編號<br />Info ID
							</th>
							<th>日期<br />Date
							</th>
							<th class="table_title">標題<br />Title
							</th>
							<th class="table_info">資訊<br />Information
							</th>
							<th class="time">更新時間<br />Update Time
							</th>
							<th>動作<br />Action
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${listInfo}">
							<tr>
								<td><c:out value="${board.id}" /></td>
								<td><c:out value="${board.date}" /></td>
								<td class="table_title"><c:out value="${board.title}" /></td>
								<td class="table_info"><c:out value="${board.info}" /></td>
								<td class="time"><c:out value="${board.last_modified}" /></td>
								<td><button class="btn">
										<a href="showinfo?id=<c:out value='${board.id}' />">查看 /
											Check</a>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>