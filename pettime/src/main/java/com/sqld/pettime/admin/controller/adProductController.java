package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqld.pettime.admin.command.adMenulistCommand;

@Controller
@RequestMapping("/admin/adProduct")
public class adProductController {
	
	@RequestMapping("/adProlist")
	public void readList(Model model) {
		new adMenulistCommand().execute(model);
	}
}
