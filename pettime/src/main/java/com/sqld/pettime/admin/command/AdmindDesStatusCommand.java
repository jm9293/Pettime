package com.sqld.pettime.admin.command;


import java.util.List;


import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;

public class AdmindDesStatusCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		int num = (int)model.getAttribute("num");
		String chk = "1";
		String chk2 = "0";
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
		
		if(chk.charAt(0) == dto.getEnabled()) {
			dto.setEnabled(chk2.charAt(0));
		}else {
			dto.setEnabled(chk.charAt(0));
		}
		
		cnt = dao.updateDesInfo(dto.getNum(), dto);
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("num", dto.getNum());
		
	}

}
