package com.sqld.pettime.designer.controller;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqld.pettime.designer.command.DCommand;
import com.sqld.pettime.designer.command.MonthScheduleCommand;
import com.sqld.pettime.util.DBSession;



@Controller
@RequestMapping(value = "/designer/schedule")
public class ScheduleController {
	
	private DCommand command;
	private SqlSession sqlSession;
	
	private static final String degid = "deus1";
	
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		DBSession.sqlSession =  sqlSession;
	}
	
	@RequestMapping(value = "/monthly")
	public String dScedule(Model model) {
		command = new MonthScheduleCommand();
		command.execute(model);
		return "/designer/schedule/dSchedule";
	}
	
	
}
