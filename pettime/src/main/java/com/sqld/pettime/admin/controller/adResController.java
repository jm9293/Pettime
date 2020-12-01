package com.sqld.pettime.admin.controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.beans.AjaxAdmin;
import com.admin.beans.adminResDTO;
import com.sqld.pettime.admin.command.adResReadlistCommand;

@RestController
@RequestMapping("/admin/adRes")
public class adResController {
	
	@GetMapping("/{date}")
	public AjaxAdmin readList(@PathVariable String date, Model model) {
		model.addAttribute("date", date);
		System.out.println(date);
		new adResReadlistCommand().execute(model);
		
		AjaxAdmin data =  (AjaxAdmin)model.getAttribute("data");
		
		return data;
	}
}
