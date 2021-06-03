<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/style2.css" rel="stylesheet">
  
<link href='resources/calendar/main.css' rel='stylesheet' />
<link href="resources/calendar/colorpick.css" rel="stylesheet">
<script src='resources/calendar/main.js'></script>
<script src='resources/calendar/locales-all.js'></script>
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var initialLocaleCode = 'ko';
    var localeSelectorEl = document.getElementById('locale-selector');
    var calendarEl = document.getElementById('calendar');
    var today = new Date();
   /*  var t = today.getFullYear() + "-" + today.getMonth() + "-" + today.getDate(); */
    var t = String(today.getFullYear()) + "-" + String(today.getMonth()+1) + "-" + String(today.getDate());

   console.log(t)
   
    var calendar = new FullCalendar.Calendar(calendarEl, {
    	headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
      initialDate: '2021-06-01',
      locale: initialLocaleCode,
      buttonIcons: false, // show the prev/next text
      weekNumbers: true,
      navLinks: true, // can click day/week names to navigate views
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      selectable: true,
      events: 'https://fullcalendar.io/demo-events.json?overload-day',
       select: function(info) {
    	 alert('selected ' + info.startStr + ' to ' + info.endStr);
    	} ,
       
      events: [
        {
          title: 'All Day Event',
          start: '2020-09-01'
        },
        {
          title: 'Long Event',
          start: '2020-09-07',
          end: '2020-09-10'
        },
        {
          groupId: 999,
          title: 'Repeating Event',
          start: '2020-09-09T16:00:00'
        },
        {
          groupId: 999,
          title: 'Repeating Event',
          start: '2020-09-16T16:00:00'
        },
        {
          title: 'Conference',
          start: '2020-09-11',
          end: '2020-09-13'
        },
        {
          title: 'Meeting',
          start: '2020-09-12T10:30:00',
          end: '2020-09-12T12:30:00'
        },
        
         <c:forEach var ='i' items='${calList}'>
    	 { 
    		no:'${i.calNo}',
    	  	title: '${i.calTitle}',
    		start:'${i.startDate}',
    		end:'${i.endDate}',
    		info:'${i.calInfo}',
    		backgroundColor : '${i.color}',
    		borderColor : '${i.color}'
    	},
		</c:forEach>
    	{
            title: '종강',
            start: '2021-06-13',
            end: '2021-06-13',
         }
      ]
    });
    calendar.render();
  });

</script>
<style>

  body {
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #top {
    background: #eee;
    border-bottom: 1px solid #ddd;
    padding: 0 10px;
    line-height: 40px;
    font-size: 12px;
  }

  #calendar {
    max-width: 1100px;
    margin : 0px 200px 10px 200px;
    background:white;
  }

</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	
	
<!-- 모달..  -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header"> <h3 class="modal-title" id="exampleModalLabel">일정등록</h3>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span> </button>
</div>
<form action="registerCal.do" method="post">
<div class="modal-body">
	일정 : <input type="text" class="form-control" name="calTitle"><br>
	색상 : 
	<div>
			<input value="#db2828" type="radio" name="color" id="red" value="red" />
			<label for="red"><span class="red"></span></label>
			
			<input value="#f2711c" type="radio" name="color" id="orange" />
			<label for="orange"><span class="orange"></span></label>
			
			
			<input value="#fbbd08" type="radio" name="color" id="yellow" />
			<label for="yellow"><span class="yellow"></span></label>
			
			<input value="#b5cc18" type="radio" name="color" id="olive" />
			<label for="olive"><span class="olive"></span></label>
			
			<input value="#21ba45" type="radio" name="color" id="green" />
			<label for="green"><span class="green"></span></label>
			
			<input value="#00b5ad" type="radio" name="color" id="teal" />
			<label for="teal"><span class="teal"></span></label>
			
			<input value="#2185d0" type="radio" name="color" id="blue" />
			<label for="blue"><span class="blue"></span></label>
			
			<input value="#6435c9" type="radio" name="color" id="violet" />
			<label for="violet"><span class="violet"></span></label>
			
			<input value="#a333c8" type="radio" name="color" id="purple" />
			<label for="purple"><span class="purple"></span></label>
			
			<input value="#e03997" type="radio" name="color" id="pink" />
			<label for="pink"><span class="pink"></span></label>
	</div>
	시작 일자 :  <input type="date" class="form-control" name="startDate">
	시작 시간 : <input type="time" class="form-control" name="startTime">
	<hr style="border:1px solid lightgray;">
	종료 일자 :  <input type="date" class="form-control" name="endDate">
	종료 시간 : <input type="time" class="form-control" name="endTime">
	메모 : <textarea name="calInfo" class="form-control"></textarea>	
</div>
<div class="modal-footer"> <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
<input type="submit" class="btn btn-theme" value="일정등록">
</div>
</form>

</div>
</div>
</div>	
	
	
	

	<section id="main-content">	
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i>일정관리</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="form-panel">
              <h4><i class="fa fa-angle-right"></i>나의 일정</h4>
                <hr>
                <div align="center">
				<div id='calendar'></div>
		        <button class="btn btn-theme02" data-toggle="modal" data-target="#exampleModal">일정추가</button>
				</div>
            </div>
          </div>
        </div>
      </section>
   </section>
   
   
</body>
</html>