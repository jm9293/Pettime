package com.sqld.pettime.admin.command;


import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.dto.NoticeDTO;
import com.sqld.pettime.util.DBSession;

public class AdminNoticeSelectCommend implements AdminCommand{

	@Override
	public void execute(Model model) {
		List<NoticeDTO> list = null;
		
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		int maxCnt = dao.maxCnt();
		list = dao.selectPage((int)model.getAttribute("page"));
		
		int pageNum = (int)Math.ceil(maxCnt/7.0);
		int page = (int)model.getAttribute("page");
		
		model.addAttribute("page", page);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		model.addAttribute("maxCnt", maxCnt);
	}

}
