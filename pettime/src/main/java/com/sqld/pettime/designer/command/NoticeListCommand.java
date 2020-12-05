package com.sqld.pettime.designer.command;

import org.springframework.ui.Model;


import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.util.DBSession;



public class NoticeListCommand implements DCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		model.addAttribute("list", dao.select());
	}

}
