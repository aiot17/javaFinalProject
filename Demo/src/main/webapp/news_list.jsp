<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css" />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
	*{
		margin:0;
		padding:0;
		box-sizing:border-box;
	}
	body, html{
		height:100%;
		font-family:清松手寫體1;
		font-weight:900;
		background:none;
	}
    
	.post{
		text-align:left;
		font-size:7vmin;
		margin-top:2%;
		font-weight:500;
	}
	
	.cont-post{
		background-color:white;
		border-radius:10px;
	}
	
	.ntitle{	
		text-align:center;
		font-size:10vmin;
		color:white;
	}
</style>
  <body>
<div class="container-fluid">
		<div class="ntitle w-100">今日新聞 Today's news</div>
		<div class="cont-post">	
			<c:forEach var="news" items="${newsList}">
				<div class="container-fluid d-flex justify-content-evenly">
					<li class="post"><c:out value="${news.title}" /></li>
				</div>
			</c:forEach>
		</div>	
</div>
</body>
</html>