package com.sqld.pettime.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.beans.adminDesDTO;
import com.admin.command.adDesCreateCommand;
import com.admin.command.adDesCreateIdChkCommand;
import com.admin.command.adminDesSearchCommand;
import com.admin.command.adminDesViewCommand;
import com.admin.command.adminDeslistCommand;
import com.admin.command.adminUserSearchCommand;
import com.admin.command.adminUserViewCommand;
import com.admin.command.adminUserlistCommand;
import com.admin.command.admindDesStatusCommand;
import com.admin.command.admindUserStatusCommand;

@Controller
@RequestMapping("/admin/adInfo")
public class adInfoController {

	@RequestMapping("/adUserlist")
	public void goUserlist(Model model) {
		System.out.println("유저정보페이지");
		new adminUserlistCommand().execute(model);
	}
	
	@RequestMapping("/adUserInfo")
	public void goUserInfo(int userNum, Model model) {
		System.out.println("유저 상세 페이지");
		model.addAttribute("userNum", userNum);
		new adminUserViewCommand().execute(model);
	}
	
	@RequestMapping(value = "/adUserlistSearch", method = RequestMethod.POST)
	public String SearchUser(String [] selectMenu, String text, Model model) {
		model.addAttribute("selectMenu", selectMenu);
		model.addAttribute("text", text);
		new adminUserSearchCommand().execute(model);
		System.out.println("유저 검색");
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
		System.out.println("미용사정보페이지");
		new adminDeslistCommand().execute(model);
	}
	
	@RequestMapping("/adDesInfo")
	public void goDesInfo(int num, Model model) {
		System.out.println("미용사 상세 페이지");
		model.addAttribute("num", num);
		new adminDesViewCommand().execute(model);
	}
	
	@RequestMapping(value = "/adDeslistSearch", method = RequestMethod.POST)
	public String SearchDes(String [] selectMenu, String text, Model model) {
		model.addAttribute("selectMenu", selectMenu);
		model.addAttribute("text", text);
		new adminDesSearchCommand().execute(model);
		System.out.println("미용사 검색");
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
	public String CreateDesOk(adminDesDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new adDesCreateCommand().execute(model);
		return "admin/adInfo/adDesCreateOk";
	}
	
}
