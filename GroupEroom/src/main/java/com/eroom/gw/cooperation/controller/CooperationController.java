package com.eroom.gw.cooperation.controller;

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

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.service.CooperationService;

@Controller
public class CooperationController {

	@Autowired
	private CooperationService coService;
	
//게시글리스트 조회
	@RequestMapping(value="coList.do")
	public ModelAndView cooperationListView(ModelAndView mv) {	
		return mv;
	}
	
//게시글 등록
	@RequestMapping(value="coRegister.do", method=RequestMethod.POST)
	public ModelAndView cooperationRegister(ModelAndView mv,
									@ModelAttribute Cooperation co,
									@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, 
									HttpServletRequest request) {
		return mv;
	}

//파일첨부
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		return "";
	}
	
//게시글 수정화면단
	@RequestMapping(value="coModifyView.do")
	public ModelAndView cooperationModifyView(ModelAndView mv, @RequestParam("coNo") int coNo) {
		return mv;
	}
	
//게시글 수정
	@RequestMapping(value="coUpdate.do", method=RequestMethod.POST)
	public ModelAndView cooperationUpdate(ModelAndView mv, HttpServletRequest request,
									@ModelAttribute Cooperation co,
									@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		return mv;
	}
	
//게시글 삭제
	@RequestMapping(value="coDelete.do")
	public String cooperationDelete(Model model, @RequestParam("coNo") int coNo,
								@RequestParam("renameFilename") String renameFileName,
								HttpServletRequest request) {
		return "";
	}
	
//파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
//댓글리스트
	@RequestMapping(value="coCmtList.do")
	public void getCooperationCmtList(HttpServletResponse response, @RequestParam("coNo") int coNo) {
		
	}
	
//댓글리스트
	@ResponseBody
	@RequestMapping(value="addCoCmt.do", method=RequestMethod.POST)
	public String addCooperationCmt(@ModelAttribute CooperationCmt coCmt, HttpSession session) {
		return "";
	}
	
//댓글수정
	@ResponseBody
	@RequestMapping(value="modifyCoCmt.do", method=RequestMethod.POST)
	public String modifyCooperationCmt(@ModelAttribute CooperationCmt coCmt) {
		return null;
	}

//댓글삭제
	@ResponseBody
	@RequestMapping(value="deleteCoCmt.do")
	public String removeCooperationCmt(@ModelAttribute CooperationCmt coCmt) {
	return "";
	}
	
	
	
}
