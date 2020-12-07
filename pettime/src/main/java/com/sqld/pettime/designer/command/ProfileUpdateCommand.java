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
		
		if(dto.getPassword()==null) {
			dto.setPassword(origin.getPassword());
		}else {
			dto.setPassword(DBSession.passwordEncoder.encode(dto.getPassword()));			
		}
		
		if(dto.getEmail()==null) {
			dto.setEmail(origin.getEmail());
		}
		if(dto.getPhone()==null) {
			dto.setPhone(origin.getPhone());
		}
		if(dto.getIntro()==null) {
			dto.setIntro(origin.getIntro());
		}
		
		
		int result =  dao.updateMyInfo(dto);
		model.addAttribute("result", result);
		System.out.println(dto);
		
		
		
		
	}

}
