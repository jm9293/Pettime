package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdResAjaxDAO;
import com.sqld.pettime.util.DBSession;

public class AdminResResultCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		AdResAjaxDAO dao = DBSession.sqlSession.getMapper(AdResAjaxDAO.class);
		int num = (int)model.getAttribute("num");
		String state = "처리완료";
		
		int result = dao.updateResult(num, state);
		
		model.addAttribute("result", result);
		model.addAttribute("num", num);

	}

}
