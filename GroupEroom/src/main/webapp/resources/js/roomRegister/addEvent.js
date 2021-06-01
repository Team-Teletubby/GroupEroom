var eventModal = $('#eventModal');
// 입력 값 받아옴
var modalTitle = $('.modal-title');
var editAllDay = $('#edit-allDay');
var editStart = $('#edit-start');
var editEnd = $('#edit-end');
var editType = $('#edit-type');
var editColor = $('#edit-color');


var editTitle = $('#edit-title'); // 방이름(201room... 202room..) (1)
var bookingTitle = $('#bookingTitle'); // 예약명
var editDesc = $('#edit-desc'); // 설명 (2)

var addBtnContainer = $('.modalBtnContainer-addEvent');
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');


/* ****************
 *  새로운 일정 생성
 * ************** */
var newEvent = function (start, end, eventType) {

    $("#contextMenu").hide(); //메뉴 숨김

    modalTitle.html('새로운 일정');
    editType.val(eventType).prop('selected', true);
    editTitle.val('');
    console.log(start);
    editStart.val(start);
    editEnd.val(end);
    console.log(end);
    editDesc.val('');
    
    addBtnContainer.show();
    modifyBtnContainer.hide();
    eventModal.modal('show');

    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    var eventId = 1 + Math.floor(Math.random() * 1000);
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/

    //새로운 일정 저장버튼 클릭
    $('#save-event').unbind();
    $('#save-event').on('click', function () {
        // 입력 값 저장하는 곳


        
        var eventData = {
            _id: eventId,
            title: editTitle.val(),
            start: start,
            end: end,
            description: editDesc.val(),
            type: editType.val(),
            username: '사나',
        };

        console.log(eventData);

        if (eventData.start > eventData.end) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            return false;
        }

        if (eventData.title === '') {
            alert('일정명은 필수입니다.');
            return false;
        }

        var realEndDay;

        if (editAllDay.is(':checked')) {
            eventData.start = moment(eventData.start).format('YYYY-MM-DD');
            //render시 날짜표기수정
            eventData.end = moment(eventData.end).format('YYYY-MM-DD');
            //DB에 넣을때(선택)
            realEndDay = moment(eventData.end).format('YYYY-MM-DD');

            eventData.allDay = true;
        }

        $("#calendar").fullCalendar('renderEvent', eventData, true);
        eventModal.find('input, textarea').val('');
        editAllDay.prop('checked', false);
        eventModal.modal('hide');

        $('.time-set-wrap').hide();
        $('.contents-wrap').hide();
        //새로운 일정 저장
     
        $.ajax({
            url: "bkRegister.do",
            type: "post",
            data: {
                "roomNo" : editTitle.val(), 
                "bookingTitle" : bookingTitle.val(),
                "bContents" : editDesc.val(),
                "bookingStartDate" : start,
                "bookingEndDate" : end
            },
            success: function (success) {
            	if(success === 'bookingError') {
            		alert('이미 예약된 회의실입니다.');
            		bookingTitle.val("");
            	}else if(success === 'success') {
            		alert('예약이 등록 되었습니다.');
            		  location.href = "bkListView.do";
            	}else if(success === 'dayError') {
            		alert('이미 지난 날은 예약을 할 수 없습니다.');
            		bookingTitle.val("");
            	}
            
                //DB연동시 중복이벤트 방지를 위한
                //$('#calendar').fullCalendar('removeEvents');
                //$('#calendar').fullCalendar('refetchEvents');
            },
            error: function() {
            }
        });
    });
};