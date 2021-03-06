package com.sqld.pettime.designer.controller;




import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sqld.pettime.designer.command.DCommand;
import com.sqld.pettime.designer.command.DesMainCommand;
import com.sqld.pettime.designer.command.DesMonthHoliCommand;
import com.sqld.pettime.designer.command.DesResAddCommand;
import com.sqld.pettime.designer.command.DesResDeleteCommand;
import com.sqld.pettime.designer.command.DesResResetCommand;
import com.sqld.pettime.designer.command.DesResResultCommand;
import com.sqld.pettime.designer.command.DesSearchCommand;
import com.sqld.pettime.designer.command.DesSearchResCommand;
import com.sqld.pettime.designer.command.DesUpdateCommand;
import com.sqld.pettime.designer.command.DesignerCommand;
import com.sqld.pettime.dto.DesignerDTO;




@Controller
@RequestMapping(value = "/designer")
public class DesignerController {
	
	private DCommand command;
	private SqlSession sqlSession;
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String dloginView(Model model, HttpSession session) {
		String msg = (String)session.getAttribute("loginFailMsg");
		session.removeAttribute("loginFailMsg");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}else {
			model.addAttribute("msg", "");
		
		}return "designer/dLogin";
	}
	
	@RequestMapping("/logoutOk")
	public String exitLogin(Model model) {
		String msg = "로그아웃 되었습니다.";
		model.addAttribute("msg", msg);
		return "designer/dLogin";
	}
	
	
	
	@RequestMapping(value = "/main")
	public String dMain(String y,String m,String d, Model model, Authentication authentication) {
		Date date;
		if(y==null&&m==null&&d==null) {
			date = new Date();
		}else {
			date = new Date(Integer.parseInt(y)-1900, Integer.parseInt(m)-1,Integer.parseInt(d));
		}
		String id = ((UserDetails)authentication.getPrincipal()).getUsername();
		
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("datestr", sdf.format(date));
		model.addAttribute("date", date);
		model.addAttribute("id", id);
		new DesMainCommand().execute(model);
		return "designer/main/dMain";
		
	}
	
	@RequestMapping("/desSearch")
	public String goSearch(int num, Model model, Authentication authentication) {
		String id = ((UserDetails)authentication.getPrincipal()).getUsername();
		model.addAttribute("num", num);
		model.addAttribute("id", id);
		new DesSearchResCommand().execute(model);
		return "designer/main/desSearch";
	}
	
	@RequestMapping("/desResResultOk")
	public String goResult(int num, Model model) {
		model.addAttribute("num", num);
		new DesResResultCommand().execute(model);
		return "designer/main/desResResultOk";
	}
	
	@RequestMapping("/desResResetOk")
	public String goReset(int num, Model model) {
		model.addAttribute("num", num);
		new DesResResetCommand().execute(model);
		return "designer/main/desResResultOk";
	}
	
	@RequestMapping(value = "/schedule")
	public String goSchedule(String y,String m,String d, Model model, Authentication authentication) {
		Date date;
		if(y==null&&m==null&&d==null) {
			date = new Date();
		}else {
			date = new Date(Integer.parseInt(y)-1900, Integer.parseInt(m)-1,Integer.parseInt(d));
		}
		String id = ((UserDetails)authentication.getPrincipal()).getUsername();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
		
		model.addAttribute("datestr", sdf.format(date));
		model.addAttribute("datestr2", sdf2.format(date));
		model.addAttribute("date", date);
		model.addAttribute("id", id);
		new DesMonthHoliCommand().execute(model);
		return "designer/schedule/dSchedule";
		
	}
	
	@RequestMapping("/dScheduleCancle")
	public String goCancle(String datestr, Model model, Authentication authentication) {
		
		String id = ((UserDetails)authentication.getPrincipal()).getUsername();
		model.addAttribute("datestr", datestr);
		model.addAttribute("id", id);
		new DesResDeleteCommand().execute(model);
		return "designer/schedule/dScheduleCancle";
		
	}
	
	@RequestMapping("/dScheduleAdd")
	public String goAdd(String datestr, Model model, Authentication authentication) {
		
		String id = ((UserDetails)authentication.getPrincipal()).getUsername();
		model.addAttribute("datestr", datestr);
		model.addAttribute("id", id);
		new DesResAddCommand().execute(model);
		return "designer/schedule/dScheduleAdd";
		
	}
	
	@RequestMapping("/desProfile")
	public void goInfo(Authentication authentication, Model model) {
		String id = ((UserDetails)authentication.getPrincipal()).getUsername();
		model.addAttribute("id", id);
		new DesSearchCommand().execute(model);
	}
	
	@RequestMapping(value = "/desUpdateOk", method = RequestMethod.POST)
	public String goUpdate(DesignerDTO dto, Authentication authentication, MultipartFile photo,HttpServletRequest request, Model model) {
		String id = ((UserDetails)authentication.getPrincipal()).getUsername();
		model.addAttribute("id", id);
		model.addAttribute("photo", photo);
		model.addAttribute("request", request);
		model.addAttribute("dto", dto);
		new DesUpdateCommand().execute(model);
		return "designer/desUpdateOk";
	}
}
