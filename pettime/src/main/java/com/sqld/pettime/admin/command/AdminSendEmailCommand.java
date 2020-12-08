package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.BufPassword;
import com.sqld.pettime.util.DBSession;
import com.sqld.pettime.util.Sandmail;

public class AdminSendEmailCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		String bufPassword = new BufPassword().getBufPassword();
		dto.setPassword(DBSession.passwordEncoder.encode(bufPassword));
		int result = dao.updatePassword(dto);
		
		Sandmail.sand(dto.getEmail(), "Pettime 임시비밀번호 안내입니다.", "귀하의 임시비밀번호는" + bufPassword + " 입니다.");
		
		model.addAttribute("result", result);
		model.addAttribute("num", dto.getNum());
	}

}
