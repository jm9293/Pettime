package com.sqld.pettime.designer.command;

import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesHolidayDAO;
import com.sqld.pettime.dto.MonthScheduleDTO;
import com.sqld.pettime.util.DBSession;

public class DesMonthHoliCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesHolidayDAO dao = DBSession.sqlSession.getMapper(DesHolidayDAO.class);
		String id = (String)model.getAttribute("id");
		String datestr = (String)model.getAttribute("datestr");
		String datestr2 = (String)model.getAttribute("datestr2");
		Date date = (Date)model.getAttribute("date");
		boolean chk = false;
		Date nowDay = new Date();
		
		List<MonthScheduleDTO> list = dao.selectHol(id, date);
		int cnt = dao.chkHol(id, date);
		
		if(date.getDate() < (nowDay.getDate()+8)) {
			chk = false;
		}else if(date.getDate() >= (nowDay.getDate()+8)) {
			chk = true;
		}
		model.addAttribute("cnt", cnt);
		model.addAttribute("chk", chk);
		model.addAttribute("list", list);
		model.addAttribute("id", id);
		model.addAttribute("datestr", datestr);
		model.addAttribute("datestr2", datestr2);
	}

}
