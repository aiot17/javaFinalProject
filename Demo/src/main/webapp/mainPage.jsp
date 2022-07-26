<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MainPage</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./twicon/twicon.css" />
<link href="./css/main.css" type="text/css" rel="stylesheet" />
<link href="css/lib/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="vh-100 overflow-hidden">
		<div class="top">
			<div class="left d-flex justify-content-evenly">

				<div class="box w-100 d-flex-row justify-content-evenly">
					<form action="facelogin.jsp">
						<button>
							<div class="icon">
								<i class="twicon-main-island"></i>
							</div>
							<div class="word">
								住戶登入
								<p class="en">Login</p>
							</div>
						</button>
					</form>
					
					
					<form action="api_activity_select.jsp">
						<button>
							<i class="twicon-taipei-stn"></i>場地租借狀況
							<p class="en">Space Rental</p>
						</button>
					</form>
					<form action="ballon.html">
						<button>
							<i class="twicon-balloon"></i>遊戲天地
							<p class="en">Game</p>
						</button>
					</form>
					<form action="floor_guide.jsp">
						<button>
							<i class="twicon-black-bear"></i>樓層導覽
							<p class="en">Floor Guide</p>
						</button>
					</form>
				</div>
			</div>
			<div class="right">
				<div class="posttitle w-100">
					<h2 class="post">社區佈告欄</h2>
				</div>
				<div class="posttitle-down m-auto container-fluid w-100 ">
					<div class="align-items-center h-100">
						<iframe class="container-fluid h-100"  src="apilistinfo"
							scrolling="no"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="down container-fluid">
			<div class="down-left col-5 d-flex">
				<p id="CName" class="weatherTitle fw-900 rounded-end"></p>
				<div class="weather">
					<div class="weatherNow"></div>
					<div class="weatherWeek"></div>
				</div>
				<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
				<script type="text/javascript" src="js/cityData.js"></script>
				<script type="text/javascript" src="js/WeatherScript.js"></script>

			</div>
			<div class="news down-middle col-5 ">
				<iframe class="new container-fluid h-90" src="searchNews"
					scrolling="no"></iframe>
			</div>
			<div class="down-right col-2">
				<div class="row timetitle"><p>現在時間</p></div>
				<div class="row text-center time" id="timeShow"></div>
			</div>
		</div>
	</div>
</body>
</html>