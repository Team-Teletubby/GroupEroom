package com.eroom.gw.mail.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eroom.gw.mail.domain.Mail;
import com.eroom.gw.mail.service.MailService;

@Controller
public class MailController {

	@Autowired
	private MailService mService;
	
	//보낸 
	@RequestMapping(value="sndList.do", method=RequestMethod.GET)
	public String sndListAll(HttpServletRequest request, HttpSession session, Model model) {
		return "";
		
		
	}
	
	//받은 
	@RequestMapping(value="revList.do", method=RequestMethod.GET)
	public String rcvListAll(HttpServletRequest request, HttpSession session, Model model) { 
		return ""; 
		
	}
	// 받은메일조회
	@ResponseBody
	@RequestMapping(value="rcvMailListSearch.do", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> rcvMailListSearch(@RequestBody Mail params, HttpServletRequest request, HttpSession session ){
		
		return null ;
	}
	// 보낸메일 조회
	@ResponseBody
	@RequestMapping(value= "sndMailListSearch.do", method ={RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> sndMailListSearch(@RequestBody Mail params, HttpServletRequest request, HttpSession session) { 
			
		return null;
		
	}
	
	// 읽음
	@ResponseBody
	@RequestMapping(value="mailRead.do", method=RequestMethod.POST)
	public Mail mailRead(@RequestBody Map<String, Object> param) { 
		
		
		return null;
	}
	// 삭제 
	@ResponseBody
	@RequestMapping(value="mailRemove.do", method=RequestMethod.POST)
	public ResponseEntity<String> remove(@RequestBody Map<String, Object> param) { 
		
		return null;
	}
	//받은 편지 
		@RequestMapping(value="mailRegister.do", method =RequestMethod.GET)
		public void registGET() throws Exception {
			
			
		}
	// 보내기
		@RequestMapping(value="mailRegister.do", method=RequestMethod.POST)
		public String registPOST(Mail mail, HttpServletRequest request, MultipartFile file, HttpSession session, RedirectAttributes rttr) { 
			
			return "";
		}
		
	}

