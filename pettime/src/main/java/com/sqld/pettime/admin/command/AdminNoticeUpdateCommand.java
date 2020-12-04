package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.dto.NoticeDTO;
import com.sqld.pettime.util.DBSession;

public class AdminNoticeUpdateCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		NoticeDTO dto = (NoticeDTO)model.getAttribute("dto");
		
		int result = dao.updateNotice(dto);
		model.addAttribute("result", result);


	}

}
