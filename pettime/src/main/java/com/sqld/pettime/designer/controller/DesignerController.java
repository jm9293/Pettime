package com.sqld.pettime.designer.controller;




import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqld.pettime.designer.command.DCommand;
import com.sqld.pettime.designer.command.DesMainCommand;
import com.sqld.pettime.designer.command.DesMonthHoliCommand;
import com.sqld.pettime.designer.command.DesResAddCommand;
import com.sqld.pettime.designer.command.DesResDeleteCommand;
import com.sqld.pettime.designer.command.DesSearchResCommand;
import com.sqld.pettime.dto.DesignerDTO;




@Controller
@RequestMapping(value = "/designer")
public class DesignerController {
	
	private DCommand command;
	private SqlSession sqlSession;
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String dloginView(DesignerDTO dto) {
		
		return "designer/dLogin";
	}
	
	
	
	@RequestMapping(value = "/main")
	public String dMain(String y,String m,String d, Model model) {
		Date date;
		if(y==null&&m==null&&d==null) {
			date = new Date();
		}else {
			date = new Date(Integer.parseInt(y)-1900, Integer.parseInt(m)-1,Integer.parseInt(d));
		}
		String id = "seon0000";
		
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("datestr", sdf.format(date));
		model.addAttribute("date", date);
		model.addAttribute("id", id);
		new DesMainCommand().execute(model);
		return "designer/main/dMain";
		
	}
	
	@RequestMapping("/desSearch")
	public String goSearch(int num, Model model) {
		String id = "seon0000";
		model.addAttribute("num", num);
		model.addAttribute("id", id);
		new DesSearchResCommand().execute(model);
		return "designer/main/desSearch";
	}
	
	@RequestMapping(value = "/schedule")
	public String goSchedule(String y,String m,String d, Model model) {
		Date date;
		if(y==null&&m==null&&d==null) {
			date = new Date();
		}else {
			date = new Date(Integer.parseInt(y)-1900, Integer.parseInt(m)-1,Integer.parseInt(d));
		}
		String id = "seon0000";
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
		
		model.addAttribute("datestr", sdf.format(date));
		model.addAttribute("datestr2", sdf2.format(date));
		model.addAttribute("date", date);
		model.addAttribute("id", id);
		new DesMonthHoliCommand().execute(model);
		return "designer/schedule/dSchedule";
		
	}
	
	@RequestMapping("/dScheduleCancle")
	public String goCancle(String datestr, Model model) {
		
		String id = "seon0000";
		model.addAttribute("datestr", datestr);
		model.addAttribute("id", id);
		new DesResDeleteCommand().execute(model);
		return "designer/schedule/dScheduleCancle";
		
	}
	
	@RequestMapping("/dScheduleAdd")
	public String goAdd(String datestr, Model model) {
		
		String id = "seon0000";
		model.addAttribute("datestr", datestr);
		model.addAttribute("id", id);
		new DesResAddCommand().execute(model);
		return "designer/schedule/dScheduleAdd";
		
	}
	
	
}
