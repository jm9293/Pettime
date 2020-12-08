package com.sqld.pettime.designer.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesignerDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;

public class DesSearchCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesignerDAO dao = DBSession.sqlSession.getMapper(DesignerDAO.class);
		String id = (String)model.getAttribute("id");
		
		DesignerDTO dto = dao.selectMyInfo(id);
		model.addAttribute("dto", dto);

	}

}
