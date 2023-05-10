package com.itwillbs.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

// 비밀번호 암호화 처리없이 바로 진행 가능하도록 하는 객체
public class CustomNoopPasswordEncoder implements PasswordEncoder{

	private static final Logger logger = LoggerFactory.getLogger(CustomNoopPasswordEncoder.class);
	
	@Override
	public String encode(CharSequence rawPassword) {
		logger.info("encode() 실행 ");
		// 인코딩 작업
		
		return rawPassword.toString();
	}
	
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		logger.info("matches() 실행 ");
		
		return rawPassword.toString().equals(encodedPassword);
	}
}
