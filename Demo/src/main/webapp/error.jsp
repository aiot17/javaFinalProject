<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>

<head>
<title>Error</title>
<link rel="stylesheet" href="style/application.css" />
<link rel="stylesheet" href="style/header.css" />
<link rel="stylesheet" href="style/list.css" />
<style>
.title {
	width: 80%;
}

.box {
	width: 80%;
}
</style>
</head>

<body>
	<div class="screen">

		<div class="content">
			<div class="title error_title">Error</div>
			<div class="box">
				<%=exception.getMessage()%>
			</div>
		</div>
	</div>
</body>

</html>