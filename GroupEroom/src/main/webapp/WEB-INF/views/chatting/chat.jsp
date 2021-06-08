<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<<<<<<< HEAD
	
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
=======
	<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
	<link rel="stylesheet" href="resources/css/chat/chat.css"/>
	<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
	<link href='https://use.fontawesome.com/releases/v5.7.2/css/all.css'>
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git
<meta charset="UTF-8">
<title>Chating</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.container {
	width: 500px;
}

.container h1 {
	text-align: left;
	padding: 5px 5px 5px 15px;
	color: #FFBB00;
	border-left: 3px solid #FFBB00;
	margin-bottom: 20px;
}

.chating {
	background-color: #000;
	width: 500px;
	height: 500px;
	overflow: auto;
}

.chating .me {
	color: #F6F6F6;
	text-align: right;
}

.chating .others {
	color: #FFE400;
	text-align: left;
}

input {
	width: 330px;
	height: 25px;
}

#yourMsg {
	display: show;
}
</style>
</head>

<script type="text/javascript">
	$("document").ready(function() {
		chatLog();
		
	});
	var ws;
	var roomNumber = ${roomNumber};
	var userName1 = '${userName}';
	var userId = ${userId };
	
	function chatLog() {
		$.ajax({
			url : "/chatLogDate.do",
			type : "post",
			data : {
				"roomNumber" : roomNumber
			},
			dataType : "json",
			success : function(data) {
				const $chatingTag = $("#chating");
				const html = "";
				console.log(data);
				for(var i in data) {
					
					if(data[i].userId == userId ){
<<<<<<< HEAD
						html += "<div class='media media-chat media-chat-reverse'>";
						html += "<div class='media-body'>";
						html += "<p>" + data[i].msg;
						html += "</p>";
						html += "<p class='meta' id='meta-time'>" + moment(data[i].chatCreateDate).format("HH:mm:ss");
						html += "</p>";
						html += "</div>";
						html += "</div>";
=======
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git
						
						$("#chating").append("<p class='me'>나 :" + data[i].msg + "</p>");
					}else {
<<<<<<< HEAD
						html += "<div class='media media-chat'>";
						html += "<div class='flex-div'>";
						html += "<img class='avatar' src='https://img.icons8.com/color/36/000000/administrator-male.png' alt='프로필 이미지'>";
						html += "<span>" + data[i].userName; 
						html += "</span>";
						html += "</div>";
						html += "<div class='media-body'>";
						html += "<p>" + data[i].msg;
						html += "</p>";
						html += "<p class='meta' id='meta-time'>" + moment(data[i].chatCreateDate).format("HH:mm:ss");
						html += "</p>";
						html += "</div>";
						html += "</div>";
						
						$("#chat-content").append(html);
=======
						$("#chating").append("<p class='others'>" + data[i].userName + " :" + data[i].msg + "</p>");
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git
					}
					
				}
			}
			
		});
	}
	wsOpen();
	function wsOpen(){
		//웹소켓 전송시 현재 방의 번호를 넘겨서 보낸다.
		ws = new WebSocket("ws://" + location.host + "/chating/"+roomNumber+".do");
		wsEvt();
	}
		
	function wsEvt() {
		ws.onopen = function(data){
			//소켓이 열리면 동작
		}
		
		ws.onmessage = function(data) {
			//메시지를 받으면 동작
			var msg = data.data;
			console.log(msg);
			console.log(${userId});
			if(msg != null && msg.trim() != ''){
				var d = JSON.parse(msg);
				if(d.type == "getId"){
					var si = d.sessionId != null ? d.sessionId : "";
					if(si != ''){
						$("#sessionId").val(si); 
					}
				}else if(d.type == "message"){
					if(d.userId == ${userId }){
<<<<<<< HEAD
						html += "<div class='media media-chat media-chat-reverse'>";
						html += "<div class='media-body'>";
						html += "<p>" + d.msg;
						html += "</p>";
						html += "<p class='meta' id='meta-time'>" + moment(data[i].chatCreateDate).format("HH:mm:ss");
						html += "</p>";
						html += "</div>";
						html += "</div>";
						
						$("#chat-content").append(html);	
=======
						$("#chating").append("<p class='me'>나 :" + d.msg + "</p>");	
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git
					}else{
<<<<<<< HEAD
						html += "<div class='media media-chat'>";
						html += "<div class='flex-div'>";
						html += "<img class='avatar' src='https://img.icons8.com/color/36/000000/administrator-male.png' alt='프로필 이미지'>";
						html += "<span>" + d.userName; 
						html += "</span>";
						html += "</div>";
						html += "<div class='media-body'>";
						html += "<p>" + d.msg;
						html += "</p>";
						html += "<p class='meta' id='meta-time'>" + moment(data[i].chatCreateDate).format("HH:mm:ss");
						html += "</p>";
						html += "</div>";
						html += "</div>";
						
						$("#chat-content").append(html);
=======
						$("#chating").append("<p class='others'>" + d.userName + " :" + d.msg + "</p>");
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git
					}
						
				}else{
					console.warn("unknown type!");
				}
			}
		}

		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}

	/* function chatName(){
		var userName = $("#userName").val();
		if(userName == null || userName.trim() == ""){
			alert("사용자 이름을 입력해주세요.");
			$("#userName").focus();
		}else{
			wsOpen();
			$("#yourName").hide();
			$("#yourMsg").show();
		}
	} */
	
	function send() {
		console.log($("#chatting").val());
		var option ={
				type: "message",
				roomNumber: $("#roomNumber").val(),
				sessionId : $("#sessionId").val(),
				userName : userName1,
				userId : ${userId},
				msg : $("#chatting").val()
		}
		ws.send(JSON.stringify(option))
		
		$.ajax({
			url : "/registerChatDate.do",
			type : "get",
			data : {
				type: "message",
				roomNumber: $("#roomNumber").val(),
				userName : userName1,
				userId : ${userId},
				msg : $("#chatting").val()
			}
		})
		$('#chatting').val("");
	}
	
	function goBack() {
		location.href='/room.do'; 
	}
