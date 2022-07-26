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

.box2 .box th, .box2 .box td {
	width: 100px;
}
</style>
</head>
<body>
	<div class="title">住戶選擇 / User Select</div>
	<div class="box">
		<table>
			<thead>
				<tr>
					<th>住戶編號<br />User ID
					</th>
					<th>住戶名稱<br />Name
					</th>
					<th>住址<br />Address
					</th>
					<th class="action">動作<br />Action
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td><c:out value="${user.user_id}" /></td>
						<td><c:out value="${user.user_name}" /></td>
						<td><c:out value="${user.user_address}" /></td>
						<td class="action"><button class="btn">選擇 / Select</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="js/jquery-3.6.0.js"></script>
	<script>
		$(".action").click(function() {
			var user_info = $(this).prev().prev().text()
			$('input[name="user_name"]').val(user_info);
			$(".box2").html(" ");
		})
	</script>
</body>
</html>