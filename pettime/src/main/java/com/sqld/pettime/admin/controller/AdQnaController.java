package com.sqld.pettime.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sqld.pettime.admin.command.AdminQnaAnswerCommand;
import com.sqld.pettime.admin.command.AdminQnaDeleteCommand;
import com.sqld.pettime.admin.command.AdminQnaSearchCommand;
import com.sqld.pettime.admin.command.AdminQnaSelectNumCommand;
import com.sqld.pettime.admin.command.AdminQnaViewCommand;

@Controller
@RequestMapping("/admin/adQna")
public class AdQnaController {
	
	@RequestMapping("/adQnaView")
	public void goView(int num, Model model) {
		model.addAttribute("num", num);
		new AdminQnaViewCommand().execute(model);
	}
	
	@RequestMapping("/adQnaAnswer")
	public void goAnswer(int num, Model model) {
		model.addAttribute("num", num);
		new AdminQnaSelectNumCommand().execute(model);
	}
	
	@RequestMapping(value = "/adQnaAnswerOk", method = RequestMethod.POST)
	public String goAnswerOk(int num, String anser, Model model) {
		model.addAttribute("num", num);
		model.addAttribute("anser", anser);
		new AdminQnaAnswerCommand().execute(model);
		return "admin/adQna/adQnaAnswerOk";
	}
	
	@RequestMapping("/adQnaUpdate")
	public void goUpdate(int num, Model model) {
		model.addAttribute("num", num);
		new AdminQnaSelectNumCommand().execute(model);
	}
	
	@RequestMapping(value = "/adQnaUpdateOk", method = RequestMethod.POST)
	public String goUpdateOk(int num, String anser, Model model) {
		model.addAttribute("num", num);
		model.addAttribute("anser", anser);
		new AdminQnaAnswerCommand().execute(model);
		return "admin/adQna/adQnaUpdateOk";
	}
	
	@RequestMapping("/adQnaDelete")
	public void goDelete(int num, Model model) {
		model.addAttribute("num", num);
		new AdminQnaDeleteCommand().execute(model);
	}
	
	@RequestMapping("/adSearchText2")
	public void goSearch2(int page, String title, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("page", page);
		new AdminQnaSearchCommand().execute(model);
	}
}
