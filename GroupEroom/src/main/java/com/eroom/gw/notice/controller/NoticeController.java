package com.eroom.gw.notice.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.common.Search;
import com.eroom.gw.notice.domain.Notice;

import com.eroom.gw.notice.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	@Autowired
	private NoticeService nService;
	// 리스트 화면
	
	@GetMapping(value="noticeListView.do")
	public ModelAndView noticeListView(ModelAndView mv, @RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page != null) ? page : 1;
		int listCount = nService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Notice> nList = nService.printAll(pi);
		if(!nList.isEmpty()) {
			mv.addObject("noticeList", nList);
			mv.addObject("pi", pi);
			mv.setViewName("notice/noticeListView");
		}else {
			mv.addObject("msg", "공지사항 조회 실패");
			mv.setViewName("common/errorPage");
		}
		
		
		return mv;
	}
	// 공지사항 검색
	@GetMapping(value="noticeSearch.do")
	public String noticeSearch(@ModelAttribute Search search, Model model, @RequestParam(value="page", required=false)Integer page ) {
		int currentPage = (page !=null) ? page : 1;
		int listCount = nService.getSearchListCount(search);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Notice> searchList = nService.printSearchAll(search,pi);
		if(!searchList.isEmpty()) {
			model.addAttribute("noticeList",searchList);
			model.addAttribute("pi", pi);
			model.addAttribute("search",search);
			return "notice/noticeSearchList";
		}else {
			model.addAttribute("msg", "검색 실패");
			return "common/errorPage";
		}
		}
		
	
	
	
	// 공지사항 등록화면
	
	@GetMapping(value="noticeWriteView.do")
	public String noticeWriteView() {
		return "notice/noticeWriteForm";
	}
	
	// 공지사항 등록 로직
	@PostMapping(value="noticeRegister.do")
	public ModelAndView noticeRegister(ModelAndView mv, @ModelAttribute Notice notice, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, HttpServletRequest request) { 
		//서버에 파일 저장
				if(!uploadFile.getOriginalFilename().equals("")) {
					String renameFileName = saveFile(uploadFile, request);
					if(renameFileName !=null) {
						notice.setOriginalFileName(uploadFile.getOriginalFilename());
						notice.setRenameFileName(renameFileName);
					}
				}
				//디비에 파일 저장
				int result = nService.registerNotice(notice);
				String path = "";
				if(result>0) {
					path = "redirect:noticeListView.do";
				}else {
					mv.addObject("msg", "공지등록을 실패하셨습니다!!");
					path = "common/errorPage";
				}
				mv.setViewName(path);
				return mv;
			}

			private String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
				// 파일 저장 경로 설정
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\noticeFiles";
				
				
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
				//리턴 꼮!!!!!!!!!!!!!!!!!!!!!!!하기!!!!!!!!
				return renameFileName;
			}
	// 공지사항 상세페이지 + 조회수 증가 
			@GetMapping(value="noticeDetail.do")
		public ModelAndView noticeDetailView(ModelAndView mv, @RequestParam("noticeNo")int noticeNo) {
			Notice notice = nService.printOne(noticeNo);
			if (notice !=null) { 
				nService.addReadCount(noticeNo);
				mv.addObject("notice",notice);
				mv.setViewName("notice/noticeDetailView");
			}else {
				mv.addObject("msg" , "상세 조회 실패");
				mv.setViewName("common/errorPage");
				
			}
			return mv;
			}
	
		
	
	
	// 공지사항 수정화면
	@GetMapping(value="noticeModifyView.do")
	public String noticeModifyView(@RequestParam("noticeNo")int noticeNo, Model model) {
		
		log.info("noticeNo = {}", noticeNo);
		
		Notice notice = nService.printOne(noticeNo);
		if (notice != null)  { 
			model.addAttribute("notice", notice);
			return "notice/noticeModifyView";
		}else { 
			return "common/errorPage";
		}
	
		
	}
	// 수정
	@PostMapping(value="noticeModify.do")
	public ModelAndView noticeModify(ModelAndView mv, HttpServletRequest request, @ModelAttribute Notice notice , @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) { 
		//파일 삭제 후 업로드 (수정)
		if(reloadFile != null && !reloadFile.isEmpty()) {
			if(notice.getOriginalFileName() !="") {
				deleteFile(notice.getRenameFileName(), request);
			}
			
			//새 파일 업로드
			String renameFileName = saveFile(reloadFile, request);
			if(renameFileName !=null) {
				notice.setOriginalFileName(reloadFile.getOriginalFilename());
				notice.setRenameFileName(renameFileName);
			}
		}
		//디비 수정
		int result = nService.modifyNotice(notice);
		if(result>0) {
			mv.setViewName("redirect:noticeListView.do");
		}else {
			mv.addObject("msg","공지사항 수정 실패").setViewName("common/errorPage");
		}
		return mv;
		
	}

		
		
		
	
	//공지사항 삭제 (실제는 업데이트)
	
	@GetMapping(value="noticeDelete.do")
	public String noticeDelete(Model model, @RequestParam("noticeNo") int noticeNo, @RequestParam("renameFilename") String renameFilename, HttpServletRequest request) { 
		 return "";
	}
	// 파일삭제 
	public void deleteFile(String fileName, HttpServletRequest request) { 
		
	}
}