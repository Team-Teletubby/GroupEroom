package com.eroom.gw.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD

@Controller
public class MemberController {
=======
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git

<<<<<<< HEAD

=======
@Controller
public class MemberController {
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String mainPageView() {
		
		return "index";
		
	}
>>>>>>> branch 'master' of https://github.com/Team-Teletubby/GroupEroom.git
	
}
