package com.admin.command;

import org.springframework.ui.Model;

import com.admin.beans.adminInfoDAO;
import com.admin.common.C;

public class adminDeslistCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		adminInfoDAO dao = C.sqlSession.getMapper(adminInfoDAO.class);
		model.addAttribute("list", dao.selectDeslist());

	}

}
