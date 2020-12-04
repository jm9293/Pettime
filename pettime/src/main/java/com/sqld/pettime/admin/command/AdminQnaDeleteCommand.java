package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.QnaDAO;
import com.sqld.pettime.util.DBSession;

public class AdminQnaDeleteCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
		int num = (int)model.getAttribute("num");
		int result = dao.deleteWord(num);
		
		model.addAttribute("result", result);
	}

}