</script>
<body>
<div class="page-content page-container" id="page-content">
<<<<<<< HEAD
        <div>
            <div class="row container d-flex justify-content-center">
                <div class="col-md-6">
                    <div class="card card-bordered">
                        <div class="card-header">
                            <h4 class="card-title"><strong>${roomName}</strong></h4>
                            <button onclick="goBack()">나가기</button>
                        </div>
                        <div class="ps-container ps-theme-default ps-active-y" id="chat-content" style="overflow-y: scroll !important; height:700px !important;">
                            
                            <div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
                                <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div>
                            </div>
                            <div class="ps-scrollbar-y-rail" style="top: 0px; height: 0px; right: 2px;">
                                <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 2px;"></div>
=======
    <div>
        <div class="row container d-flex justify-content-center">
            <div class="col-md-6">
                <div class="card card-bordered">
                    <div class="card-header">
                        <h4 class="card-title"><strong>Chat</strong></h4> <a class="btn btn-xs btn-secondary" href="#" data-abc="true">Let's Chat App</a>
                    </div>
                    <div class="ps-container ps-theme-default ps-active-y" id="chat-content" style="overflow-y: scroll !important; height:400px !important;">
                        <div class="media media-chat"> <img class="avatar" src="https://img.icons8.com/color/36/000000/administrator-male.png" alt="...">
                            <div class="media-body">
                                <p>Hi</p>
                                <p>How are you ...???</p>
                                <p>What are you doing tomorrow?<br> Can we come up a bar?</p>
                                <p class="meta"><time datetime="2018">23:58</time></p>
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git
                            </div>
                        </div>
                        <div class="media media-meta-day">Today</div>
                        <div class="media media-chat media-chat-reverse">
                            <div class="media-body">
                                <p>Hiii, I'm good.</p>
                                <p>How are you doing?</p>
                                <p>Long time no see! Tomorrow office. will be free on sunday.</p>
                                <p class="meta"><time datetime="2018">00:06</time></p>
                            </div>
                        </div>
                        <div class="media media-chat"> <img class="avatar" src="https://img.icons8.com/color/36/000000/administrator-male.png" alt="...">
                            <div class="media-body">
                                <p>Okay</p>
                                <p>We will go on sunday? </p>
                                <p class="meta"><time datetime="2018">00:07</time></p>
                            </div>
                        </div>
                        <div class="media media-chat media-chat-reverse">
                            <div class="media-body">
                                <p>That's awesome!</p>
                                <p>I will meet you Sandon Square sharp at 10 AM</p>
                                <p>Is that okay?</p>
                                <p class="meta"><time datetime="2018">00:09</time></p>
                            </div>
                        </div>
                        <div class="media media-chat"> <img class="avatar" src="https://img.icons8.com/color/36/000000/administrator-male.png" alt="...">
                            <div class="media-body">
                                <p>Okay i will meet you on Sandon Square </p>
                                <p class="meta"><time datetime="2018">00:10</time></p>
                            </div>
                        </div>
                        <div class="media media-chat media-chat-reverse">
                            <div class="media-body">
                                <p>Do you have pictures of Matley Marriage?</p>
                                <p class="meta"><time datetime="2018">00:10</time></p>
                            </div>
                        </div>
                        <div class="media media-chat"> <img class="avatar" src="https://img.icons8.com/color/36/000000/administrator-male.png" alt="...">
                            <div class="media-body">
                                <p>Sorry I don't have. i changed my phone.</p>
                                <p class="meta"><time datetime="2018">00:12</time></p>
                            </div>
                        </div>
                        <div class="media media-chat media-chat-reverse">
                            <div class="media-body">
                                <p>Okay then see you on sunday!!</p>
                                <p class="meta"><time datetime="2018">00:12</time></p>
                            </div>
                        </div>
                        <div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
                            <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div>
                        </div>
                        <div class="ps-scrollbar-y-rail" style="top: 0px; height: 0px; right: 2px;">
                            <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 2px;"></div>
                        </div>
                    </div>
                    <div class="publisher bt-1 border-light"> <img class="avatar avatar-xs" src="https://img.icons8.com/color/36/000000/administrator-male.png" alt="..."> <input class="publisher-input" type="text" placeholder="Write something"> <span class="publisher-btn file-group"> <i class="fa fa-paperclip file-browser"></i> <input type="file"> </span> <a class="publisher-btn" href="#" data-abc="true"><i class="fa fa-smile"></i></a> <a class="publisher-btn text-info" href="#" data-abc="true"><i class="fa fa-paper-plane"></i></a> </div>
                </div>
            </div>
        </div>
    </div>
</div>
	<%-- <div id="container" class="container">
		<h1>${roomName}의채팅방</h1>
		<input type="hidden" id="sessionId" value=""> 
		<input type="hidden" id="roomNumber" value='${roomNumber}'>

		<div id="chating" class="chating"></div>

		<!-- <div id="yourName">
			<table class="inputTable">
				<tr>
					<th>사용자명</th>
					<th><input type="text" name="userName" id="userName"></th>
					<th><button onclick="chatName()" id="startBtn">이름 등록</button></th>
				</tr>
			</table>
		</div> -->
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div> --%>
</body>
</html>