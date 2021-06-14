package com.eroom.gw.fboard.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.common.Search;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;
import com.eroom.gw.fboard.service.FBoardService;
import com.eroom.gw.member.domain.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

@Controller
public class FBoardController {
	
	@Autowired
	private FBoardService fService;
	
//검색
	@RequestMapping(value="fBoardSearch.do")
	public String fBoardSearch(@ModelAttribute Search search, 
								Model model, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int listCount = fService.getFbSearchListCount(search);
		PageInfo pi = Pagination.getPageInfo(currentPage,  listCount);
		ArrayList<Freeboard> fSearchList = fService.printFbSearchAll(search, pi);
		if(!fSearchList.isEmpty()) {
			model.addAttribute("fBoardList", fSearchList);
			model.addAttribute("pi",pi);
			model.addAttribute("search", search);
			return "fBoard/fBoardSearchList";
		}else {
			model.addAttribute("msg", "검색실패!");
			return "common/errorPage";
		}
	}
	
	
//게시글리스트 조회
	@RequestMapping(value="fBoardListView.do")
	public ModelAndView fBoardListView(ModelAndView mv,
									@RequestParam(value="page", required=false) Integer page) {	
		int currentPage = (page != null) ? page : 1;
		int listCount = fService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage,  listCount);
		
		ArrayList<Freeboard> fList = fService.printAll(pi);
		if(!fList.isEmpty()) {
			mv.addObject("fList", fList);
			mv.addObject("pi", pi);
			mv.setViewName("fBoard/fBoardListView");
		}else {
			mv.addObject("msg", "리스트 불러오기 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
//게시글 상세조회
	@RequestMapping(value="fBoardDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView fBoardDetail(ModelAndView mv,
									@RequestParam("fBoardNo") int fBoardNo) {
		//조회수 증가
		fService.addHits(fBoardNo);
		//파일리스트 불러오기
		List<FreeboardFile> fileList = fService.printFile(fBoardNo);
		
		//상세조회 불러오기
		Freeboard fBoard = fService.printOne(fBoardNo);
		if(fBoard != null) {
			mv.addObject("fBoardFile", fileList);
			mv.addObject("fBoard", fBoard);
			mv.setViewName("fBoard/fBoardDetailView");
		}else {
			mv.addObject("msg", "게시글 상세 조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
//게시글 등록화면단
	@RequestMapping(value="fBoardWriteView.do")
	public String fBoardWriteView() {
		return "fBoard/fBoardWriteForm";
	}
	
//게시글 등록
	@RequestMapping(value="fBoardRegister.do", method=RequestMethod.POST)
	public ModelAndView fBoardRegister(ModelAndView mv,
									@ModelAttribute Freeboard fBoard,
									HttpServletRequest request, HttpSession session, MultipartHttpServletRequest mhsq) throws IllegalStateException, IOException{
		session = request.getSession();
		Member loginUser = (Member)session.getAttribute("LoginUser");
		fBoard.setMemberId(loginUser.getMemberId());
		
		int result = 0;
		String path = "";
		result = fService.registerFBoard(fBoard);
		if(result > 0) {
			path = "redirect:fBoardListView.do";
		}else {
			mv.addObject("msg", "게시글 등록 실패");
			path = "common/errorPage";
		}
		
		//파일 저장경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/fUploadFiles";
		//저장폴더 선택
		File folder = new File(savePath);
		//폴더가 없으면 자동 생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("uploadFile");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
			
		} else {
			for (int i=0 ; i < mf.size() ; i++) {
				//파일 중복명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				//원파일명
				String originalFileName = mf.get(i).getOriginalFilename();
				//파일명 재설정
				String renameFileName = sdf.format(new Date(System.currentTimeMillis())) 
										+ "." + originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				//파일경로,사이즈
				String filePath = folder + "/" + renameFileName;
				long fileSize = mf.get(i).getSize();
				//파일저장
				mf.get(i).transferTo(new File(filePath));
				fService.fileUpload(originalFileName, renameFileName, filePath, fileSize);
			}
		}
		
		mv.setViewName(path);
		return mv;
	}

//게시글 수정화면단
	@RequestMapping(value="fBoardModifyView.do")
	public ModelAndView fBoardModifyView(ModelAndView mv, @RequestParam("fBoardNo") int fBoardNo) {
		Freeboard fBoard = fService.printOne(fBoardNo);
		if(fBoard != null) {
			mv.addObject("fBoard", fBoard).setViewName("fBoard/fBoardUpdateView");
		}else {
			mv.addObject("msg", "게시글 상세조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
//게시글 수정
	@RequestMapping(value="fBoardUpdate.do", method=RequestMethod.POST)
	public ModelAndView fBoardUpdate(ModelAndView mv, HttpServletRequest request,
									@ModelAttribute Freeboard fBoard, @ModelAttribute FreeboardFile Files,
//									@RequestParam(value="reloadFile", required=false) MultipartfFile reloadFile,
									MultipartHttpServletRequest mhsq) {
		//DB수정
		int result = fService.modifyFBoard(fBoard);
		if(result > 0) {
			mv.setViewName("redirect:fBoardListView.do");
		}else {
			mv.addObject("msg", "게시글 수정 실패").setViewName("common/errorPage");
		}
		//파일수정
		
		
		
		return mv;
	}
	
//게시글 삭제
	@RequestMapping(value="fBoardDelete.do")
	public String fBoardDelete(Model model, @RequestParam("fBoardNo") int fBoardNo, @RequestParam("fileNo") int fileNo,
								HttpServletRequest request, HttpSession session, MultipartHttpServletRequest mhsq) {
		
		int result = fService.removeFBoard(fBoardNo);
		if(result > 0) {
			return "redirect:fBoardListView.do";
		}else {
			model.addAttribute("msg", "게시글 삭제 실패");
			return "common/errorPage";
		}
	}
	
//파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
//댓글리스트
	@RequestMapping(value="fbCmtList.do")
	public void getFBoardCmtList(HttpServletResponse response, @RequestParam("fBoardNo") int fBoardNo) throws JsonIOException, IOException {
		ArrayList<FreeboardCmt> cmtList = fService.printAllCmt(fBoardNo);
		if(!cmtList.isEmpty()) {
			//gson형태로 빌드
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			//arraylist를 gson형태로 변환
			gson.toJson(cmtList, response.getWriter());
		}else {
			System.out.println("등록된 댓글이 없습니다");
		}
	}
	
//댓글등록
	@ResponseBody
	@RequestMapping(value="fbCmtAdd.do", method=RequestMethod.POST)
	public String addFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("LoginUser");
		fBoardCmt.setMemberId(loginUser.getMemberId());
		int result = fService.registerFBoardCmt(fBoardCmt);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
//댓글수정
	@ResponseBody
	@RequestMapping(value="fbCmtModify.do", method=RequestMethod.POST)
	public String modifyFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt) {
		int result = fService.modifyFBoardCmt(fBoardCmt);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
//댓글삭제
	@ResponseBody
	@RequestMapping(value="fbCmtDelete.do")
	public String removeFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt) {
		int result = fService.removeFBoardCmt(fBoardCmt);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	
	
	
}
