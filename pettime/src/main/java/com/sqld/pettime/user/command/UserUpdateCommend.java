package com.sqld.pettime.user.command;


import org.springframework.ui.Model;


import com.sqld.pettime.dao.UserDAO;
import com.sqld.pettime.dto.UserDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserUpdateCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		
		UserDataJSON ajax = new UserDataJSON();
		UserDTO dto = (UserDTO)model.getAttribute("dto");
		String id = (String)model.getAttribute("id");
		UserDAO dao = DBSession.sqlSession.getMapper(UserDAO.class);
		UserDTO origin = dao.selectById(id);
		
		dto.setId(origin.getId());
		
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
		
		
		int res = dao.update(dto);
		
		
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
