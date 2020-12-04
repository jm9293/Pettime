package com.sqld.pettime.admin.command;

import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.QnaDAO;
import com.sqld.pettime.dto.QnaDTO;
import com.sqld.pettime.util.DBSession;

public class AdminQnaSearchCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		List<QnaDTO> list = null;
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
		String title =(String)model.getAttribute("title");
		int page = (int)model.getAttribute("page");
		title ="%"+title+"%";
		int maxCnt = dao.maxCntBySearch(title);
		int pageNum = (int)Math.ceil(maxCnt/7.0);
		list = dao.selectPageBySearch(page,title);

		model.addAttribute("page", page);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);

	}

}
