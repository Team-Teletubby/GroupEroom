package com.eroom.gw.cboard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Reply;
import com.eroom.gw.cboard.service.CBoardService;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.common.Search;
import com.eroom.gw.member.domain.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class CBoardController {
	
	@Autowired
	
	private CBoardService service;
	
	
	//전체 조회:)
	@RequestMapping(value="cBoardListView.do", method=RequestMethod.GET)
	public ModelAndView boardListView(ModelAndView mv
											, @RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page !=null) ? page : 1;
		int listCount = service.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<CBoard> list = service.printAll(pi);
		if(!list.isEmpty()) {
			mv.addObject("cBoardList",list);
			mv.addObject("pi", pi);
			mv.setViewName("cBoard/cBoardListView");
		}else {
			mv.addObject("msg", "게시글 전체조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//검색 :)
	@RequestMapping(value="cBoardSearch.do")
	public String boardSearch(@ModelAttribute Search search, Model model,@RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page !=null) ? page : 1;
		int listCount = service.getSearchListCount(search);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<CBoard> searchList = service.printSearchAll(search,pi);
		if(!searchList.isEmpty()) {
			model.addAttribute("cBoardList",searchList);
			model.addAttribute("pi", pi);
			model.addAttribute("search",search);
			return "cBoard/cBoardSearchListView";
		}else {
			model.addAttribute("msg", "검색 실패");
			return "common/errorPage";
		}
	}
	
	//작성폼 :)
	@RequestMapping(value="cBoardWriteView.do", method=RequestMethod.GET)
	public String boardWriteView() {
		return "cBoard/cBoardWriteView";
	}
	
	// 게시글 등록 :)
	@RequestMapping(value="cBoardRegister.do", method=RequestMethod.POST)
	public ModelAndView boardRegister(ModelAndView mv, 
			@ModelAttribute CBoard cBoard, 
			@RequestParam(value="uploadFile", required=false)MultipartFile uploadFile, 
			HttpServletRequest request) {
		
		//서버에 파일 저장
		if(!uploadFile.getOriginalFilename().equals("")) {
			String renameFileName = saveFile(uploadFile, request);
			if(renameFileName !=null) {
				cBoard.setOriginalFileName(uploadFile.getOriginalFilename());
				cBoard.setRenameFileName(renameFileName);
			}
		}
		
		//디비에 파일 저장
		int result = service.registerBoard(cBoard);
		String path = "";
		if(result>0) {
			path = "redirect:cBoardListView.do";
		}else {
			mv.addObject("msg", "게시글 등록 실패..");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}

	private String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\cBoardFiles";
		
		
		// 저장 폴더 설정
		File folder = new File(savePath);
		// 폴더 없으면 자동 생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		// 파일명 변경하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = uploadFile.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + 
											originalFileName.substring(originalFileName.lastIndexOf(".")+1); //거꾸로 위치,=>확장자명
		String filePath = folder + "\\" + renameFileName;
		// 파일저장
		try {
			uploadFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//리턴
		return renameFileName;
	}
	
	//게시글 상세 :)
	@RequestMapping(value="cBoardDetail.do", method=RequestMethod.GET)
	public ModelAndView boardDetailView(ModelAndView mv,@RequestParam("cBoardNo")int cBoardNo) {
		CBoard cBoard = service.printOne(cBoardNo);
		if(cBoard !=null) {
			service.addReadCount(cBoardNo);
			mv.addObject("cBoard",cBoard);
			mv.setViewName("cBoard/cBoardDetailView");
		}else {
			mv.addObject("msg", "상세조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 게시글 수정페이지 이동 :)
	@RequestMapping(value="cBoardModifyView.do", method=RequestMethod.GET)
	public String boardModifyView(@RequestParam("cBoardNo")int cBoardNo, Model model) {
		CBoard cBoard = service.printOne(cBoardNo);
		if(cBoard !=null) {
			model.addAttribute("cBoard", cBoard);
			return "cBoard/cBoardModifyView";
		}else {
			return "common/erroePage";
		}
	}
	
	// 게시글 수정
	@RequestMapping(value="cBoardModify.do", method=RequestMethod.POST)
	public ModelAndView boardModify(ModelAndView mv,
									HttpServletRequest request,
									@ModelAttribute CBoard cBoard,
									@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {

		//파일 삭제 후 업로드 (수정)
		if(reloadFile != null && !reloadFile.isEmpty()) {
			if(cBoard.getOriginalFileName() !="") {
				deleteFile(cBoard.getRenameFileName(), request);
			}
			
			//새 파일 업로드
			String renameFileName = saveFile(reloadFile, request);
			if(renameFileName !=null) {
				cBoard.setOriginalFileName(reloadFile.getOriginalFilename());
				cBoard.setRenameFileName(renameFileName);
			}
		}
		//디비 수정
		int result = service.modifyBoard(cBoard);
		if(result>0) {
			mv.setViewName("redirect:cBoardListView.do");
		}else {
			mv.addObject("msg","게시글 수정 실패").setViewName("common/errorPage");
		}
		return mv;
		
	}

	
	//게시글 삭제 :)
	@RequestMapping(value="cBoardDelete.do", method=RequestMethod.GET)
	public String boardDelete(Model model, 
					@RequestParam("cBoardNo") int cBoardNo,
					@RequestParam("renameFileName") String fileName,
					HttpServletRequest request) {
		
		//업로드된 파일 삭제
		if(fileName != null) {
			deleteFile(fileName, request);
		}	
		
		int result = service.removeBoard(cBoardNo);
		if(result>0) {
			return "redirect:cBoardListView.do";
		}else {
			model.addAttribute("msg","삭제실패");
			return "common/errorPgae";			
		}
	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\cBoardFiles";
		File file = new File(savePath + "\\" + fileName);
		if(file.exists()) {
			file.delete();
		}
	}
	

	//댓글zone..====================================
	

	//댓글목록 :)
	@RequestMapping(value="cBoardReply.do", method=RequestMethod.GET)
	public void getReplyList(HttpServletResponse response, @RequestParam("cBoardNo") int cBoardNo) throws Exception {
		System.out.println(cBoardNo);
		ArrayList<Reply> rList = service.printAllReply(cBoardNo);
		if(!rList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 날짜 포맷 변경!
			gson.toJson(rList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다.");
		}
	}
	//댓글등록 :)
	@ResponseBody
	@RequestMapping(value="cBoardAddReply.do", method=RequestMethod.POST)
	public String addReply(@ModelAttribute Reply reply, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("LoginUser");
		reply.setMemberId(loginUser.getMemberId());
		int result = service.registerReply(reply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	//댓글수정 :)
	@ResponseBody
	@RequestMapping(value="cBoardModifyReply.do", method=RequestMethod.POST)
	public String modifyReply(@ModelAttribute Reply reply) {
		int result = service.modifyReply(reply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	//댓글삭제 :)
	@ResponseBody
	@RequestMapping(value="cBoardDeleteReply.do", method=RequestMethod.GET)
	public String removeReply(@ModelAttribute Reply reply) {
		int result = service.removeReply(reply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
}
