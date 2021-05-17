package com.eroom.gw.fboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;
import com.eroom.gw.fboard.service.FBoardService;

@Controller
public class FBoardController {
	
	@Autowired
	private FBoardService fService;
	
//게시글리스트 조회
	public ModelAndView fBoardListView(ModelAndView mv,
									@RequestParam(value="page", required=false) Integer page) {	
		return mv;
	}
	
//게시글 상세조회
	public ModelAndView fBoardDetail(ModelAndView mv,
									@RequestParam("fBoardNo") int fBoardNo) {
		return mv;
	}
	
//게시글 등록화면단
	public String fBoardWriteView() {
		return "fBoard/boardWriteForm";
	}
	
//게시글 등록
	public ModelAndView fBoardRegister(ModelAndView mv,
									@ModelAttribute Freeboard fBoard, @ModelAttribute FreeboardFile fBoardFile,
									@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, 
									HttpServletRequest request) {
		return mv;
	}

//파일첨부
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		return "";
	}
	
//게시글 수정화면단
	public ModelAndView boardModifyView(ModelAndView mv, @RequestParam("fBoardNo") int fBoardNo) {
		return mv;
	}
	
//게시글 수정
	public ModelAndView fBoardUpdate(ModelAndView mv, HttpServletRequest request,
									@ModelAttribute Freeboard fBoard, @ModelAttribute FreeboardFile fBoardFile,
									@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		return mv;
	}
	
//게시글 삭제
	public String fBoardDelete(Model model, @RequestParam("fBoardNo") int fBoardNo,
								@RequestParam("renameFilename") String renameFileName,
								HttpServletRequest request) {
		return "";
	}
	
//파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
//댓글리스트
	public void getFBoardCmtList(HttpServletResponse response, @RequestParam("fBoardNo") int fBoardNo) {
		
	}
	
//댓글리스트
	public String addfBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt, HttpSession session) {
		return "";
	}
	
	public String removefBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt) {
	return "";
	}
	
	
	
	
}
