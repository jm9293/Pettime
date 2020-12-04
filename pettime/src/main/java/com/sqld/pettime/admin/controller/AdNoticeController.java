package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqld.pettime.admin.command.AdminNoticeDeleteCommand;
import com.sqld.pettime.admin.command.AdminNoticeSearchCommand;
import com.sqld.pettime.admin.command.AdminNoticeSelectNumCommand;
import com.sqld.pettime.admin.command.AdminNoticeUpdateCommand;
import com.sqld.pettime.admin.command.AdminNoticeViewCommand;
import com.sqld.pettime.admin.command.AdminNoticeWriteCommand;
import com.sqld.pettime.dto.NoticeDTO;

@Controller
@RequestMapping("/admin/adNotice")
public class AdNoticeController {

	@RequestMapping("/adNoticeView")
	public void goView(int page, int num, Model model) {
		model.addAttribute("num", num);
		model.addAttribute("page", page);
		new AdminNoticeViewCommand().execute(model);
	}
	
	@RequestMapping("/adNoticeWrite")
	public void goWrite() {}
	
	@RequestMapping(value = "/adNoticeWriteOk", method = RequestMethod.POST)
	public String goWriteOk(NoticeDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new AdminNoticeWriteCommand().execute(model);
		return "admin/adNotice/adNoticeWriteOk";
	}
	
	@RequestMapping("/adNoticeUpdate")
	public void goUpdate(int page, int num, Model model) {
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		new AdminNoticeSelectNumCommand().execute(model);
	}
	
	@RequestMapping(value = "/adNoticeUpdateOk", method = RequestMethod.POST)
	public String goUpdateOk(NoticeDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new AdminNoticeUpdateCommand().execute(model);
		return "admin/adNotice/adNoticeUpdateOk";
	}
	
	@RequestMapping("/adSearchText")
	public void goSearch(int page, String title, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("page", page);
		new AdminNoticeSearchCommand().execute(model);
	}
	
	@RequestMapping("/adNoticeDelete")
	public void goDelete(int num, Model model) {
		model.addAttribute("num", num);
		new AdminNoticeDeleteCommand().execute(model);
		
	}
}
