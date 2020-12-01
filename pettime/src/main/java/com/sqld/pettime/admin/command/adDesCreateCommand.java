package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.admin.beans.DesignerDTO;
import com.admin.beans.adminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adDesCreateCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		
		adminInfoDAO dao = DBSession.sqlSession.getMapper(adminInfoDAO.class);
		
		model.addAttribute("result", dao.insertDes(dto));

	}

}
