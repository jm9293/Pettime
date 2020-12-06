package com.sqld.pettime.designer.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesHolidayDAO;

import com.sqld.pettime.util.DBSession;

public class DesResAddCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesHolidayDAO dao = DBSession.sqlSession.getMapper(DesHolidayDAO.class);
		String id = (String) model.getAttribute("id");
		String datestr = (String) model.getAttribute("datestr");

		int result = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(datestr);
			result = dao.addHol(id, date);
			model.addAttribute("result", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("id", id);
	}

}
