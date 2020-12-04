package com.sqld.pettime.admin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqld.pettime.admin.beans.AjaxAdmin;
import com.sqld.pettime.admin.command.AdminCreateIdChkCommand;
import com.sqld.pettime.admin.command.AdminDesCreateEmailChkCommand;
import com.sqld.pettime.admin.command.AdminDesCreateIdChkCommand;

@RestController
@RequestMapping("/admin/createAdmin")
public class AdAdminChkController {
	
	@GetMapping("/{id}")
	public AjaxAdmin chkId(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		new AdminCreateIdChkCommand().execute(model);
		AjaxAdmin data = (AjaxAdmin)model.getAttribute("data");
		return data;
	}
	
}
