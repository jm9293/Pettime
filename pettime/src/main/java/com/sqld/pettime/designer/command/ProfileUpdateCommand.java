package com.sqld.pettime.designer.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesignerDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;

public class ProfileUpdateCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesignerDAO dao = DBSession.sqlSession.getMapper(DesignerDAO.class);
		String id = (String)model.getAttribute("id");
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		dto.setId(id);
		DesignerDTO origin = dao.selectMyInfo(id);
		System.out.println(origin.getEmail());
		
		if(dto.getPassword().equals("")) {
			dto.setPassword(origin.getPassword());
		}else {
			dto.setPassword(DBSession.passwordEncoder.encode(dto.getPassword()));			
		}
		
		if(dto.getEmail().equals("")) {
			dto.setEmail(origin.getEmail());
		}
		if(dto.getPhone().equals("010")|| dto.getPhone().equals("")) {
			dto.setPhone(origin.getPhone());
		}
		if(dto.getIntro().equals("")) {
			dto.setIntro(origin.getIntro());
		}
		
		System.out.println(origin.getEmail());
		System.out.println(dto.toString());
		int result =  dao.updateMyInfo(dto);
		model.addAttribute("result", result);
		System.out.println(dto);
		
		
		
		
	}

}