package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dto.MenuDTO;
import com.sqld.pettime.util.DBSession;

public class adMenuUpdateCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		MenuDAO dao = DBSession.sqlSession.getMapper(MenuDAO.class);
		MenuDTO dto = (MenuDTO)model.getAttribute("dto");
		
		int num = (int)dto.getNum();
		
		MenuDTO dto2 = dao.selectNum(num);
		
		model.addAttribute("dto", dto2);
	}

}
