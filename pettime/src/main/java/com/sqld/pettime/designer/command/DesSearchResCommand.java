package com.sqld.pettime.designer.command;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesMainDAO;
import com.sqld.pettime.dto.ResDetailDTO;
import com.sqld.pettime.dto.ResListDTO;
import com.sqld.pettime.util.DBSession;

public class DesSearchResCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesMainDAO dao = DBSession.sqlSession.getMapper(DesMainDAO.class);
		int num = (int)model.getAttribute("num");
		String id = (String)model.getAttribute("id");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		ResListDTO dto = dao.selectResNum(num, id);
		List<ResDetailDTO> list = dao.searchDetail(num);
		String date = sdf.format(dto.getStime());
		model.addAttribute("date", date);
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);

	}

}
