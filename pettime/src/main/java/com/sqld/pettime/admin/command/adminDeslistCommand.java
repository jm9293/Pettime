package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.admin.beans.AdminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adminDeslistCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		model.addAttribute("list", dao.selectDeslist());

	}

}
