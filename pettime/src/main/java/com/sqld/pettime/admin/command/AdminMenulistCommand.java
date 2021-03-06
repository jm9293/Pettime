package com.sqld.pettime.admin.command;

import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.admin.beans.AjaxAdmin;
import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dto.MenuDTO;
import com.sqld.pettime.util.DBSession;

public class AdminMenulistCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		MenuDAO dao = DBSession.sqlSession.getMapper(MenuDAO.class);
		List<MenuDTO> list = dao.selectList();
		
		model.addAttribute("list", list);

	}

}
