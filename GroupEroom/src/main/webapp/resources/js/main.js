var draggedEventIsAllDay;
var activeInactiveWeekends = true;

var calendar = $('#calendar').fullCalendar({

 /** ******************
   *  OPTIONS
   * *******************/
  locale                    : 'ko',    
  timezone                  : "local", 
  nextDayThreshold          : "09:00:00",
  allDaySlot                : true,
  displayEventTime          : true,
  displayEventEnd           : true,
  firstDay                  : 0, //월요일이 먼저 오게 하려면 1
  weekNumbers               : false,
  selectable                : true,
  weekNumberCalculation     : "ISO",
  eventLimit                : true,
  views                     : { 
                                month : { eventLimit : 2 } // 한 날짜에 최대 이벤트 12개, 나머지는 + 처리됨
                              },
  eventLimitClick           : 'week', //popover
  navLinks                  : true,
  defaultDate               : moment(), //실제 사용시 현재 날짜로 수정
  timeFormat                : 'HH시',
  defaultTimedEventDuration : '01:00:00',
  editable                  : true,
  minTime                   : '00:00:00',
  maxTime                   : '24:00:00',
  slotLabelFormat           : 'HH',
  weekends                  : true,
  nowIndicator              : true,
  dayPopoverFormat          : 'MM/DD dddd',
  longPressDelay            : 0,
  eventLongPressDelay       : 0,
  selectLongPressDelay      : 0,  
  header                    : {
                                left   : 'today',
                                center : 'prev, title, next',
                                right  : 'month,  listWeek'
                              },
  views                     : {
                                month : {
                                  columnFormat : 'dddd'
                                },
                                agendaWeek : {
                                  columnFormat : 'M/D ddd',
                                  titleFormat  : 'YYYY년 M월 D일',
                                  eventLimit   : false
                                },
                                agendaDay : {
                                  columnFormat : 'dddd',
                                  eventLimit   : false
                                },
                                listWeek : {
                                  columnFormat : ''
                                }
                              },
  customButtons             : { //주말 숨기기 & 보이기 버튼
                                viewWeekends : {
                                  text  : '주말',
                                  click : function () {
                                    activeInactiveWeekends ? activeInactiveWeekends = false : activeInactiveWeekends = true;
                                    $('#calendar').fullCalendar('option', { 
                                      weekends: activeInactiveWeekends
                                    });
                                  }
                                }
                              },


  eventRender: function (event, element, view) {

    //일정에 hover시 요약
    element.popover({
      title: $('<div />', {
        class: 'popoverTitleCalendar',
        text: event.title
      }).css({
        'background': event.backgroundColor,
        'color': event.textColor
      }),
      content: $('<div />', {
          class: 'popoverInfoCalendar'
        }).append('<p><strong>등록자:</strong> ' + event.username + '</p>')
        .append('<p><strong>구분:</strong> ' + event.type + '</p>')
        .append('<p><strong>시간:</strong> ' + getDisplayEventDate(event) + '</p>')
        .append('<div class="popoverDescCalendar"><strong>설명:</strong> ' + event.description + '</div>'),
      delay: {
        show: "800",
        hide: "50"
      },
      trigger: 'hover',
      placement: 'top',
      html: true,
      container: 'body'
    });

    return filtering(event);

  },

  /* ****************
   *  일정 받아옴 
   * ************** */
  events: function (start, end, timezone, callback) {
    $.ajax({
      type: "get",
      url: "data.json",
      data: {
        // 화면이 바뀌면 Date 객체인 start, end 가 들어옴
        //startDate : moment(start).format('YYYY-MM-DD'),
        //endDate   : moment(end).format('YYYY-MM-DD')
      },
      success: function (response) {
        var fixedDate = response.map(function (array) {
          if (array.allDay && array.start !== array.end) {
            array.end = moment(array.end).add(1, 'days'); // 이틀 이상 AllDay 일정인 경우 달력에 표기시 하루를 더해야 정상출력
          }
          return array;
        });
        callback(fixedDate);
      }
    });
  },

  eventAfterAllRender: function (view) {
    if (view.name == "month") $(".fc-content").css('height', 'auto');
  },

  //일정 리사이즈
  eventResize: function (event, delta, revertFunc, jsEvent, ui, view) {
    $('.popover.fade.top').remove();

    /** 리사이즈시 수정된 날짜반영
     * 하루를 빼야 정상적으로 반영됨. */
    var newDates = calDateWhenResize(event);

    //리사이즈한 일정 업데이트
    $.ajax({
      type: "get",
      url: "",
      data: {
        //id: event._id,
        //....
      },
      success: function (response) {
        alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
      }
    });

  },

  eventDragStart: function (event, jsEvent, ui, view) {
    draggedEventIsAllDay = event.allDay;
  },

  //일정 드래그앤드롭
  eventDrop: function (event, delta, revertFunc, jsEvent, ui, view) {
    $('.popover.fade.top').remove();

    //주,일 view일때 종일 <-> 시간 변경불가
    if (view.type === 'agendaWeek' || view.type === 'agendaDay') {
      if (draggedEventIsAllDay !== event.allDay) {
        alert('드래그앤드롭으로 종일<->시간 변경은 불가합니다.');
        location.reload();
        return false;
      }
    }

    // 드랍시 수정된 날짜반영
    var newDates = calDateWhenDragnDrop(event);

    //드롭한 일정 업데이트
    $.ajax({
      type: "get",
      url: "",
      data: {
        //...
      },
      success: function (response) {
        alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
      }
    });

  },


  // 캘린더에서 날짜 클릭 시,
  select: function (startDate, endDate, jsEvent, view) {
    // 캘린더 tbody
    $(".fc-body").unbind('click');
    $(".fc-body").on('click', 'td', function (e) {
      
      // 일자 클릭시 예약 시간 폼 보여주는 기능
      $(".time-set-wrap")
      .addClass("contextOpened")
        .css({
          display: "block",
        });
      return false;
    });

    var today = moment();
    var time = 0;

    if (view.name == "month") {
      // 초기 시간 셋팅 (시작)
      startDate.set({
        hours: 9
      });

      // 초기 시간 셋팅 (끝)
      endDate.set({
        hours: 9
      });

      endDate = moment(endDate).subtract(1, 'days').format('YYYY-MM-DD 10');
      
      // 특정 시간 버튼 클릭 시, 시간 맞춰주기
      $('#time-09s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 09');
        endDate = moment(endDate).format('YYYY-MM-DD 10');
      });

      $('#time-10s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 10');
        endDate = moment(endDate).format('YYYY-MM-DD 11');
      });

      $('#time-11s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 11');
        endDate = moment(endDate).format('YYYY-MM-DD 12');
      });

      $('#time-12s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 12');
        endDate = moment(endDate).format('YYYY-MM-DD 13');
      });

      $('#time-13s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 13');
        endDate = moment(endDate).format('YYYY-MM-DD 14');
      });

      $('#time-14s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 14');
        endDate = moment(endDate).format('YYYY-MM-DD 15');
      });

      $('#time-15s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 15');
        endDate = moment(endDate).format('YYYY-MM-DD 16');
      });

      $('#time-16s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 16');
        endDate = moment(endDate).format('YYYY-MM-DD 17');
      });

      $('#time-17s').on("click", function() {
        startDate = moment(startDate).format('YYYY-MM-DD 17');
        endDate = moment(endDate).format('YYYY-MM-DD 18');
      });

    } else {
      startDate = moment(startDate).format('YYYY-MM-DD HH');
      endDate = moment(endDate).format('YYYY-MM-DD HH');
    } 

    // 메뉴 id값
    var $contextMenu = $(".time-set-wrap");
    // 메뉴에서 a태그를 누르면 (카테고리1, 2, 3, 4) 모달창 뜸
    $contextMenu.on("click", "div", function () {
      $('.contents-wrap')
      .addClass("contextOpened")
        .css({
          display: "block",
        });
      //닫기 버튼이 아닐때
      if ($(this).data().role !== 'close') {
        // 데이터 저장할 수 있도록 넘겨주는 부분
        newEvent(startDate, endDate, $(this).html());
      }

    });

    $('body').on('click', function () {
      $contextMenu.removeClass("contextOpened");
    });

  },

  //이벤트 클릭시 수정이벤트
  eventClick: function (event, jsEvent, view) {
    editEvent(event);
  }

});

