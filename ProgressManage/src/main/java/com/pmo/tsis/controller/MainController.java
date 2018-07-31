package com.pmo.tsis.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pmo.tsis.domain.UserVO;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(Locale locale, Model model) {
	}
	
	@RequestMapping(value = "/noticeBoard", method = RequestMethod.GET)
	public String noticeBoard() {
		return "noticeBoard";
	}
	
	@RequestMapping(value = "/progress", method = RequestMethod.GET)
	public String progress() {
		return "progress";
	}
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String schedule() {
		return "schedule";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(UserVO userVO, ModelMap model){
		model.addAttribute("userVO", userVO);
		return "member";
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage() {
		return "myPage";
	}
	
}
