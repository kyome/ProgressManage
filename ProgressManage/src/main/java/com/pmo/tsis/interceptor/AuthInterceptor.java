package com.pmo.tsis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//특정 경로에 접근하는 경우 현재 사용자가 로그인한 상태의 사용자인지를 체크하는 역할 처리
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	//현재 사용자가 로그인한 상태인지를 체크하고 컨트롤러를 호출하게 할 것인지 결정
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {	//로그인하지 않은 상태
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
}
