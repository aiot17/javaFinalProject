<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>管理員清單 AdminList</title>
<link rel="stylesheet" href="style/list.css" />
<style>
.title {
	width: 60%;
}

.box {
	width: 60%;
}

.action {
	width: 200px;
}

.email {
	width: 400px;
}
</style>
</head>
<body>
	<%
	String root = (String) session.getAttribute("root");
	%>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<c:if test="${root != null}">
				<%
				out.print("<div id='root'>----------已開啟ROOT模式----------</div>");
				%>
			</c:if>
			<div class="title">管理員清單 / Admin List</div>
			<div class="box">
				<div class="control">
					<c:if test="${root != null }">
					<button class="btn"><a href='update_admin.jsp'>新增管理員 / Add Admin</a></button>
					</c:if>
					<c:if test="${root == null }">
					<button class="btn null_btn">新增管理員 / Add Admin</button>
					</c:if>
					<button class="btn"><a href='shift_table.jsp'>班表 / Shift Table</a></button>
					</div>
				<br />
				<table>
					<thead>
						<tr>
							<th>管理員編號<br />Admin ID
							</th>
							<th>名稱<br />Name
							</th>
							<th>信箱<br />Email
							</th>
							<th>動作<br />Action
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="admin" items="${listAdmin}">
							<tr>
								<td><c:out value="${admin.id}" /></td>
								<td><c:out value="${admin.name}" /></td>
								<td class="email"><c:out value="${admin.email}" /></td>
								<td class="action">
								<c:if test="${root != null}">
								<button class="btn">
										<a href="admininfo?id=<c:out value='${admin.id}' />">查看 /
											Check</a>
									</button>
								</c:if>
								<c:if test="${root == null}">
								<button class="btn null_btn">查看 / Check</button>
								</c:if>
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
