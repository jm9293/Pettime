package com.sqld.pettime.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqld.pettime.admin.command.AdminMenulistCommand;
import com.sqld.pettime.admin.command.AdminNoticeSelectCommend;
import com.sqld.pettime.admin.command.AdminResSearchCommand;
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
}
