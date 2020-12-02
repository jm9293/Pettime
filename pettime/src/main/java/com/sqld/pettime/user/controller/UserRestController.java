package com.sqld.pettime.user.controller;




import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.admin.beans.UserAJAX;
import com.sqld.pettime.user.command.UserNoticeSelectCommend;
import com.sqld.pettime.user.command.UserNoticeViewCommend;
import com.sqld.pettime.user.command.UserQnASearchCommend;
import com.sqld.pettime.user.command.UserQnASelectCommend;
import com.sqld.pettime.user.command.UserQnAViewCommend;




@RestController
@RequestMapping("/rest")
public class UserRestController {
	

	
	@RequestMapping(value="/csrf-token", method=RequestMethod.GET)
	public @ResponseBody String getCsrfToken(HttpServletRequest request, Authentication authentication) {
	    CsrfToken token = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
	    return token.getToken();
	}
	
	@RequestMapping("/notice/list/{pageNum}")
	UserAJAX noticeSelect(Model model, @PathVariable int pageNum,HttpSession session) {
		model.addAttribute("pageNum", pageNum);
		new UserNoticeSelectCommend().excute(model);
		
		UserAJAX ajax = (UserAJAX) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/login")
	UserAJAX loginInput(String error , String logout , Model model) {
		System.out.println(error);
		System.out.println(logout);
		System.out.println("로그인페이지");
		UserAJAX ajax = new UserAJAX();

		return ajax;
	}
	
	@RequestMapping("/qna/list/{pageNum}")
	UserAJAX qnaSelect(Model model, @PathVariable int pageNum ,HttpSession session) {
		model.addAttribute("pageNum", pageNum);
		new UserQnASelectCommend().excute(model);
		
		UserAJAX ajax = (UserAJAX) model.getAttribute("ajax");
	
		return ajax;
	}
	
	@RequestMapping("/qna/search/{val}/{pageNum}")
	UserAJAX qnaSearch(Model model, @PathVariable String val,@PathVariable int pageNum ,HttpSession session) {
		model.addAttribute("val", val);
		System.out.println(val);
		model.addAttribute("pageNum", pageNum);
		System.out.println(pageNum);
		new UserQnASearchCommend().excute(model);
		
		UserAJAX ajax = (UserAJAX) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/notice/view/{uid}")
	UserAJAX noticeView(Model model, @PathVariable int uid ,HttpSession session) {
		model.addAttribute("uid", uid);
		
		new UserNoticeViewCommend().excute(model);
		
		UserAJAX ajax = (UserAJAX) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/qna/view/{uid}")
	UserAJAX qnaView(Model model, @PathVariable int uid ,HttpSession session) {
		model.addAttribute("uid", uid);
		
		new UserQnAViewCommend().excute(model);
		
		UserAJAX ajax = (UserAJAX) model.getAttribute("ajax");

		return ajax;
	}
	

}
