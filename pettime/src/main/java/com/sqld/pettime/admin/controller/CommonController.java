package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqld.pettime.admin.command.adResListCommand;
import com.sqld.pettime.admin.command.adminMainCommand;


@Controller
@RequestMapping("/admin")
public class CommonController {
	
	

	@RequestMapping("/adminLogin")
	public void doLogin() {
		System.out.println("login������");
	}
	
	@RequestMapping("/adminMain")
	public void goMain(Model model) {
		System.out.println("����������");
		new adminMainCommand().execute(model);
	}
	
	@RequestMapping("/adRes")
	public void goRed(Model model) {
		System.out.println("����Ȯ��������");
		new adResListCommand().execute(model);
	}
	

}
