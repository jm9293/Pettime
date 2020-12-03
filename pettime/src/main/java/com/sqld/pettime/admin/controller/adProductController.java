package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqld.pettime.admin.command.adMenuAddCommand;
import com.sqld.pettime.admin.command.adMenuDeleteCommand;
import com.sqld.pettime.admin.command.adMenuUpdateCommand;
import com.sqld.pettime.admin.command.adMenuUpdateOkCommand;
import com.sqld.pettime.admin.command.adMenuViewCommand;
import com.sqld.pettime.admin.command.adMenulistCommand;
import com.sqld.pettime.dto.MenuDTO;


@Controller
@RequestMapping("/admin/adProduct")
public class adProductController {
	
	
	@RequestMapping("/adProductlist")
	public void goProduct(Model model) {
		new adMenulistCommand().execute(model);
	}
	
	@RequestMapping("/adProductView")
	public void goView(int num, Model model) {
		model.addAttribute("num", num);
		new adMenuViewCommand().execute(model);
	}
	
	@RequestMapping("/adProductAdd")
	public void goAdd() {}
	
	@RequestMapping(value = "/adProductAddOk", method = RequestMethod.POST)
	public String goAddOk(MenuDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new adMenuAddCommand().execute(model);
		return "admin/adProduct/adProductAddOk";
	}
	
	@RequestMapping("/adProductupdate")
	public void goUpdate(MenuDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new adMenuUpdateCommand().execute(model);
	}
	
	@RequestMapping(value = "/adProductUpdateOk" , method = RequestMethod.POST)
	public String goUpdateOk(MenuDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new adMenuUpdateOkCommand().execute(model);
		return "admin/adProduct/adProductUpdateOk";
	}
	
	@RequestMapping("/adProductDelete")
	public void goDelete(int num, Model model) {
		model.addAttribute("num", num);
		new adMenuDeleteCommand().execute(model);
	}
}
