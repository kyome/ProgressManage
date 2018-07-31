package com.pmo.tsis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//HandlerInterceptor는 기존의 컨트롤러에서는 순수하게 필요한 파라미터와 결과 데이터를 
//만들어 내고, 인터셉터를 이용해서 웹과 관련된 처리를 도와주는 역할
//LoginInterceptor의 설정은 '/loginPost'의 동작에서 이뤄져야 함
//로그인한 사용자에 대해서 postHandler()를 이용해서 HttpSession에 보관하는 처리
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	
	//userVO라는 이름으로 객체를 담아둔 상태, 이 상태를 체크해서 HttpSession에 저장
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();	
		// 세션에 보관된 객체는 JSP에서 EL을 이용해서 자동으로 추적하는 방식(page -> request -> session -> application)
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		
		if(userVO != null) {
			session.setAttribute(LOGIN, userVO);
			response.sendRedirect("/progress");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {	//기존 HttpSession에 남아 있는 정보가 있는 경우 삭제
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) != null) {
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}
}
