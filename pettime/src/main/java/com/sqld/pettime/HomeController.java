package com.sqld.pettime;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqld.pettime.util.DBSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// MyBatis
	private SqlSession sqlSession;
	private PasswordEncoder passwordEncoder;	

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		DBSession.passwordEncoder =passwordEncoder;
	}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		DBSession.sqlSession = sqlSession;
	}	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(HttpServletRequest requsest , HttpServletResponse response) {
		
		try {
			response.sendRedirect(requsest.getContextPath()+"/pettime/resources/vue/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("jusoPopup")
	String jusoPop() {
		return "/user/jusoPopup";
	}
	
	
	
}
