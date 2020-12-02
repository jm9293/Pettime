package com.sqld.pettime.admin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.beans.AjaxAdmin;
import com.sqld.pettime.admin.command.adDesCreateEmailChkCommand;
import com.sqld.pettime.admin.command.adDesCreateIdChkCommand;

@RestController
@RequestMapping("/admin/adInfo/adDesCreate")
public class adChkController {
	
	@GetMapping("/{id}")
	public AjaxAdmin chkId(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		new adDesCreateIdChkCommand().execute(model);
		AjaxAdmin data = (AjaxAdmin)model.getAttribute("data");
		return data;
	}
	
	@GetMapping("/{emailId}/{emailAdd}")
	public AjaxAdmin chkEmail(@PathVariable("emailId") String emailId, @PathVariable("emailAdd") StringBuffer emailAdd, Model model) {
		model.addAttribute("emailId", emailId);
		model.addAttribute("emailAdd", emailAdd);
		System.out.println("들어옴?");
		new adDesCreateEmailChkCommand().execute(model);
		AjaxAdmin data = (AjaxAdmin)model.getAttribute("data");
		return data;
	}
}
