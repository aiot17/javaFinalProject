<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>MainPage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./twicon/twicon.css" />
    <link href="./css/main.css" type="text/css" rel="stylesheet" />
    <link href="css/lib/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="top">
        <div class="right h-100">
            <h2 class="post">人臉辨識</h2>
            <iframe class="container-fluid h-100" name="faceLoginFrame" src="http://192.168.22.78:5438/face_login.html" frameborder="0"></iframe>
        </div>
    </div>
    <div class="down container-fluid">
			<div class="down-left col-5 d-flex">
				<h3 id="CName" class="weatherTitle"></h3>
				<div class="weather">
					<div class="weatherNow"></div>
					<div class="weatherWeek"></div>
				</div>
				<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
				<script type="text/javascript" src="js/cityData.js"></script>
				<script type="text/javascript" src="js/WeatherScript.js"></script>

			</div>
			<div class="news down-middle col-5 ">
				<iframe class="container-fluid h-100" src="searchNews"
					scrolling="no"></iframe>
			</div>
			<div class="down-right col-2">
				<div class="row timetitle"><p>現在時間</p></div>
				<div class="row text-center time" id="timeShow"></div>
			</div>
		</div>
	</div>
</body>
<script>
    window.addEventListener("message", function (e) {
        console.log("123456"+e.origin);
    	if (e.origin.indexOf("192.168.22.78")<0) {
            return;
        }
        
        let data = e.data;
   		let cmd = 'location.href="http://192.168.22.98:8080/Demo/chrome?user='+data+'"';
   		setTimeout(cmd,2000);
    });
    
		
    window.onload = function () {
        window.frames["faceLoginFrame"].postMessage("456", "http://192.168.22.78:5438/face_login.html");
    }
</script>

</html>