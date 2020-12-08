package com.sqld.pettime.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqld.pettime.admin.command.AdminDesCreateCommand;
import com.sqld.pettime.admin.command.AdminDesCreateIdChkCommand;
import com.sqld.pettime.admin.command.AdminDesSearchCommand;
import com.sqld.pettime.admin.command.AdminDesViewCommand;
import com.sqld.pettime.admin.command.AdminDeslistCommand;
import com.sqld.pettime.admin.command.AdminUserSearchCommand;
import com.sqld.pettime.admin.command.AdminUserViewCommand;
import com.sqld.pettime.admin.command.AdminUserlistCommand;
import com.sqld.pettime.admin.command.AdmindDesStatusCommand;
import com.sqld.pettime.admin.command.AdmindUserStatusCommand;
import com.sqld.pettime.dto.DesignerDTO;

@Controller
@RequestMapping("/admin/adInfo")
public class AdInfoController {

	@RequestMapping("/adUserlist")
	public void goUserlist(Model model) {
		new AdminUserlistCommand().execute(model);
	}
	
	@RequestMapping("/adUserInfo")
	public void goUserInfo(int userNum, Model model) {
		model.addAttribute("userNum", userNum);
		new AdminUserViewCommand().execute(model);
	}
	
	@RequestMapping(value = "/adUserlistSearch", method = RequestMethod.POST)
	public String SearchUser(String [] selectMenu, String text, Model model) {
		model.addAttribute("selectMenu", selectMenu);
		model.addAttribute("text", text);
		new AdminUserSearchCommand().execute(model);
		return "admin/adInfo/adUserlistSearch";
	}
	
	@RequestMapping(value = "/adUserStatus", method = RequestMethod.POST)
	public String StatusUser(int num, Model model) {
		model.addAttribute("num", num);
		new AdmindUserStatusCommand().execute(model);
		return "admin/adInfo/adUserStatus";
	}
	
	@RequestMapping("/adDeslist")
	public void goDeslist(Model model) {
		new AdminDeslistCommand().execute(model);
	}
	
	@RequestMapping("/adDesInfo")
	public void goDesInfo(int num, Model model) {
		model.addAttribute("num", num);
		new AdminDesViewCommand().execute(model);
	}
	
	@RequestMapping(value = "/adDeslistSearch", method = RequestMethod.POST)
	public String SearchDes(String [] selectMenu, String text, Model model) {
		model.addAttribute("selectMenu", selectMenu);
		model.addAttribute("text", text);
		new AdminDesSearchCommand().execute(model);
		return "admin/adInfo/adDeslistSearch";
	}
	
	@RequestMapping(value = "/adDesStatus", method = RequestMethod.POST)
	public String StatusDes(int num, Model model) {
		model.addAttribute("num", num);
		new AdmindDesStatusCommand().execute(model);
		return "admin/adInfo/adDesStatus";
	}
	
	@RequestMapping("/adDesCreate")
	public void CreateDes() {}
	
	@RequestMapping(value = "/adDesCreateOk", method = RequestMethod.POST)
	public String CreateDesOk(DesignerDTO dto, Model model, HttpServletRequest request) {
		model.addAttribute("dto", dto);
		model.addAttribute("request", request);
		new AdminDesCreateCommand().execute(model);
		return "admin/adInfo/adDesCreateOk";
	}
	
}
