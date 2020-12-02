package com.sqld.pettime.admin.command;

import java.util.List;

import org.springframework.ui.Model;

import com.admin.beans.MenuDAO;
import com.admin.beans.MenuDTO;
import com.sqld.pettime.util.DBSession;

public class adMenulistCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		MenuDAO dao = DBSession.sqlSession.getMapper(MenuDAO.class);
		
		List<MenuDTO> list = dao.selectList();
		
		model.addAttribute("list", list);

	}

}
