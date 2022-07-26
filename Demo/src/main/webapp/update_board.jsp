<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯公告 EditInfo</title>
<link rel="stylesheet" href="style/list.css" />
<style>
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

input {
	width: 99%;
	padding-left: 1%;
}

textarea {
	width: 99%;
	height: 390px;
	vertical-align: top;
	resize: none;
	padding-left: 1%;
	padding-right: 1%;
	border-width: 1px;
    border-style: solid;
	border-radius: 5px;
}

.info {
	vertical-align: top;
}

.box .btn {
	width: 170px;
	margin: auto;
}
</style>
</head>
<body>
	<div class="screen">
		<jsp:include page="header.jsp" />
		<div class="content">
			<div class="title">
				<c:if test="${board != null}">
            			編輯公告 / Edit Info
            		</c:if>
				<c:if test="${board == null}">
            			新增公告 / Create Info
            		</c:if>
			</div>
			<c:if test="${board != null}">
				<form action="editinfo" method="post">
			</c:if>
			<c:if test="${board == null}">
				<form action="createinfo" method="post">
			</c:if>
			<c:if test="${board != null}">
				<input type="hidden" name="id" value="<c:out value='${board.id}' />" />
			</c:if>
			<div class="box">
				<table>
					<tr>
						<th><label for="date">日期<br />Date
						</label></th>
						<td><input id="date" type="text"
							value="<c:out value='${board.date}' />" name="date"
							required="required" autocomplete="new-text" autofocus></td>
					</tr>
					<tr>
						<th><label for="title">標題<br />Title
						</label></th>
						<td><input id="title" type="text"
							value="<c:out value='${board.title}' />" name="title"
							required="required" autocomplete="new-text"></td>
					</tr>
					<tr class="info">
						<th><label for="info">資訊<br />Information
						</label></th>
						<td><textarea name="info" required="required" rows="20"
								cols="50"><c:out value='${board.info}' /></textarea></td>
					</tr>
				</table>
				<br /> <input class="btn" type="submit" value="提交 / Submit" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
