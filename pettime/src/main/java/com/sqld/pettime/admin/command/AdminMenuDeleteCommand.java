package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.util.DBSession;

public class AdminMenuDeleteCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		MenuDAO dao = DBSession.sqlSession.getMapper(MenuDAO.class);
		int num = (int)model.getAttribute("num");
		
		int result = dao.deleteMenu(num);
		
		model.addAttribute("result", result);

	}

}
