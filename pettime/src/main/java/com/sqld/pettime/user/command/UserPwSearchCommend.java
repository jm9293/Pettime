package com.sqld.pettime.user.command;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import com.sqld.pettime.dao.UserDAO;
import com.sqld.pettime.dto.UserDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.BufPassword;
import com.sqld.pettime.util.DBSession;
import com.sqld.pettime.util.Sandmail;

public class UserPwSearchCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		
		UserDataJSON ajax = new UserDataJSON();
		
		UserDAO dao = DBSession.sqlSession.getMapper(UserDAO.class);
		String email= (String)model.getAttribute("email");
		String id = (String)model.getAttribute("id");
	
		
		
		UserDTO dto = dao.selectByIdAndEmail(id, email);
		
		if(dto!=null) {
			BufPassword bp = new BufPassword();
			String bufpw = bp.getBufPassword();
			Sandmail.sand(dto.getEmail(), "[Pettime]임시비밀번호 발급내용입니다.", "회원님의 임시 비밀번호는 "+bufpw+" 입니다.");
			dto.setPassword(DBSession.passwordEncoder.encode(bufpw));
			int res = dao.update(dto);
			ajax.setStatus("OK");
			ajax.setCnt(res);
			
		}else {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			
		}
		
		
		model.addAttribute("ajax", ajax);
		
		
		
	}

}
