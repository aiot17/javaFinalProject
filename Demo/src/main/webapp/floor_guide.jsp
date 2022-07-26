<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <title>樓層導覽 FloorNavigation</title>
  <link rel="stylesheet" href="style/application.css" />
  <link rel="stylesheet" href="style/header.css" />
  <link href="css/lib/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
    integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>
  <style>
  	.wholebuilding{
  		margin:auto;
  	}
  
    #building div {
      font-size: 24px;
      font-weight: bolder;
      border-top: 6px solid #5dacbd;
      border-right: 6px solid #5dacbd;
      border-left: 6px solid #5dacbd;
      padding:5%;
      margin:auto;
      text-align: center;
      line-height: 80px;
      position: relative;

    }
    #building #rf {
      width: 300px;
      height: 120px;
      text-align: center;
      padding-top: 25px;
      border-top-right-radius: 25px;
      border-top-left-radius: 25px;
    }
    #building #b1 {
      width: 300px;
      height: 160px;
      text-align: center;
      border-bottom: 6px solid #5dacbd;
      border-bottom-right-radius: 25px;
      border-bottom-left-radius: 25px;
      
    }

    #building #f7 {
      width: 300px;
      height: 160px;
      text-align: center;
      padding-top: 40px;
    }
    #building #f8 {
      width: 300px;
      height: 120px;
      text-align: center;
      padding-top: 25px;
    }
    #building #f2 {
      width: 300px;
      height: 120px;
      text-align: center;
      padding-top: 20px;
    }
    #building #f1 {
      width: 300px;
      height: 120px;
      text-align: center;
      
    }

    #i {
      width: 1000px;
      height: 750px;
      margin-top: 50px;
      box-shadow:15px 8px 8px #616130;
      border-radius:10px;
    }
	
	#desc {
	width:1000px;
	}
	
    #desc li {
      font-size: 24px;
      line-height: 60px;
    }

    #descbox {
      margin: auto;
    }
    
    .bkbtn{
    	font-size:6vmin;
    	border-radius: 20px;
    }
  </style>
</head>

<body>
  <div class="screen container-fluid">
    <div class="wholebuilding col-4" id="building">
      <div class="f" id="rf" value="6" style="color:#24527a; font-size: 30px;line-height: 1.2em;">RF<br>空中花園<br/></div>
      <div class="f" id="f8" value="8" style="color:#24527a; font-size: 30px;line-height: 1.2em;">10F<br>泳池&桑拿房</div>
      <div class="f" id="f7" value="7" style="color:#24527a; font-size: 30px;line-height: 1.2em;">3F-9F<br>住戶區<br/></div>
      <div class="f" id="f2" value="2" style="color:#24527a; font-size: 30px; line-height: 1.2em;">2F<br> 健身房&球場</div>
      <div class="f" id="f1" value="1" style="color:#24527a; line-height: 1.2em;font-size: 30px;padding:25px">1F <br>大廳&會議廳<br/></div>
      <div class="f" id="b1" value="b1" style="color:#24527a; font-size: 30px; line-height: 1.2em; padding: 40px;">B1-B3<br>地下停車場</div>
    </div>

    <div class="col-6" id="descbox">
      <div id="desc">
        <h1 id="t" style="color:#24527a">請選擇樓層(樓層導覽)</h1>
        <img src="image/home.jpg" id="i">
      </div>
    </div>
    <div class=" col-2 text-right">
    <input class="bkbtn fs-3 p-20" type="button" onclick="history.back()" value="返回首頁"></input>
    </div>
  </div>
  <script>
    var stop;
    var c = 0;
    var im;
    play1();
    function play(img) {
      stop = window.setInterval(function () {
        if (c == 3) {
          c = 0;
        }
        $("#i").attr("src", "images/" + img[c]);
        $("#i").css({"box-shadow":"15px 8px 8px #616130", "border-radius":"10px"})
        c += 1;
      }, 1000);
    }
    function play1(){
          $("#i").attr("src", "images/" + "home.jpg");
          $("#i").css({"box-shadow":"15px 8px 8px #616130", "border-radius":"10px"})
        };
    $(".f").hover(function () {
      $("#i").show()
      $(this).css("color","white")
      $(this).css({"backgroundColor": "#24527a"});
      if ($(this).attr("value") == "8") {
        $("#t").html("8F Pool & Sauna / 泳池 & 桑拿房")
        im = ['pool.jpg', 'pool2.jpg', 'pool3.jpg']
      }
      else if ($(this).attr("value") == "7") {
        $("#t").html("7F Resident / 住戶區")
        im = ["residence.jpg", "residence2.jpg", "residence3.jpg"]
      }
      else if ($(this).attr("value") == "6") {
        $("#t").html("RF Roof / 空中花園")
        im = ['roof.jpg',"roof1.jpg","roof3.webp"]
      }
      else if ($(this).attr("value") == "5") {
        $("#t").html("5F resident / 住戶區")
        im = ['pool.jpg', 'lobby.jpg', 'hallway2.jpg']
      }
      else if ($(this).attr("value") == "4") {
        $("#t").html("4F resident / 住戶區")
        im = ['pool.jpg', 'lobby.jpg', 'hallway2.jpg']
      }
      else if ($(this).attr("value") == "3") {
        $("#t").html("3F resident / 住戶區")
        im = ['pool.jpg', 'lobby.jpg', 'hallway2.jpg']
      }
      else if ($(this).attr("value") == "2") {
        $("#t").html("2F Gym & Sport Court/ 健身房 & 球場")
        im = ["gym1.jpg", "gym2.jpg", "gym3.jpg"]
      }
      else if ($(this).attr("value") == "1") {
        $("#t").html("1F Lobby / 大廳&會議廳")
        im = ["loby3.jpg", "lobby1.jpg", "meeting.jpg"]
      }
      else {
        $("#t").html("B1-B3 地下停車場")
        im = ["parking.png", "parking1.jpg", "parking.jpg"]

      }
      clearInterval(stop);
      play(im);
    }, function () {
      clearInterval(stop);
      $(this).css("color","#24527a")
      $(this).css("backgroundColor", " transparent");
      $("#i").hide()
      $("#t").html("請選擇樓層(樓層導覽)")
    });
  </script>
</body>

</html>
	