package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqld.pettime.admin.command.AdminMenuAddCommand;
import com.sqld.pettime.admin.command.AdminMenuDeleteCommand;
import com.sqld.pettime.admin.command.AdminMenuUpdateCommand;
import com.sqld.pettime.admin.command.AdminMenuUpdateOkCommand;
import com.sqld.pettime.admin.command.AdminMenuViewCommand;
import com.sqld.pettime.admin.command.AdminMenulistCommand;
import com.sqld.pettime.dto.MenuDTO;


@Controller
@RequestMapping("/admin/adProduct")
public class AdProductController {
	
	
	@RequestMapping("/adProductlist")
	public void goProduct(Model model) {
		new AdminMenulistCommand().execute(model);
	}
	
	@RequestMapping("/adProductView")
	public void goView(int num, Model model) {
		model.addAttribute("num", num);
		new AdminMenuViewCommand().execute(model);
	}
	
	@RequestMapping("/adProductAdd")
	public void goAdd() {}
	
	@RequestMapping(value = "/adProductAddOk", method = RequestMethod.POST)
	public String goAddOk(MenuDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new AdminMenuAddCommand().execute(model);
		return "admin/adProduct/adProductAddOk";
	}
	
	@RequestMapping("/adProductupdate")
	public void goUpdate(MenuDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new AdminMenuUpdateCommand().execute(model);
	}
	
	@RequestMapping(value = "/adProductUpdateOk" , method = RequestMethod.POST)
	public String goUpdateOk(MenuDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new AdminMenuUpdateOkCommand().execute(model);
		return "admin/adProduct/adProductUpdateOk";
	}
	
	@RequestMapping("/adProductDelete")
	public void goDelete(int num, Model model) {
		model.addAttribute("num", num);
		new AdminMenuDeleteCommand().execute(model);
	}
}
