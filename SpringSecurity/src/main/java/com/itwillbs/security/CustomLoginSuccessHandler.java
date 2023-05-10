package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

// 시큐리티 기본설정이 아닌 추가적인 동작 구현을 위한 객체
// 인증이 성공 했을때 처리
public class CustomLoginSuccessHandler 
			implements AuthenticationSuccessHandler{
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("onAuthenticationSuccess() 호출 ");
		
		// 인증권한 정보를 저장하는 리스트
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority ->{
			roleNames.add(authority.getAuthority());
		});
		
		logger.info(roleNames+"");
		
		// 권한에 따른 페이지 이동
		// admin,member,vip
		
		if(roleNames.contains("ROLE_ADMIN")) {
			// 추가적인 별도의 구현사항(세션,쿠키 저장)
			// 관리자 권한이 있을때 관리자 페이지로 이동
			response.sendRedirect("/admin");
			return;
		}
		
		if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/member");
			return;
		}
		
		// 권한없는 사용자
		response.sendRedirect("/all");
		
	}
	
	
	
	
}
