package com.sqld.pettime.designer.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesMainDAO;
import com.sqld.pettime.util.DBSession;

public class DesResResultCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesMainDAO dao = DBSession.sqlSession.getMapper(DesMainDAO.class);
		int num = (int)model.getAttribute("num");
		String state = "처리완료";
		
		int result = dao.updateResult(num, state);
		
		model.addAttribute("result", result);
		model.addAttribute("num", num);

	}

}
