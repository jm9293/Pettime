package com.sqld.pettime.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqld.pettime.admin.command.AdminMenulistCommand;
import com.sqld.pettime.admin.command.AdminNoticeSelectCommend;
import com.sqld.pettime.admin.command.AdminQnaSelectCommand;
import com.sqld.pettime.admin.command.AdminResSearchCommand;
import com.sqld.pettime.admin.command.AdminShowListCommand;
import com.sqld.pettime.dto.AdminDTO;
import com.sqld.pettime.admin.command.AdminCreateCommand;
import com.sqld.pettime.admin.command.AdminMainCommand;


@Controller
@RequestMapping("/admin")
public class CommonController {
	@RequestMapping("/adminLogin")
	public void doLogin(Model model, HttpSession session) {
		String msg = (String)session.getAttribute("loginFailMsg");
		session.removeAttribute("loginFailMsg");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}else {
			model.addAttribute("msg", "");
		}
	}
	
	@RequestMapping("/createAdmin")
	public void doCreate(Model model) {
		new AdminShowListCommand().execute(model);
	}
	
	@RequestMapping(value = "/createOk", method = RequestMethod.POST)
	public String doCreateAdmin(AdminDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new AdminCreateCommand().execute(model);
		return "admin/createOk";
	}
	
	@RequestMapping("/adminMain")
	public void goMain(Model model) {
		new AdminMainCommand().execute(model);
	}
	
	@RequestMapping("/adRes")
	public void goRed() {}

	@RequestMapping("/logoutOk")
	public String exitLogin(Model model) {
		String msg = "로그아웃 되었습니다.";
		model.addAttribute("msg", msg);
		return "admin/adminLogin";
	}
	
	@RequestMapping("/adResSearch")
	public void goSearch(int num, Model model) {
		model.addAttribute("num", num);
		new AdminResSearchCommand().execute(model);
	}
	
	@RequestMapping("/adNotice/adNoticelist")
	public void goNotice(int page, Model model) {
		model.addAttribute("page", page);
		new AdminNoticeSelectCommend().execute(model);
	}
	
	@RequestMapping("/adQna/adQnalist")
	public void goQna(int page, Model model) {
		model.addAttribute("page", page);
		new AdminQnaSelectCommand().execute(model);
	}
}
