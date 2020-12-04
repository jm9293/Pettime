package com.sqld.pettime.admin.command;

import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.QnaDAO;
import com.sqld.pettime.dto.QnaDTO;
import com.sqld.pettime.util.DBSession;

public class AdminQnaSelectCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		List<QnaDTO> list = null;
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
		int maxCnt = dao.maxCnt();
		list = dao.selectPage((int)model.getAttribute("page"));
		int page = (int)model.getAttribute("page");
		int pageNum = (int)Math.ceil(maxCnt/7.0);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		model.addAttribute("page", page);

	}

}
