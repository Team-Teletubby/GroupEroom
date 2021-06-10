package com.eroom.gw.cooperation.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.domain.CooperationRoom;
import com.eroom.gw.cooperation.service.CooperationService;
import com.eroom.gw.member.domain.Member;
@RestController
@Controller
public class CooperationController {

	@Autowired
	private CooperationService coService;
	
//방 리스트 출력
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

//방 상세화면
	@RequestMapping(value="coopDetailView.do")
	public ModelAndView coopListByRoom(ModelAndView mv, @RequestParam("roomNo") int roomNo) {
		ArrayList<Cooperation> coopList = coService.printAllByRoom(roomNo);
		if(!coopList.isEmpty()) {
			mv.addObject("coopList", coopList);
			mv.addObject("roomNo",roomNo);
			mv.setViewName("cooperation/coopDetailView");
		}else {
			mv.addObject("msg", "리스트불러오기 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
//게시글등록
	@RequestMapping(value="coopRegister.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView coopRegister(ModelAndView mv, @ModelAttribute Cooperation coop,
									@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
									@RequestParam("roomNo") int roomNo,
									HttpServletRequest request, HttpSession session) {
		//로그인한 아이디 가지고 옴
		session = request.getSession();
		Member loginUser = (Member)session.getAttribute("LoginUser");
		coop.setMemberId(loginUser.getMemberId());
		coop.setRoomNo(roomNo);
		//데이터를 서버에 저장함
		if(!uploadFile.getOriginalFilename().equals("")) {
			String renameFilename = saveFile(uploadFile, request);
			if(renameFilename != null) {
				coop.setOriginalFilename(uploadFile.getOriginalFilename());
				coop.setRenameFilename(renameFilename);
			}
		}
		//데이터를 DB에 저장함
		int result = 0;
		String path = "";
		result = coService.registerCoop(coop);
		if(result > 0) {
			path = "redirect:coopDetailView.do?roomNo="+roomNo;
		}else {
			mv.addObject("msg", "게시글 등록 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}
//파일저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		//파일 저장경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/coUploadFiles";
		//저장폴더 선택
		File folder = new File(savePath);
		//폴더 없으면 자동 생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		//파일명 중복 시 파일명 변경(rename)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFilename = file.getOriginalFilename();
		String renameFilename = sdf.format(new Date(System.currentTimeMillis())) 
				+ "." + originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		String filePath = folder + "/" + renameFilename;
		//파일 저장
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//리턴
		return renameFilename;
	}
	
//글삭제
	@RequestMapping(value="coopDelete.do")
	public ModelAndView coopDelete(ModelAndView mv, @ModelAttribute Cooperation co,
							@RequestParam(value="roomNo") int roomNo, @RequestParam("coNo") int coNo, 
							@RequestParam(value="renameFilaname", required=false) String renameFilename,
							HttpServletRequest request) {
		
		co.setRoomNo(roomNo);
		co.setCoNo(coNo);
		
		// 파일삭제
		if(renameFilename != null) {
			deleteFile(renameFilename, request);
		}
		// DB글삭제
		int result = coService.removeCoop(coNo);
		String path = "";
		if(result > 0) {
			path = "redirect:coopDetailView.do?roomNo="+roomNo;
		}else {
			mv.addObject("msg","게시글 삭제 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}
//파일삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/buploadFiles";
		File file = new File(savePath + "/" + fileName);
		//파일의 존재여부 확인 후 삭제
		if(file.exists()) {
			file.delete();
		}
	}
			

	
	
	
}
