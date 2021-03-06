package com.sqld.pettime.user.controller;


import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.dto.QnaDTO;
import com.sqld.pettime.dto.ResListDTO;
import com.sqld.pettime.dto.UserDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.user.beans.UserLoginJSON;
import com.sqld.pettime.user.command.UserCallDesignersCommend;
import com.sqld.pettime.user.command.UserEmailchkCommend;
import com.sqld.pettime.user.command.UserIdSearchCommend;
import com.sqld.pettime.user.command.UserIdchkCommend;
import com.sqld.pettime.user.command.UserInfoCommend;
import com.sqld.pettime.user.command.UserNoticeSelectCommend;
import com.sqld.pettime.user.command.UserNoticeViewCommend;
import com.sqld.pettime.user.command.UserPwSearchCommend;
import com.sqld.pettime.user.command.UserQnADeleteCommend;
import com.sqld.pettime.user.command.UserQnASearchCommend;
import com.sqld.pettime.user.command.UserQnASelectCommend;
import com.sqld.pettime.user.command.UserQnAUpdateCommend;
import com.sqld.pettime.user.command.UserQnAViewCommend;
import com.sqld.pettime.user.command.UserQnAWriteCommend;
import com.sqld.pettime.user.command.UserResListSelectCommend;
import com.sqld.pettime.user.command.UserResListViewCommend;
import com.sqld.pettime.user.command.UserSetResListCommend;
import com.sqld.pettime.user.command.UserSignUpCommend;
import com.sqld.pettime.user.command.UserUpdateCommend;




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
	UserLoginJSON loginInput(Model model) {
		System.out.println("로그인페이지");
		UserLoginJSON json = new UserLoginJSON();
		json.setStatus("OK");
		json.setUsername("Notlogin");
		json.setIslogin(false);
		return json;
	}
	
	@RequestMapping("/isLogin")
	UserLoginJSON isLogin(Model model, Authentication authentication ) {
		System.out.println("로그인정상확인");
		UserLoginJSON json = new UserLoginJSON();
		json.setStatus("OK");
		json.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		json.setIslogin(true);
		
		return json;
	}
	
	@RequestMapping("/LoginFail")
	UserLoginJSON isLoginFail(Model model, HttpSession session ) {
		System.out.println("로그인실패");
		UserLoginJSON json = new UserLoginJSON();
		json.setStatus("OK");
		json.setUsername("loginFail");
		json.setMessage((String)session.getAttribute("loginFailMsg"));
		session.removeAttribute("loginFailMsg");
		json.setIslogin(false);
		return json;
	}
	
	@RequestMapping("/isNotLogin")
	UserLoginJSON isNotLogin(Model model, HttpSession session) {
		System.out.println("권한오류 및 로그인 상태 이상");
		UserLoginJSON json = new UserLoginJSON();
		json.setStatus("OK");
		json.setUsername("Notlogin");
		json.setIslogin(false);
		json.setMessage((String)session.getAttribute("accessDeniedMessage"));
		session.removeAttribute("accessDeniedMessage");
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
	
	@RequestMapping(value = "/qna/write" , method = RequestMethod.POST)
	UserDataJSON qnaWrite(Model model, QnaDTO dto, Authentication authentication) {
		
		dto.setUserid(((UserDetails)authentication.getPrincipal()).getUsername());
		model.addAttribute("dto", dto);
		new UserQnAWriteCommend().excute(model);
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/qna/update" , method = RequestMethod.POST)
	UserDataJSON qnaUpdate(Model model, QnaDTO dto, Authentication authentication) {
		dto.setUserid(((UserDetails)authentication.getPrincipal()).getUsername());
		model.addAttribute("dto", dto);
		new UserQnAUpdateCommend().excute(model);
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/qna/delete" , method = RequestMethod.POST)
	UserDataJSON qnaDelete(Model model, QnaDTO dto, Authentication authentication) {
		dto.setUserid(((UserDetails)authentication.getPrincipal()).getUsername());
		model.addAttribute("dto", dto);
		new UserQnADeleteCommend().excute(model);
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
	
	
	@RequestMapping(value = "/idchk" , method = RequestMethod.POST)
	UserDataJSON idchk(Model model, String id) {
		model.addAttribute("id", id);
		
		new UserIdchkCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/emailchk" , method = RequestMethod.POST)
	UserDataJSON emailchk(Model model, String email) {
		model.addAttribute("email", email);
		
		new UserEmailchkCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/signup" , method = RequestMethod.POST)
	UserDataJSON signup(Model model, UserDTO dto) {
		model.addAttribute("dto", dto);
		
		new UserSignUpCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/userinfo" , method = RequestMethod.POST)
	UserDataJSON signup(Model model, Authentication authentication) {
		model.addAttribute("id", ((UserDetails)authentication.getPrincipal()).getUsername());
		
		new UserInfoCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/userUpdate" , method = RequestMethod.POST)
	UserDataJSON userUpdate(Model model, UserDTO dto ,Authentication authentication) {
		model.addAttribute("dto", dto);
		model.addAttribute("id", ((UserDetails)authentication.getPrincipal()).getUsername());
		new UserUpdateCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/calldesigners" , method = RequestMethod.POST)
	UserDataJSON calldesigner(Model model, String date , String time) {
		
		model.addAttribute("date",date);
		model.addAttribute("time",time);
		
		
		
		new UserCallDesignersCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping(value = "/setResList" , method = RequestMethod.POST)
	UserDataJSON setResList(Model model,ResListDTO res, long stimeLong, String time ,
			String [] menu, MultipartFile photo , HttpServletRequest request,Authentication authentication) {
		
		res.setUserId(((UserDetails)authentication.getPrincipal()).getUsername());
		res.setStime(new Timestamp(stimeLong));
		System.out.println(new Timestamp(stimeLong));
		res.setState("결제완료");
		
		model.addAttribute("photo", photo);
		model.addAttribute("request", request);
		model.addAttribute("dto", res);
		model.addAttribute("time", time);
		model.addAttribute("menu", menu);
		System.out.println(time);
		
		new UserSetResListCommend().excute(model);
		
		
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/resList/list/{pageNum}")
	UserDataJSON resListSelect(Model model, @PathVariable int pageNum, Authentication authentication) {
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("id",((UserDetails)authentication.getPrincipal()).getUsername());
		new UserResListSelectCommend().excute(model);
		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");

		return ajax;
	}
	
	@RequestMapping("/resList/view/{uid}")
	UserDataJSON resListView(Model model, @PathVariable int uid , Authentication authentication) {
		model.addAttribute("uid", uid);
		model.addAttribute("id",((UserDetails)authentication.getPrincipal()).getUsername());
		new UserResListViewCommend().excute(model);		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");
		return ajax;
	}
	
	@RequestMapping("/idSearch")
	UserDataJSON idSearch(Model model, String name , String email) {
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		new UserIdSearchCommend().excute(model);		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");
		return ajax;
	}
	
	@RequestMapping("/pwSearch")
	UserDataJSON pwSearch(Model model, String id , String email) {
		model.addAttribute("id", id);
		model.addAttribute("email", email);
		new UserPwSearchCommend().excute(model);		
		UserDataJSON ajax = (UserDataJSON) model.getAttribute("ajax");
		return ajax;
	}
	
	
	
	

}
