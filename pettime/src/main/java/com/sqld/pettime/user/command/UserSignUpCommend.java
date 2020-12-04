package com.sqld.pettime.user.command;


import org.springframework.ui.Model;


import com.sqld.pettime.dao.UserDAO;
import com.sqld.pettime.dto.UserDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserSignUpCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		
		UserDataJSON ajax = new UserDataJSON();
		UserDTO dto = (UserDTO)model.getAttribute("dto");
		UserDAO dao = DBSession.sqlSession.getMapper(UserDAO.class);
		dto.setPassword(DBSession.passwordEncoder.encode(dto.getPassword()));
		int res = dao.insert(dto);
		if(res==1) {
			dao.grantUser(dto.getId());
		}
		
		if(res==0) {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			
		}else {
			ajax.setStatus("OK");
			ajax.setCnt(res);
		}
		
		model.addAttribute("ajax", ajax);

	}

}
