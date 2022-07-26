<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>場地租借 / BookingService</title>
<link rel="stylesheet" href="style/list.css" />
<style>
.content {
	flex-direction: row;
	width: 84%;
}

.box1 {
	width: 50%;
	padding-top: 2%;
}

.box2 {
	width: 50%;
	padding-top: 2%;
	overflow: auto;
}

.box1 td {
	border-width: 2px;
	border-style: solid;
}

.box1 th {
	border-width: 2px;
	border-style: solid;
}

.box1 .title {
	width: 70%;
	margin-left: 20%;
}

.box1 .box {
	width: 70%;
	margin-left: 20%;
}

.box1 .btn {
	width: 170px;
	height: 40px;
	margin: auto;
	margin-bottom: 5%;
}

.site_title {
	width: 50%;
	margin-left: 0%;
}

.site_box {
	width: 50%;
	margin-left: 0%;
}

.site_box .action {
	width: 170px;
}

.site_box .box2 .box td {
	padding-top: 7px;
	padding-bottom: 7px;
}
</style>
</head>
<body>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="box1">
				<div class="title">
					<c:if test="${booking != null}">
            			編輯租借 / Edit Booking
            		</c:if>
					<c:if test="${booking == null}">
            			新增租借 / Create Booking
            		</c:if>
				</div>
				<c:if test="${booking != null}">
					<form id="booking" action="editbooking" method="get">
				</c:if>
				<c:if test="${booking == null}">
					<form id="booking" action="confirm_select.jsp" method="get">
				</c:if>
				<c:if test="${booking != null}">
					<input type="hidden" name="id"
						value="<c:out value='${booking.id}' />" />
				</c:if>
				<div class="box">
					<table>
						<tr>
							<th><label for="user_name">住戶<br />User
							</label></th>
							<td><input id="user_name" type="text" name="user_name"
								readonly value="<c:out value='${booking.user_name}' />" /></td>
						</tr>
						<tr>
							<th><label for="activity">類別<br />Activity
							</label></th>
							<td><input id="activity" type="text" name="activity"
								readonly value="<c:out value='${booking.activity}' />" /></td>
						</tr>
						<tr>
							<th><label for="date">日期<br />Date
							</label></th>
							<td><input id="date" type="text" name="date" readonly
								value="<c:out value='${booking.date}' />" /></td>
						</tr>
						<tr>
							<th><label for="site">場地<br />Site
							</label></th>
							<td><input id="site" type="text" name="site" readonly
								value="<c:out value='${booking.site}' />" /></td>
						</tr>
					</table>
					<br /> <input class="btn" type="submit" value="提交 / Submit" />
					</form>
				</div>
			</div>
			<div class="box2"></div>
		</div>
	</div>
	<script src="js/jquery-3.6.0.js"></script>
	<script>
		$('#user_name').click(function() {
			$(".box2").load("userselect");
		})

		$('#activity').click(function() {
			$(".box2").load("activity_select.jsp");
		})

		$('#date').click(function() {
			$(".box2").load("date_select.jsp");
		})

		$('#site').click(function() {
			var activity = $('#activity').val();
			var date = $('#date').val();
			$.ajax({
				url : "siteverify",
				type : "GET",
				data : "activity=" + activity + "&date=" + date,
				success : function(result) {
					$('.box2').html(result);
				}
			})
		})
	</script>
</body>
</html>