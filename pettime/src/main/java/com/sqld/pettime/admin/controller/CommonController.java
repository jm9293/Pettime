package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sqld.pettime.admin.command.adminMainCommand;


@Controller
@RequestMapping("/admin")
public class CommonController {
	
	

	@RequestMapping("/adminLogin")
	public void doLogin() {
	}
	
	@RequestMapping("/adminMain")
	public void goMain(Model model) {
		new adminMainCommand().execute(model);
	}
	
	@RequestMapping("/adRes")
	public void goRed() {}
	

}