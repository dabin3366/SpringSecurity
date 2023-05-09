package com.itwillbs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

// 시큐리티 기본설정이 아닌 추가적인 동작 구현을 위한 객체
// 인증이 성공 했을때 처리
public class AuthenticationSuccessHandler 
			implements org.springframework.security.web.authentication.AuthenticationSuccessHandler{

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
	}
	
	
	
	
}
