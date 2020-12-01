package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.admin.beans.adminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adminDeslistCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		adminInfoDAO dao = DBSession.sqlSession.getMapper(adminInfoDAO.class);
		model.addAttribute("list", dao.selectDeslist());

	}

}
