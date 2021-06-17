
# GROUP E ROOM
------------
## 팀원 
김동준, 이혜성, 조혜리, 한정서

------------
## 수행기간
2021년 4월 26일 ~ 6월 15일

------------


## Contetns

1. [개요](#개요)
2. [설계의 주안점](#설계의-주안점)
3. [사용기술 및 개발환경](#사용기술-및-개발환경)
4. [프로젝트 기능 구현](#프로젝트-기능-구현)
5. [주요기능](#주요기능)
6. [Document](#Document)

------------

## 개요
+ 많은 기업에서 그룹웨어 사용이 보편화 되어있지만 소기업 혹은 청년층이 주인 스타트업 기업에서 사용할 수 있는 가벼운 그룹웨어가 부재해 이에 필요성을 느꼈습니다.
따라서 우리의 목표는 업무에 꼭 필요한 기능만 추가하여 라이트하지만 업무 능률을 향상시킬 수 있는 그룹웨어를 구현하는 것입니다.
------------

## 설계의 주안점
- 기존의 직접 기부형태와는 달리 개인의 문화 활동 후 리뷰를 작성하면 기부금액으로 집계되도록 하여 개인의 문화활동과 동시에 문화산업에도 선한 영향력을 미칠 수 있도록 하는 데에 주안점을 두었다.

------------
## 사용기술 및 개발환경
![화면 캡처 2021-06-17 203027](https://user-images.githubusercontent.com/77327044/122388508-e814cf80-cfaa-11eb-93e9-02763c73c58e.png)

Category | Detail
---- | ----
Laguage & Library | HTML5, JS, CSS, Java, JSP, jQuery, Ajax
API | OpenWeatherMap, FullCalendar, SummerNote
IDE | Eclpise
Server | Tomcat(v8.5)
Document | draw.io, ERDCloud, Figma
CI | Github
DataBase | Oracle 11g
FramWork | Spring, Bootstrap

------------
## 프로젝트 기능 구현


- 공통
    - 프로젝트 주제 선정 및 기획 
    - 플로우차트, 유스케이스 다이어그램 설계
    - DB & 클래스, 시퀸스 다이어그램 설계
    - 메인 페이지, 마이페이지, 회원가입, 관리자 페이지
    - 프로젝트 문서 작업
<br><br>

- 김동준
  - 조장
    - 프로젝트 문서 총괄
    <br>  
  - 영화 페이지
   - <감상혜윰>
     - 영화 정보 조회 및 영화 후기 게시판(CRUD), 
     - 관리자 영화 컨텐츠 관리 (CRUD)
   - <추천혜윰>
     - 영화 추천 게시판(CRUD), 검색 기능, 페이징 처리, 좋아요 가감 및 조회수 증가
     <br>
  - 마이 페이지
     - 마이 페이지 메인(CSS) 구현
     - 로그인 및 회원 가입 (다음 주소 API , 유효성 검사 적용) , 회원 정보 수정

<br><br>

- 이혜성
  - 도서 페이지
   - <감상혜윰>
     - 도서 정보 조회 및 도서 후기 게시판(CRUD) , 페이징 처리, 댓글 등록 / 삭제, 좋아요 가감 및 조회수 증가 
     - 관리자 도서 컨텐츠 관리 (CRUD)
   - <나눔혜윰>
     - 중고 도서 게시판(CRUD) , 페이징 처리, 파일 등록, 댓글 등록 / 삭제, 좋아요 가감 및 조회수 증가
     <br>
  - 마이 페이지
    - 작성 게시글 / 댓글 모아보기 

 <br><br>
   
- 조혜리
  - 메인 페이지
     - index 페이지 총괄
  - 공연 페이지
   - <언제혜윰>
     - 공연 정보 조회 (카카오맵 API 적용), 페이징 처리
     - 관리자 공연 컨텐츠 관리 (CRUD)
   - <관람혜윰>
     - 공연 후기 게시판(CRUD), 페이징 처리, 검색 기능, 파일 등록, 댓글 등록 / 수정 / 삭제, 좋아요 가감 및 조회수 증가
     <br>
  - 마당 페이지
   - <참여혜윰>
     - 결제 기능(카카오페이 API 적용)
     <br>
  - 마이 페이지
    - 사용자 비밀번호 변경 기능
    <br>
  - 관리자 페이지
    - 회원 관리(조회)
    - 주문 관리(상태 변경)

<br><br>  
   
- 한정서
  - 근태관리
     - 근무일 수 조회, 부여 연차(근무일 수 마다 차등부여) 조회
     - 연차(연차, 오후 ,오전, 경조사) 자동 신청/등록, 연차 취소(당일까지 가능), 
     <br>
  - 일정관리
   - <캘린더>
     - fullCalendar 사용
     - 개인 일정 등록(메모, 색상 선택), 수정 ,삭제
   - <할 일>
     - 할 일 등록 (중요도 선택), 수정(+완료) , 삭제
     <br>
  - 동호회 게시판
      - SummerNote 사용
      - 게시글 등록, 수정, 삭제
      - 댓글 수정, 삭제, 등록 , 대댓글 작성
     <br>
  - 투표
      - 투표등록(결과공개/비공개, 익명/실명, 투표기간, 투표대상 선택), 투표 삭제
      - 투표 결과 조회( bar 차트)
  
<br><br>

------------
## 주요 기능
[기획보고서_그룹이룸_텔레토비_최종.pdf](https://github.com/Team-Teletubby/GroupEroom/files/6669828/_._._.pdf)


------------ 
## Document

### 1. ERD
![화면 캡처 2021-06-17 203626](https://user-images.githubusercontent.com/77327044/122389253-b6e8cf00-cfab-11eb-9224-658ec13c6fec.png)


------------ 
## 시연 영상




