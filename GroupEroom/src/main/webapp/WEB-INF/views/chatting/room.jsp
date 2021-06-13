<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
@font-face {
    font-family: 'EliceDigitalBaeum_Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/EliceDigitalBaeum_Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
	* {
		font-family: EliceDigitalBaeum_Regular;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>Room</title>
	<style>
		*{
			margin:0;
			padding:0;
		}
		
		a:link { color: red; text-decoration: none;}
		a:visited { color: black; text-decoration: none;}
 		a:hover { text-decoration: none;}



		.container{
			width: 500px;
			
		}
		.container .wrap-title{
			text-align: left;
			padding: 16px 5px 5px 30px;
			color: #FFBB00;
			background-color: #4ECDC4;
			color: white;
			height: 50px;
			font-size: 25px;
			font-weight: 600;
		}
		
		.room-area {
		width: 100%;
		height: 90px;
		margin-bottom: 6px;
		background-color: white;
		}
		
		.room-area:hover {
			background-color: #cff1ef;
			
		}
		
		.room-area  div {
			padding: 17px 0px 15px 30px;
		}
	
		.room-area .room-no {
			margin-bottom: 10px;
			font-size: 14px;
			font-weight: 600;
			color: #d2d2d2;
		}
		
		.room-area .room-name {
			font-size: 17px;
			font-weight: 700;
			color: #797979;
		}
		
		.roomContainer{
			background-color: #F6F6F6;
			width: 500px;
			height: 690px;
			overflow: auto;
			padding-top: 10px;
		}
		.roomList{
			border: none;
		}
		.roomList th{
			border: 1px solid #FFBB00;
			background-color: #fff;
			color: #FFBB00;
		}
		.roomList td{
			border: 1px solid #FFBB00;
			background-color: #fff;
			text-align: left;
			color: #FFBB00;
		}
		.roomList .num{
			width: 75px;
			text-align: center;
		}
		.roomList .room{
			width: 350px;
		}
		.roomList .go{
			width: 71px;
			text-align: center;
		}
		button{
			background-color: #FFBB00;
			font-size: 14px;
			color: #000;
			border: 1px solid #000;
			border-radius: 5px;
			padding: 3px;
			margin: 3px;
		}
		.inputTable th{
			padding: 5px;
		}
		.inputTable input{
			width: 330px;
			height: 25px;
		}
	</style>
</head>

<script type="text/javascript">
	var ws;
	window.onload = function(){
		getRoom();
		createRoom();
	}

	function getRoom(){
		commonAjax('/getRoom.do', "", 'post', function(result){
			createChatingRoom(result);
		});
	}
	
	function createRoom(){
		$("#createRoom").click(function(){
			var msg = {	roomName : $('#roomName').val()	};
			console.log("createRoom 에서 방 생성한 이름 :" + msg.roomName);
		
			commonAjax('/createRoom.do', msg, 'post', function(result){
				console.log("스프링에서 받아온 값 : " + result.toString());
				createChatingRoom(result);
			});

			$("#roomName").val("");
		});
	}

	function goRoom(number, name){
		location.href="/moveChating.do?roomName="+name+"&"+"roomNumber="+number;
	}

	function createChatingRoom(res){
		console.log("결과값" + res.roomName);
		var tag = $('#roomContainer');
		if(res != null){
			res.forEach(function(d, idx){
				var html = "";
				var rn = d.roomName.trim();
				var roomNumber = d.roomNumber;
				console.log("roomNumber: " + roomNumber);
				html += "<div class='room-area' onclick='goRoom(\""+roomNumber+"\", \""+rn+"\")'>";
				html += "<a href='#'>";
				html += "<div>";
				html += "<p class='room-no'>" + (idx+1) + "번 방";
				html += "</p>";
				html += "<p class='room-name'>" + rn;
				html += "</p>";
				html += "</div>";
				html += "</a>";
				html += "</div>";
				
				$('#roomContainer').append(html);
			});
		}
	}

	function commonAjax(url, parameter, type, calbak, contentType){
		$.ajax({
			url: url,
			data: parameter,
			type: type,
			contentType : contentType!=null?contentType:'application/x-www-form-urlencoded; charset=UTF-8',
			success: function (res) {
				calbak(res);
			},
			error : function(err){
				console.log('error');
				calbak(err);
			}
		});
	}
</script>
<body>
	<div class="container">
		<p class="wrap-title">채팅방</p>
		<div id="roomContainer" class="roomContainer">
		</div>
		<div>
			<table class="inputTable">
				<tr>
					<th>방 제목</th>
					<th><input type="text" name="roomName" id="roomName"></th>
					<th><button id="createRoom">방 만들기</button></th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>