package com.sqld.pettime.designer.command;

import org.springframework.ui.Model;


import com.sqld.pettime.dao.QnaDAO;
import com.sqld.pettime.util.DBSession;



public class QnaListCommand implements DCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
		model.addAttribute("list",dao.select());
		
	}
	
	
	
}
