package com.sqld.pettime.designer.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sqld.pettime.designer.beans.AjaxDes;
import com.sqld.pettime.designer.command.DesDesCreateEmailChkCommand;

@RestController
@RequestMapping("/designer/desProfile")
public class DesChkController {
	
	@GetMapping("/{emailId}/{emailAdd}")
	public AjaxDes chkEmail(@PathVariable("emailId") String emailId, @PathVariable("emailAdd") StringBuffer emailAdd, Model model) {
		model.addAttribute("emailId", emailId);
		model.addAttribute("emailAdd", emailAdd);
		System.out.println("들어옴?");
		new DesDesCreateEmailChkCommand().execute(model);
		AjaxDes data = (AjaxDes)model.getAttribute("data");
		return data;
	}
}
