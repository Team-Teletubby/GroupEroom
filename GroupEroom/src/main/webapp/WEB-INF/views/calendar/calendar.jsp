<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='resources/calendar/main.css' rel='stylesheet' />
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
      initialDate: '2021-05-22',
      locale: initialLocaleCode,
      buttonIcons: false, // show the prev/next text
      weekNumbers: true,
      navLinks: true, // can click day/week names to navigate views
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      selectable: true,
      dateClick: function(){
    	  alert("!!!!!!");
      },
      select:function(info){
    	  calendar.addEvent({
    		  start: info.startStr,
    		  end: info.endStr,
    		  allDay: true
    	  });
      },
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
        {
          title: 'Lunch',
          start: '2020-09-12T12:00:00'
        },
        {
          title: 'Meeting',
          start: '2020-09-12T14:30:00'
        },
        {
          title: 'Happy Hour',
          start: '2020-09-12T17:30:00'
        },
        {
          title: 'Dinner',
          start: '2020-09-12T20:00:00'
        },
        {
          title: 'Birthday Party',
          start: '2020-09-13T07:00:00'
        },
        {
          title: 'Click for Google',
          url: 'http://google.com/',
          start: '2020-09-28'
        }
      ]
    });

    calendar.render();

    // build the locale selector's options
    calendar.getAvailableLocaleCodes().forEach(function(localeCode) {
      var optionEl = document.createElement('option');
      optionEl.value = localeCode;
      optionEl.selected = localeCode == initialLocaleCode;
      optionEl.innerText = localeCode;
      localeSelectorEl.appendChild(optionEl);
    });

    // when the selected option changes, dynamically change the calendar option
    localeSelectorEl.addEventListener('change', function() {
      if (this.value) {
        calendar.setOption('locale', this.value);
      }
    });

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
    margin: 40px auto;
    padding: 0 10px;
    background:white;
  }

</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sideBar.jsp"></jsp:include>
	
	<section id="main-content">	
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i>일정관리</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="content-panel">
              <h4><i class="fa fa-angle-right"></i>나의 일정</h4>
                <hr>
					<div id='top'>
					
					    Locales:
					    <select id='locale-selector'></select>
					
					 </div>
					
					 <div id='calendar'></div>
            </div>
          </div>
        </div>
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Launch demo modal </button>

<!-- 모달..  -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document"> <div class="modal-content">
<div class="modal-header"> <h5 class="modal-title" id="exampleModalLabel">일정등록</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span> </button> </div>
<div class="modal-body">
일정 : <input type="text"><br>
메모 : <input type="text">
</div>
<div class="modal-footer"> <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
<button type="button" class="btn btn-primary">Save changes</button>
</div>
</div>
</div>
</div>
       </section>
       </section>




</body>
</html>