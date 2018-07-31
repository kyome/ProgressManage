package com.pmo.tsis.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pmo.tsis.domain.UserVO;
import com.pmo.tsis.dto.LoginDTO;
import com.pmo.tsis.service.UserService;

@Controller
public class UserController {

	@Inject
	private UserService service;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto, HttpSession session){
		session.removeAttribute("loginMsg");
	}

	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
		UserVO vo = service.login(dto);
		
		if(vo == null){
			session.setAttribute("loginMsg", "잘못입력되었습니다.");
			session.setAttribute("failId", dto.getMember_id());
			return;
		}else {
			model.addAttribute("userVO", vo);
			session.removeAttribute("loginMsg");
			session.removeAttribute("failId");
			
		}
	}
	
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		
		session.invalidate();
		return "index";
		
	}
}
