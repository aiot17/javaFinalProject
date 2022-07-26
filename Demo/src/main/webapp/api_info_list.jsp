<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/lib/bootstrap.css">

<style>
html,body {
	background: none;
}

</style>
</head>
<body>
	<div class="screen">
		<div class="content w-100 ">
			<div class="box container-fluid">
				<div class="title container-fluid d-flex fw-bold">
							<div class="fs-3 col-2 table_title ">標題 / Title
							</div>
							<div class="fs-3 col-7 table_info text-center">資訊 / Information
							</div>
							<div class="fs-4 col-3 time ">公布時間 / Update Time
							</div>
				</div>
				<br>
				<div class="container-fluid d-flex">
					<div class="row row-cols-3">
						<c:forEach var="board" items="${listInfo}">
							
								<div class="col-2 fs-5 table_title border-bottom border-secondary"><c:out value="${board.title}" /></div>
								<div class="col-7 fs-5 table_info border-bottom border-secondary"><c:out value="${board.info}" /></div>
								<div class="col-3 fs-5 time border-bottom border-secondary"><c:out value="${board.last_modified}" /></div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>