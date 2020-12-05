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
		
		
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("datestr", sdf.format(date)+"의 예약내역");
		model.addAttribute("date", date);
		return "designer/main/dMain";
		
	}
	
	
	
}
