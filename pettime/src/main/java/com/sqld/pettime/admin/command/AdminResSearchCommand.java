package com.sqld.pettime.admin.command;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdResAjaxDAO;
import com.sqld.pettime.dto.AdminResDTO;
import com.sqld.pettime.dto.ResDetailDTO;
import com.sqld.pettime.util.DBSession;

public class AdminResSearchCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		AdResAjaxDAO dao = DBSession.sqlSession.getMapper(AdResAjaxDAO.class);
		int num = (int)model.getAttribute("num");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		AdminResDTO dto = dao.searchRes(num);
		List<ResDetailDTO> dto2 = dao.searchDetail(num);
		String date = sdf.format(dto.getStime());
		model.addAttribute("date", date);
		model.addAttribute("dto", dto);
		model.addAttribute("dto2", dto2);
	}

}
