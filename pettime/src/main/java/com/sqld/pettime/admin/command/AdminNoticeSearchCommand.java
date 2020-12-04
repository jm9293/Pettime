package com.sqld.pettime.admin.command;



import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.dao.QnaDAO;
import com.sqld.pettime.dto.NoticeDTO;
import com.sqld.pettime.dto.QnaDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class AdminNoticeSearchCommand implements AdminCommand{

	@Override
	public void execute(Model model) {
		
		List<NoticeDTO> list = null;
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		String title =(String)model.getAttribute("title");
		int page = (int)model.getAttribute("pageNum");
		title ="%"+title+"%";
		int maxCnt = dao.maxCntBySearch(title);
		System.out.println(maxCnt);
		int pageNum = (int)Math.ceil(maxCnt/7.0);
		System.out.println(page +","+ title);
		list = dao.selectPageBySearch(page,title);
		System.out.println(list);
		model.addAttribute("page", page);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		model.addAttribute("maxCnt", maxCnt);
		
		
	}

}
