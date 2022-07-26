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
.title {
	width: 90%;
	margin-top: 0;
}

.box {
	width: 90%;
}

.cargo_id {
	width: 300px;
}

.received_date {
	width: 300px;
}

.received_status {
	width: 300px;
}

td {
	width: 200px;
	padding-bottom: 0;
	text-align: center;
}

.query {
	width: 48%;
	margin: 3% auto 10px auto;
}

.query th {
	width: 310px;
	text-align: right;
	background-color: transparent;
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

.query_control .btn {
	width: 100px;
	margin-right: 20px;
}

.action .control .btn {
	margin-bottom: 10px;
	width: 150px;
}
</style>
</head>
<body>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="query">
				<form action="searchPackageByRFID" method="get">
					<table>
						<tr>
							<th><label>搜尋包裹(RFID) / Search by RFID</label></th>
							<td><input id="user_address" type="text" name="number"
								autocomplete="new-text" /></td>
							<td><input class="btn" type="submit" value="搜尋 / Search" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="title">包裹清單 / Package List</div>
			<div class="box">
				<div class="query_control">
					<button class="btn">
						<a href="packagelist">全部</a>
					</button>
					<button class="btn">
						<a href="searchPackageByState?package_state=1">已領取</a>
					</button>
					<button class="btn">
						<a href="searchPackageByState?package_state=0">未領取</a>
					</button>
				</div>
				<br />
				<table>
					<thead>
						<tr>
							<th>收件人<br />Recipient
							</th>
							<th>收件地址<br />Address
							</th>
							<th class="cargo_id">物流(包裹)編號<br />TRK Number
							</th>
							<th class="received_date">管理員收件時間<br />Delivery date
							</th>
							<th class="received_status">最後修改時間<br />Last modified date
							</th>
							<th>包裹狀態<br />State
							</th>
							<th>動作<br />Action
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="userPackage" items="${packageList}">
							<tr>
								<td><c:out value="${userPackage.user_name}" /></td>
								<td><c:out value="${userPackage.user_address}" /></td>
								<td class="cargo_id"><c:out
										value="${userPackage.package_number}" /></td>
								<td class="received_date"><c:out
										value="${fn:substring(userPackage.created_date,0,19)}" /></td>
								<c:if test="${userPackage.package_state == '1' }">
									<td class="received_status"><c:out escapeXml="false"
											value="<b>領取時間：</b><br />${fn:substring(userPackage.last_modified_date,0,19)}" /></td>
									<td><c:out value="已領取" /></td>
								</c:if>
								<c:if test="${userPackage.package_state == '0' }">
									<td class="received_status"><c:out
											value="${fn:substring(userPackage.last_modified_date,0,19)}" /></td>
									<td><button class="btn">
											<a
												href="updatePackageState?package_id=<c:out value='${userPackage.package_id}' />">
												<c:out value="領取 / Get" />
											</a>
										</button></td>
								</c:if>

								<td class="action">
									<div class="control">
										<c:if test="${userPackage.package_state == '0' }">
											<button class="btn">
												<a
													href="searchPackageById?package_id=<c:out value='${userPackage.package_id}' />">編輯
													/ Edit</a>
											</button>
											<button class="btn">
												<a
													href="deletePackage?package_id=<c:out value='${userPackage.package_id}' />">刪除
													/ Delete</a>
											</button>
										</c:if>
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