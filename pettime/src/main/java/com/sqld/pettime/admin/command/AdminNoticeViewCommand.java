package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.dto.NoticeDTO;
import com.sqld.pettime.util.DBSession;

public class AdminNoticeViewCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		int num = (int)model.getAttribute("num");
		int page = (int)model.getAttribute("page");
		NoticeDTO dto = dao.selectByUid(num);
		
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);

	}

}
