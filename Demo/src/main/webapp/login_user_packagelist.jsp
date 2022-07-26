<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/lib/bootstrap.css" rel="stylesheet">
<link href="css/packagelist.css" rel="stylesheet">
<style>
@font-face {
  font-family:清松手寫體1;
  src: local("清松手寫體1"), url(清松手寫體1.ttf);
}
</style>
</head>
<body>
	<div class="screen">
		<div class="container-fluid h-100">
			<div class="box container-fluid">
				<div class="title row row-cols-5 d-flex">
					<div class="col">
						收件人<br />Recipient
					</div>
					<div class="col">
						收件地址<br />Address
					</div>
					<div class="col">
						物流(包裹)編號<br />TRK Number
					</div>
					<div class="col">
						管理員收件時間<br />Delivery date
					</div>
					<div class="col">
						包裹狀態<br />State
					</div>
				</div>
				<div class="title-inbox row row-cols-5 d-flex">
					<c:forEach var="userPackage" items="${packageList}">
							<div class="col"><c:out value="${userPackage.user_name}" /></div>
							<div class="col"><c:out value="${userPackage.user_address}" /></div>
							<div class="col">
							<c:out value="${userPackage.package_number}" />
							</div>
							<div class="col"><c:out
									value="${userPackage.created_date}" /></div>
							<div class="col"><c:out value="尚未領取" /></div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>