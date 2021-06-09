package com.eroom.gw.cooperation.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.domain.CooperationRoom;
import com.eroom.gw.cooperation.service.CooperationService;
@RestController
@Controller
public class CooperationController {

	@Autowired
	private CooperationService coService;
	
	@RequestMapping(value="coopListView.do")
	public ModelAndView coopListView(ModelAndView mv) {	
		ArrayList<CooperationRoom> coList = coService.printAll();
		if(!coList.isEmpty()) {
			mv.addObject("coList", coList);
			mv.setViewName("cooperation/coopRoomList");
		}else {
			mv.addObject("msg", "리스트 조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
//게시글 등록
	@RequestMapping(value="coRegister.do", method=RequestMethod.POST)
	public ModelAndView coopRegister(ModelAndView mv,
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
	public ModelAndView coopModifyView(ModelAndView mv, @RequestParam("coNo") int coNo) {
		return mv;
	}
	
//게시글 수정
	@RequestMapping(value="coUpdate.do", method=RequestMethod.POST)
	public ModelAndView coopUpdate(ModelAndView mv, HttpServletRequest request,
									@ModelAttribute Cooperation co,
									@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		return mv;
	}
	
//게시글 삭제
	@RequestMapping(value="coDelete.do")
	public String coopDelete(Model model, @RequestParam("coNo") int coNo,
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
	public String addCooperationCmt(@ModelAttribute CooperationCmt cmt, HttpSession session) {
		return "";
	}
	
//댓글수정
	@ResponseBody
	@RequestMapping(value="modifyCoCmt.do", method=RequestMethod.POST)
	public String modifyCoopCmt(@ModelAttribute CooperationCmt cmt) {
		return null;
	}

//댓글삭제
	@ResponseBody
	@RequestMapping(value="deleteCoCmt.do")
	public String removeCoopCmt(@ModelAttribute CooperationCmt cmt) {
	return "";
	}
	
	
	
}