function getDisplayEventDate(event) {

  var displayEventDate;

  if (event.allDay == false) {
    var startTimeEventInfo = moment(event.start).format('HH');
    var endTimeEventInfo = moment(event.end).format('HH');
    displayEventDate = startTimeEventInfo + " - " + endTimeEventInfo;
  } else {
    displayEventDate = "하루종일";
  }

  return displayEventDate;
}

function filtering(event) {
  var show_username = true;
  var show_type = true;

  var username = $('input:checkbox.filter:checked').map(function () {
    return $(this).val();
  }).get();
  var types = $('#type_filter').val();

  show_username = username.indexOf(event.username) >= 0;

  if (types && types.length > 0) {
    if (types[0] == "all") {
      show_type = true;
    } else {
      show_type = types.indexOf(event.type) >= 0;
    }
  }

  return true;
}

function calDateWhenResize(event) {

  var newDates = {
    startDate: '',
    endDate: ''
  };

  if (event.allDay) {
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
    newDates.endDate = moment(event.end._d).format('YYYY-MM-DD');
  } else {
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD HH');
    newDates.endDate = moment(event.end._d).format('YYYY-MM-DD HH');
  }

  return newDates;
}

function calDateWhenDragnDrop(event) {
  // 드랍시 수정된 날짜반영
  var newDates = {
    startDate: '',
    endDate: ''
  }

  // 날짜 & 시간이 모두 같은 경우
  if(!event.end) {
    event.end = event.start;
  }

  //하루짜리 all day
  if (event.allDay && event.end === event.start) {
    console.log('1111')
    newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
    newDates.endDate = newDates.startDate;
  }
  return newDates;
}