package com.admin.command;


import java.util.List;

import org.springframework.ui.Model;

import com.admin.beans.adminDesDTO;
import com.admin.beans.adminInfoDAO;
import com.admin.common.C;

public class admindDesStatusCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		adminInfoDAO dao = C.sqlSession.getMapper(adminInfoDAO.class);
		int num = (int)model.getAttribute("num");
		char chk = '1';
		char chk2 = '0';
		int cnt = 0;
		adminDesDTO dto = new adminDesDTO();
		
		List<adminDesDTO> list = dao.selectDesByNum(num);
		
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
