package com.sqld.pettime.admin.command;


import java.util.List;


import org.springframework.ui.Model;

import com.admin.beans.DesignerDTO;

import com.admin.beans.adminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class admindDesStatusCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		adminInfoDAO dao = DBSession.sqlSession.getMapper(adminInfoDAO.class);
		int num = (int)model.getAttribute("num");
		char chk = '1';
		char chk2 = '0';
		int cnt = 0;
		DesignerDTO dto = new DesignerDTO();
		
		List<DesignerDTO> list = dao.selectDesByNum(num);
		
		for (int i = 0; i < list.size(); i++) {
			dto.setNum(list.get(i).getNum());
			dto.setId(list.get(i).getId());
			dto.setName(list.get(i).getName());
			dto.setEmail(list.get(i).getEmail());
			dto.setPhone(list.get(i).getPhone());
			dto.setIntro(list.get(i).getIntro());
			dto.setEnabled(list.get(i).getEnabled());
		}
		
		if(dto.getEnabled() == chk) {
			dto.setEnabled(chk2);
		}else {
			dto.setEnabled(chk);
		}
		
		cnt = dao.updateDesInfo(dto.getNum(), dto);
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("num", dto.getNum());
		
	}

}
