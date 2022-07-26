<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/list.css" />
<style>
.content {
	overflow: visible;
}

.title {
	width: 80%;
	margin-top: 0;
}

.box {
	width: 80%;
	overflow: auto;
}

td {
	width: 110px;
	padding-bottom: 0;
	text-align: center;
}

.query {
	display: flex;
	flex-direction: column;
	width: 46%;
	margin: 3% auto 10px auto;
}

.query th {
	background-color: transparent;
	width: 310px;
	text-align: right;
}

.query td {
	border: none;
}

.query input {
	width: 250px;
	margin-left: 20px;
	border: none;
}

.query .btn {
	width: 150px;
	margin-left: 0;
	border: none;
}

.datetime {
	width: 150px;
}

.action {
	width: 150px;
}

.action .control .btn {
	margin-bottom: 10px;
	width: 150px;
}
.error_font {
	font-size: 24px;
	margin: auto;
}
</style>
</head>
<body>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="query">
				<div class="q_box1">
					<form action="searchUserByName" method="get">
						<table>
							<tr>
								<th><label for="user_name">搜尋(住戶名) / Search by User</label></th>
								<td><input id="user_name" type="text" name="user_name" autofocus
									autocomplete="new-text" /></td>
								<td><input class="btn" type="submit" value="搜尋 / Search" /></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="q_box2">
					<form action="searchUserByAddress" method="get">
						<table>
							<tr>
								<th><label for="user_address">搜尋(號與樓) / Search by Address</label></th>
								<td><input id="user_address" type="text" name="user_address"
									autocomplete="new-text" /></td>
								<td><input class="btn" type="submit" value="搜尋 / Search" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="title">住戶清單 / User List</div>
			<div class="box">
				<button class="btn">
					<a href="user_form.jsp">新增用戶 / Add User</a>
				</button>
				<br />
				<c:if test="${userList == null }">
					<b class="error_font">查無資料 / User Not Found</b>
				</c:if>
				<c:if test="${userList != null }">
					<table>
						<thead>
							<tr>
								<th>姓名<br />Name
								</th>
								<th>住址<br />Address
								</th>
								<th>連絡電話<br />Phone Num
								</th>
								<th class="datetime">創建時間<br />Created date
								</th>
								<th class="datetime">最後修改時間<br />Last modified date
								</th>
								<th class="action">動作<br />Action
								</th>
								<th>新增包裹<br />Add Parcel
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${userList}">
								<tr>
									<td><c:out value="${user.user_name}" /></td>
									<td><c:out value="${user.user_address}" /></td>
									<td><c:out value="${user.user_tel}" /></td>
									<td class="datetime"><c:out
											value="${fn:substring(user.created_date,0,19)}" /></td>
									<td class="datetime"><c:out
											value="${fn:substring(user.last_modified_date,0,19)}" /></td>
									<td class="action">
										<div class="control">
											<button class="btn">
												<a
													href="searchUser?user_id=<c:out value='${user.user_id}' />">編輯
													/ Edit</a>
											</button>
											<button class="btn">
												<a
													href="deleteUser?user_id=<c:out value='${user.user_id}' />">刪除
													/ Delete</a>
											</button>
										</div>
									</td>
									<td class="action">
										<div class="control">
											<button class="btn">
												<a
													href="createPackageByAddress?user_address=<c:out value='${user.user_address}' />">新增包裹<br />Add
													Parcel
												</a>
											</button>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>