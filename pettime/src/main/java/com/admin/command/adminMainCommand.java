package com.admin.command;

import org.springframework.ui.Model;

import com.admin.beans.adminMainDAO;
import com.admin.common.C;

public class adminMainCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		adminMainDAO dao = C.sqlSession.getMapper(adminMainDAO.class);
		model.addAttribute("cnt", dao.selectRes());
		model.addAttribute("cnt2", dao.selectUser());
	}

}
