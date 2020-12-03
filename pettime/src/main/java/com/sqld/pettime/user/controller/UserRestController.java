package com.sqld.pettime.user.controller;




import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.user.beans.UserLoginJSON;
import com.sqld.pettime.user.command.UserNoticeSelectCommend;
import com.sqld.pettime.user.command.UserNoticeViewCommend;
import com.sqld.pettime.user.command.UserQnASearchCommend;
import com.sqld.pettime.user.command.UserQnASelectCommend;
import com.sqld.pettime.user.command.UserQnAViewCommend;




@RestController
@RequestMapping("/rest")
public class UserRestController {
	

	
	@RequestMapping(value="/csrf-token", method=RequestMethod.GET)
	public @ResponseBody String getCsrfToken(HttpServletRequest request) {
	    CsrfToken token = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
	    return token.getToken();
	}
	
	@RequestMapping("/notice/list/{pageNum}")
	UserDataJSON noticeSelect(Model model, @PathVariable int pageNum,HttpSession session) {
		model.addAttribute("pageNum", pageNum);
		new UserNoticeSelectCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/login")
	UserDataJSON loginInput(Model model) {
		System.out.println("로그인페이지");
		UserDataJSON ajax = new UserDataJSON();

		return ajax;
	}
	
	@RequestMapping("/isLogin")
	UserLoginJSON isLogin(Model model, Authentication authentication ) {
		System.out.println("로그인확인");
		UserLoginJSON json = new UserLoginJSON();
		json.setStatus("OK");
		json.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		json.setIslogin(true);
		return json;
	}
	
	@RequestMapping("/isNotLogin")
	UserLoginJSON isNotLogin(Model model, HttpSession session) {
		System.out.println("로그인실패");
		UserLoginJSON json = new UserLoginJSON();
		json.setStatus("OK");
		json.setUsername("Notlogin");
		json.setIslogin(false);
		json.setMessage((String)session.getAttribute("accessDeniedMessage"));
		return json;
	}
	
	@RequestMapping("/qna/list/{pageNum}")
	UserDataJSON qnaSelect(Model model, @PathVariable int pageNum ,HttpSession session) {
		model.addAttribute("pageNum", pageNum);
		new UserQnASelectCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");
	
		return ajax;
	}
	
	@RequestMapping("/qna/search/{val}/{pageNum}")
	UserDataJSON qnaSearch(Model model, @PathVariable String val,@PathVariable int pageNum ,HttpSession session) {
		model.addAttribute("val", val);
		System.out.println(val);
		model.addAttribute("pageNum", pageNum);
		System.out.println(pageNum);
		new UserQnASearchCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/notice/view/{uid}")
	UserDataJSON noticeView(Model model, @PathVariable int uid ,HttpSession session) {
		model.addAttribute("uid", uid);
		
		new UserNoticeViewCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/qna/view/{uid}")
	UserDataJSON qnaView(Model model, @PathVariable int uid ,HttpSession session) {
		model.addAttribute("uid", uid);
		
		new UserQnAViewCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	

}
