package com.eroom.gw.fboard.controller;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;
import com.eroom.gw.fboard.service.FBoardService;
import com.eroom.gw.member.domain.Member;

@Controller
public class FBoardController {
	
	@Autowired
	private FBoardService fService;
	
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
			System.out.println("실패");
			mv.addObject("msg", "리스트 불러오기 실패");
			mv.setViewName("fBoard/errorPage");
		}
		return mv;
	}
	
//게시글 상세조회
	@RequestMapping(value="fBoardDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView fBoardDetail(ModelAndView mv,
									@RequestParam("fBoardNo") int fBoardNo) {
		//조회수 증가
		fService.addHits(fBoardNo);
		
		//상세조회 불러오기
		Freeboard fBoard = fService.printOne(fBoardNo);
		if(fBoard != null) {
			mv.addObject("fBoard", fBoard).setViewName("fBoard/fBoardDetailView");
		}else {
			mv.addObject("msg", "게시글 상세 조회 실패");
			mv.setViewName("fBoard/errorPage");
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
		Member loginUser = (Member)session.getAttribute("loginUser");
		fBoard.setMemberId(loginUser.getMemberId());
		
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
										+ "." + originalFileName.substring(originalFileName.lastIndexOf("."), 1);
				//파일경로,사이즈
				String filePath = folder + "/" + renameFileName;
				long fileSize = mf.get(i).getSize();
				//파일저장
				mf.get(i).transferTo(new File(filePath));
				fService.fileUpload(originalFileName, renameFileName, filePath, fileSize);
			}
		}
		
		int result = 0;
		String path = "";
		result = fService.registerFBoard(fBoard);
		if(result > 0) {
			path = "redirect:fBoardListView.do";
		}else {
			mv.addObject("msg", "게시글 등록 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}

////파일등록
//	@RequestMapping(value="multipartUpload.do", method = RequestMethod.POST)
//	public void saveFile (MultipartFile file, MultipartHttpServletRequest request) {
//		//파일 저장경로 설정
//		return null;
//	}
	
//게시글 수정화면단
	@RequestMapping(value="fBoardModifyView.do")
	public ModelAndView fBoardModifyView(ModelAndView mv, @RequestParam("fBoardNo") int fBoardNo) {
		Freeboard fBoard = fService.printOne(fBoardNo);
		if(fBoard != null) {
			mv.addObject("fBoard", fBoard).setViewName("fBoard/fBoardUpdateView");
		}else {
			mv.addObject("msg", "게시글 상세조회 실패").setViewName("fBoard/errorPage");
		}
		return mv;
	}
	
//게시글 수정
	@RequestMapping(value="fBoardUpdate.do", method=RequestMethod.POST)
	public ModelAndView fBoardUpdate(ModelAndView mv, HttpServletRequest request,
									@ModelAttribute Freeboard fBoard) {
		int result = fService.modifyFBoard(fBoard);
		if(result > 0) {
			mv.setViewName("redirect:fBoardListView.do");
		}else {
			mv.addObject("msg", "게시글 수정 실패").setViewName("fBoard/errorPage");
		}
		return mv;
	}
	
//게시글 삭제
	@RequestMapping(value="fBoardDelete.do")
	public String fBoardDelete(Model model, @RequestParam("fBoardNo") int fBoardNo,
								HttpServletRequest request) {
		
		int result = fService.removeFBoard(fBoardNo);
		if(result > 0) {
			return "redirect:fBoardListView.do";
		}else {
			model.addAttribute("msg", "게시글 삭제 실패");
			return "fBoard/errorPage";
		}
	}
	
//파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
//댓글리스트
	@RequestMapping(value="fbCmtList.do")
	public void getFBoardCmtList(HttpServletResponse response, @RequestParam("fBoardNo") int fBoardNo) {
		
	}
	
//댓글등록
	@RequestMapping(value="fbCmtAdd.do", method=RequestMethod.POST)
	public String addFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt, HttpSession session) {
		return "";
	}
	
//댓글수정
	@ResponseBody
	@RequestMapping(value="fbCmtModify.do", method=RequestMethod.POST)
	public String modifyFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt) {
		return null;
	}
	
//댓글삭제
	@ResponseBody
	@RequestMapping(value="fbCmtDelete.do", method=RequestMethod.POST)
	public String removeFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt) {
	return "";
	}
	
	
	
	
}
