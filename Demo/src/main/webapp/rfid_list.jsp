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
	width: 65%;
}

.box {
	width: 65%;
}

td {
	width: 100px;
	padding-bottom: 0;
}

.rfid {
	width: 120px;
}

.datetime {
	width: 160px;
}

.action {
	width: 150px;
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
			<div class="title">RFID清單 / RFID List</div>
			<div class="box">
				<button class="btn">
					<a href="rfid_form.jsp">新增RFID / Create RFID</a>
				</button>
				<br />
				<c:if test="${rfidList == null }">
					<b class="error_font">查無資料 / User Not Found</b>
				</c:if>
				<c:if test="${rfidList != null }">
					<table>
						<thead>
							<tr>
								<th>地址<br />Address
								</th>
								<th>姓名<br />Name
								</th>
								<th class="rfid">電子標籤<br />RFID
								</th>
								<th class="datetime">創建時間<br />Created date
								</th>
								<th class="datetime">最後修改時間<br />Last modified date
								</th>
								<th class="action">動作<br />Action
								</th>
						</thead>
						<tbody>
							<c:forEach var="rfid" items="${rfidList}">
								<tr>
									<td><c:out value="${rfid.userAddress}" /></td>
									<td><c:out value="${rfid.rfidName}" /></td>
									<td class="rfid"><c:out value="${rfid.rfidNum}" /></td>
									<td class="datetime"><c:out
											value="${fn:substring(rfid.createdDate,0,19)}" /></td>
									<td class="datetime"><c:out
											value="${fn:substring(rfid.lastModifiedDate,0,19)}" /></td>
									<td class="action">
										<div class="control">
											<button class="btn">
												<a
													href="searchRFIDById?RFID_id=<c:out value='${rfid.rfidId}' />">編輯
													/ Edit</a>
											</button>
											<button class="btn">
												<a
													href="deleteRFID?RFID_id=<c:out value='${rfid.rfidId}' />">刪除
													/ Delete</a>
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