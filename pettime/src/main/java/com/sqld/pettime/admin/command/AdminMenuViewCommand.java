package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dto.MenuDTO;
import com.sqld.pettime.util.DBSession;

public class AdminMenuViewCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		MenuDAO dao = DBSession.sqlSession.getMapper(MenuDAO.class);
		int num = (int)model.getAttribute("num");
		
		MenuDTO dto = dao.selectNum(num);
		
		model.addAttribute("dto", dto);
	}

}
