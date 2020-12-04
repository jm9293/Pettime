package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminMainDAO;
import com.sqld.pettime.util.DBSession;

public class adminMainCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		AdminMainDAO dao = DBSession.sqlSession.getMapper(AdminMainDAO.class);
		model.addAttribute("cnt", dao.selectRes());
		model.addAttribute("cnt2", dao.selectUser());
		model.addAttribute("list", dao.worklist());
	}

}
