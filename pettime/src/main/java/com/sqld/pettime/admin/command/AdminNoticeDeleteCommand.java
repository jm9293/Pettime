package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.util.DBSession;

public class AdminNoticeDeleteCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		int num = (int)model.getAttribute("num");
		
		int result = dao.deleteNum(num);
		
		model.addAttribute("result", result);

	}

}
