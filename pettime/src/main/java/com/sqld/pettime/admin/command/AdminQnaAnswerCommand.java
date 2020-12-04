package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.QnaDAO;
import com.sqld.pettime.util.DBSession;

public class AdminQnaAnswerCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
		int num = (int)model.getAttribute("num");
		String anser = (String)model.getAttribute("anser");
		int result = dao.insertAnswer(num, anser);
		
		model.addAttribute("result", result);
		model.addAttribute("num", num);

	}

}
