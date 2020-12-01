package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.beans.DesignerDTO;
import com.sqld.pettime.admin.command.adDesCreateCommand;
import com.sqld.pettime.admin.command.adDesCreateIdChkCommand;
import com.sqld.pettime.admin.command.adminDesSearchCommand;
import com.sqld.pettime.admin.command.adminDesViewCommand;
import com.sqld.pettime.admin.command.adminDeslistCommand;
import com.sqld.pettime.admin.command.adminUserSearchCommand;
import com.sqld.pettime.admin.command.adminUserViewCommand;
import com.sqld.pettime.admin.command.adminUserlistCommand;
import com.sqld.pettime.admin.command.admindDesStatusCommand;
import com.sqld.pettime.admin.command.admindUserStatusCommand;

@Controller
@RequestMapping("/admin/adInfo")
public class adInfoController {

	@RequestMapping("/adUserlist")
	public void goUserlist(Model model) {
		new adminUserlistCommand().execute(model);
	}
	
	@RequestMapping("/adUserInfo")
	public void goUserInfo(int userNum, Model model) {
		model.addAttribute("userNum", userNum);
		new adminUserViewCommand().execute(model);
	}
	
	@RequestMapping(value = "/adUserlistSearch", method = RequestMethod.POST)
	public String SearchUser(String [] selectMenu, String text, Model model) {
		model.addAttribute("selectMenu", selectMenu);
		model.addAttribute("text", text);
		new adminUserSearchCommand().execute(model);
		return "admin/adInfo/adUserlistSearch";
	}
	
	@RequestMapping(value = "/adUserStatus", method = RequestMethod.POST)
	public String StatusUser(int num, Model model) {
		model.addAttribute("num", num);
		new admindUserStatusCommand().execute(model);
		return "admin/adInfo/adUserStatus";
	}
	
	@RequestMapping("/adDeslist")
	public void goDeslist(Model model) {
		new adminDeslistCommand().execute(model);
	}
	
	@RequestMapping("/adDesInfo")
	public void goDesInfo(int num, Model model) {
		model.addAttribute("num", num);
		new adminDesViewCommand().execute(model);
	}
	
	@RequestMapping(value = "/adDeslistSearch", method = RequestMethod.POST)
	public String SearchDes(String [] selectMenu, String text, Model model) {
		model.addAttribute("selectMenu", selectMenu);
		model.addAttribute("text", text);
		new adminDesSearchCommand().execute(model);
		return "admin/adInfo/adDeslistSearch";
	}
	
	@RequestMapping(value = "/adDesStatus", method = RequestMethod.POST)
	public String StatusDes(int num, Model model) {
		model.addAttribute("num", num);
		new admindDesStatusCommand().execute(model);
		return "admin/adInfo/adDesStatus";
	}
	
	@RequestMapping("/adDesCreate")
	public void CreateDes(Model model) {
		new adDesCreateIdChkCommand().execute(model);
	}
	
	@RequestMapping(value = "/adDesCreateOk", method = RequestMethod.POST)
	public String CreateDesOk(DesignerDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new adDesCreateCommand().execute(model);
		return "admin/adInfo/adDesCreateOk";
	}
	
}
