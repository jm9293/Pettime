package com.admin.command;

import org.springframework.ui.Model;

import com.admin.beans.adminDesDTO;
import com.admin.beans.adminInfoDAO;
import com.admin.common.C;

public class adDesCreateCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		adminDesDTO dto = (adminDesDTO)model.getAttribute("dto");
		
		adminInfoDAO dao = C.sqlSession.getMapper(adminInfoDAO.class);
		
		model.addAttribute("result", dao.insertDes(dto));

	}

}
