<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>場地租借清單 BookingList</title>
<link rel="stylesheet" href="style/list.css" />
<style>
.title {
	width: 80%;
}

.box {
	width: 80%;
}

td {
	padding-bottom: 0;
	text-align: center;
}

.action {
	width: 200px;
}

.control .btn {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="title">場地租借清單 / Booking List</div>
			<div class="box">
				<button class="btn">
					<%
					out.print("<a href='update_booking.jsp'>新增租借/ Add Booking</a>");
					%>
				</button>
				<br />
				<table>
					<thead>
						<tr>
							<th>租借編號<br />Booking ID
							</th>
							<th>住戶<br />User
							</th>
							<th>類別<br />Activity
							</th>
							<th>日期<br />Date
							</th>
							<th>場地<br />Site
							</th>
							<th>動作<br />Action
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="booking" items="${listBooking}">
							<tr>
								<td><c:out value="${booking.id}" /></td>
								<td><c:out value="${booking.user_name}" /></td>
								<td><c:out value="${booking.activity}" /></td>
								<td><c:out value="${booking.date}" /></td>
								<td><c:out value="${booking.site}" /></td>
								<td class="action">
									<div class="control">
										<button class="btn">
											<a href="editbookingform?id=<c:out value='${booking.id}' />">編輯
												/ Edit</a>
										</button>
										<button class="btn">
											<a href="deletebooking?id=<c:out value='${booking.id}' />">刪除
												/ Delete</a>
										</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
