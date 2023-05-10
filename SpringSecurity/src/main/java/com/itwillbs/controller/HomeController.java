package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	// http://localhost:8080/all
	@GetMapping("/all")
	public String doALL() {
		logger.info("로그인 x, 접근하는 일반 유저");
		return "ALL";
	}
	// http://localhost:8080/member
	@GetMapping("/member")
	public String doMember() {
		logger.info("로그인 처리후 화면");
		return "Member";
	}
	// http://localhost:8080/admin
	@GetMapping("/admin")
	public String doAdmin() {
		logger.info("관리자 로그인 처리후 하면");
		return "Admin";
	}
	
	@GetMapping("/accessErr")
	public void myAccessDenied(Authentication auth,Model model) {
		logger.info("myAccessDenied() 호출");
		
		model.addAttribute("auth",auth);
	}
	
	@GetMapping("/myLogin")
	public void myLogin(String error, String logout, Model model) {
		logger.info("myLogin() 호출 ");
		logger.info("error : "+error);
		logger.info("logout : "+logout);
		
		model.addAttribute("error","로그인 에러(계정문제)");
		model.addAttribute("logout", "사용자 로그아웃!!!");
		
	}
	@GetMapping("/customLogout")
	public void myLogout() throws Exception{
		logger.info("myLogout() 호출!");
	}
	
	
	
	
	
	
	
}
