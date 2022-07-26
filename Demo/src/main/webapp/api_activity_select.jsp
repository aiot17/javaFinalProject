<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String act1 = "table_tennis";
	String desc1 = "桌球室<br />Table Tennis";
	String act2 = "basketball";
	String desc2 = "籃球場<br />Basketball";
	String act3 = "meeting_room";
	String desc3 = "會議室<br />Meeting Room";
	String act4 = "study_room";
	String desc4 = "自修室<br />Study Room";
	String act5 = "sauna";
	String desc5 = "桑拿房<br />Sauna";
	String act6 = "pool";
	String desc6 = "小型驗身泳池<br />Lap Pool";
%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/api_application.css" />
<style>
.nav {
	letter-spacing: 2em;
	margin-left: 8%;
}

li a {
	position: relative;
	top: 23%;
	left: 23%;
}

li {
	margin-top: 28%;
	width: 22vh;
	height: 22vh;
	border-radius: 100%;
	position: relative;
	display: inline-block;
	list-style: none;
	opacity: 0.5;
}

.title {
	border-radius: 50px;
	background-color: rgba(93, 172, 189, .5);
	width: 28%;
	font-size: 48px;
	font-weight: bolder;
	text-align: center;
	opacity: 0.5;
}

#table_tennis {
	background-color: #5dacbd
}

#basketball {
	background-color: #5dacbd;
}

#meeting_room {
	background-color: #5dacbd;
}

#study_room {
	background-color: #5dacbd;
}

#sauna {
	background-color: #5dacbd;
}

#pool {
	background-color: #5dacbd;
}

.btn {
	font-size: 6vmin;
	position: fixed;
	top: 10%;
	right: 10%;
	border-radius: 20px;
	background-color: transparent;
}
</style>
</head>

<body>
	<div class="screen">
		<div class="content">
			<div class="content_cover">
				<div class="title">
					請選擇項目<br />Please select activity
				</div>
				<button class="btn" onclick="history.back()">返回首頁</button>
				<div class="nav">
					<ul>
						<li id="<%out.print(act1);%>"><a
							href="api_date_select.jsp?activity=桌球室 / Table Tennis&desc=<%out.print(desc1);%>"><img
								src="images/<%out.print(act1);%>.png" /></a></li>
						<li id="<%out.print(act2);%>"><a
							href="api_date_select.jsp?activity=籃球場 / Basketball&desc=<%out.print(desc2);%>"><img
								src="images/<%out.print(act2);%>.png" /></a></li>
						<li id="<%out.print(act3);%>"><a
							href="api_date_select.jsp?activity=會議室 / Metting Room&desc=<%out.print(desc3);%>"><img
								src="images/<%out.print(act3);%>.png" /></a></li>
						<li id="<%out.print(act4);%>"><a
							href="api_date_select.jsp?activity=自修室 / Study Room&desc=<%out.print(desc4);%>"><img
								src="images/<%out.print(act4);%>.png" /></a></li>
						<li id="<%out.print(act5);%>"><a
							href="api_date_select.jsp?activity=桑拿房 / Sauna&desc=<%out.print(desc5);%>"><img
								src="images/<%out.print(act5);%>.png" /></a></li>
						<li id="<%out.print(act6);%>"><a
							href="api_date_select.jsp?activity=小型驗身泳池 / Lap Pool&desc=<%out.print(desc6);%>"><img
								src="images/<%out.print(act6);%>.png" /></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.6.0.js"></script>
	<script>
        $("#table_tennis").hover(function () {
            $(this).css('opacity', 1)
            $('.title').html('桌球室<br />Table Tennis').css('opacity', 1)
            $('.content').css('background-image', 'url(images/table_tennis.jpg)')
        }, function () {
            $(this).css('opacity', 0.5);
            $('.title').html('請選擇項目<br />Please select activity').css('opacity', 0.5)
            $('.content').css('background-image', 'none');
        });

        $("#basketball").hover(function () {
            $(this).css('opacity', 1)
            $('.title').html('籃球場<br />Basketball').css('opacity', 1)
            $('.content').css('background-image', 'url(images/basketball.jpg)');
        }, function () {
            $(this).css('opacity', 0.5)
            $('.title').html('請選擇項目<br />Please select activity').css('opacity', 0.5)
            $('.content').css('background-image', 'none');
        });

        $("#meeting_room").hover(function () {
            $(this).css('opacity', 1)
            $('.title').html('會議室<br />Meeting Room').css('opacity', 1)
            $('.content').css('background-image', 'url(images/meeting_room.jpg)');
        }, function () {
            $(this).css('opacity', 0.5)
            $('.title').html('請選擇項目<br />Please select activity').css('opacity', 0.5)
            $('.content').css('background-image', 'none')
        });

        $("#study_room").hover(function () {
            $(this).css('opacity', 1)
            $('.title').html('自修室<br />Study Room').css('opacity', 1)
            $('.content').css('background-image', 'url(images/study_room.jpg)')
        }, function () {
            $(this).css('opacity', 0.5)
            $('.title').html('請選擇項目<br />Please select activity').css('opacity', 0.5)
            $('.content').css('background-image', 'none')
        });

        $("#sauna").hover(function () {
            $(this).css('opacity', 1)
            $('.title').html('桑拿室<br />Sauna').css('opacity', 1)
            $('.content').css('background-image', 'url(images/sauna.jpg)')
        }, function () {
            $(this).css('opacity', 0.5)
            $('.title').html('請選擇項目<br />Please select activity').css('opacity', 0.5)
            $('.content').css('background-image', 'none')
        });

        $("#pool").hover(function () {
            $(this).css('opacity', 1)
            $('.title').html('小型健身泳池<br />Lab Pool').css('opacity', 1)
            $('.content').css('background-image', 'url(images/pool.jpg)')
            $('.content').css('background-size', 'cover')
        }, function () {
            $(this).css('opacity', 0.5)
            $('.title').html('請選擇項目<br />Please select activity').css('opacity', 0.5)
            $('.content').css('background-image', 'none')
        });
    </script>
</body>

</html>