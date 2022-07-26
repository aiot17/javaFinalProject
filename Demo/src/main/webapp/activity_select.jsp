<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.box2 .title {
	width: 80%;
	margin-left: 0%;
}

.box2 .box {
	width: 80%;
	margin-left: 0%;
}
</style>
</head>
<body>
	<div class="title">類別選擇 / Activity</div>
	<div class="box">
		<table>
			<tr>
				<th>類別<br />Activity
				</th>
				<th class="action">動作<br />Action
				</th>
			</tr>
			<tr>
				<td>桌球室 / Table Tennis</td>
				<td class="action"><button class="btn">選擇 / Select</button></td>
			</tr>
			<tr>
				<td>會議室 / Metting Room</td>
				<td class="action"><button class="btn">選擇 / Select</button></td>
			</tr>
			<tr>
				<td>自修室 / Study Room</td>
				<td class="action"><button class="btn">選擇 / Select</button></td>
			</tr>
		</table>
	</div>
	<script src="js/jquery-3.6.0.js"></script>
	<script>
		$(".action").click(function() {
			var activity_info = $(this).prev().text()
			$('input[name="activity"]').val(activity_info);
			$(".box2").html(" ");
			$("#site").val(" ");
		})
	</script>
</body>
</html>