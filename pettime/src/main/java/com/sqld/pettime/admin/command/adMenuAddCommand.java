package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dto.MenuDTO;
import com.sqld.pettime.util.DBSession;

public class adMenuAddCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		MenuDAO dao = DBSession.sqlSession.getMapper(MenuDAO.class);
		MenuDTO dto = (MenuDTO)model.getAttribute("dto");
		
		String subject = dto.getSubject();
		int price = (int)dto.getPrice();
		
		int cnt = dao.addMenu(subject, price);
		System.out.println(cnt);
		model.addAttribute("result", cnt);
	}

}
