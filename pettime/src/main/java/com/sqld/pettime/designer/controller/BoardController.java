package com.sqld.pettime.designer.controller;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqld.pettime.designer.command.DCommand;
import com.sqld.pettime.designer.command.NoticeListCommand;
import com.sqld.pettime.designer.command.QnaListCommand;


@Controller
@RequestMapping(value="/designer/board")
public class BoardController {
	
	private DCommand command;
	
	
	
	
	
	@RequestMapping("/notice")
	public String dNotice(Model model) {
		command = new NoticeListCommand();
		command.execute(model);
		return "designer/board/dNotice";
	}
	
	
	@RequestMapping("/qna")
	public String dQnA(Model model) {
		command =  new QnaListCommand();
		command.execute(model);
		return "designer/board/dQna";
	}
	
	
}
