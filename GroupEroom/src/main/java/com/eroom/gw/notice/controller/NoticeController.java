package com.eroom.gw.notice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.common.Search;
import com.eroom.gw.notice.domain.Notice;
import com.eroom.gw.notice.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService nService;
	// 리스트 화면
	@RequestMapping(value="noticeList.do", method=RequestMethod.GET)
	public ModelAndView noticeListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		return mv;
	}
	//상세 페이지, 조회수 화면
	@RequestMapping(value="noticeDetail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeDetail(ModelAndView mv, @RequestParam("noticeNo") int noticeNo) { 
		return mv;
	}
	// 공지사항 등록화면
	
	@RequestMapping(value="noticeWriteView.do", method=RequestMethod.GET)
	public String noticeWriteView() {
		return "";
	}
	
	// 공지사항 등록 로직
	@RequestMapping(value="noticeRegister.do", method=RequestMethod.POST)
	public ModelAndView noticeRegister(ModelAndView mv, @ModelAttribute Notice notice, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, HttpServletRequest request) { 
		return mv;
	}
	
	// 공지사항 파일첨부
	public String saveFile(MultipartFile file, HttpServletRequest request) { 
		
			// 파일저장은 예외처리 
		return "";
	}
	// 공지사항 수정화면
	@RequestMapping(value="noticeModifyView.do")
	public ModelAndView noticeModifyView(ModelAndView mv, @RequestParam("noticeNo") int noticeNo) { 
		return mv;
		
	}
	// 수정
	@RequestMapping(value="noticeUpdate.do", method=RequestMethod.POST)
	public ModelAndView noticeUpdate(ModelAndView mv, HttpServletRequest request, @ModelAttribute Notice notice , @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) { 
		return mv;
	}
	//공지사항 삭제 (실제는 업데이트)
	
	@RequestMapping(value="noticeDelete.do", method=RequestMethod.GET)
	public String noticeDelete(Model model, @RequestParam("noticeNo") int noticeNo, @RequestParam("renameFilename") String renameFilename, HttpServletRequest request) { 
		 return "";
	}
	// 파일삭제 
	public void deleteFile(String fileName, HttpServletRequest request) { 
		
	}
}