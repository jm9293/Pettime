package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dto.MenuDTO;
import com.sqld.pettime.util.DBSession;

public class adMenuUpdateOkCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		MenuDAO dao = DBSession.sqlSession.getMapper(MenuDAO.class);
		MenuDTO dto = (MenuDTO)model.getAttribute("dto");
		
		int result = dao.updateMenu(dto);
		
		model.addAttribute("result", result);

	}

}
