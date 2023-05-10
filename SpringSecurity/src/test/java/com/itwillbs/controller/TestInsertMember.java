package com.itwillbs.controller;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/*-context.xml"}
		)
public class TestInsertMember {
	private static final Logger logger = LoggerFactory.getLogger(TestInsertMember.class);
	
	@Autowired
	private DataSource ds;
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Test
	public void 암호화테스트() throws Exception{
		String oldPW = "1234";
		String newPW = pwEncoder.encode(oldPW);
		
		logger.info("원본 데이터 : " + oldPW);
		logger.info("암호화 데이터 : " + newPW);
		logger.info("결과 : "+pwEncoder.matches(oldPW, newPW));
	}
	
	
	
}
