package com.sqld.pettime.admin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqld.pettime.admin.beans.AjaxAdmin;
import com.sqld.pettime.admin.command.AdminResDeleteCommand;
import com.sqld.pettime.admin.command.AdminResReadlistCommand;

@RestController
@RequestMapping("/admin/adRes")
public class AdResController {
	
	@GetMapping("/{date}")
	public AjaxAdmin readList(@PathVariable String date, Model model) {
		model.addAttribute("date", date);
		new AdminResReadlistCommand().execute(model);
		AjaxAdmin data =  (AjaxAdmin)model.getAttribute("data");
		return data;
	}
	
	@PostMapping("")
	public AjaxAdmin deleteList(int [] num, Model model) {
		model.addAttribute("nums", num);
		new AdminResDeleteCommand().execute(model);
		AjaxAdmin data = (AjaxAdmin)model.getAttribute("data");
		return data;
	}
}
