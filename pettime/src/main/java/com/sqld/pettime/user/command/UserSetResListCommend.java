package com.sqld.pettime.user.command;


import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.ui.Model;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dao.ResListDAO;

import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.dto.ResListDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserSetResListCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<DesignerDTO> list = null;
		UserDataJSON ajax = new UserDataJSON();
		ResListDTO dto = (ResListDTO)model.getAttribute("dto");
		String time = (String)model.getAttribute("time");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ResListDAO dao = DBSession.sqlSession.getMapper(ResListDAO.class);
		
		switch (time) {
		case "time1":
			list = dao.callDesignersAbyID(sdf.format(dto.getStime()),dto.getDegId());
			break;
		case "time2":
			list = dao.callDesignersBbyID(sdf.format(dto.getStime()),dto.getDegId());
			break;
		case "time3":
			list = dao.callDesignersCbyID(sdf.format(dto.getStime()),dto.getDegId());
			break;
		}
		
		int res = dao.insertDayschdule(sdf.format(dto.getStime()), dto.getDegId());
		
		if(dto.getAddress()==null&&dto.getAddress().trim().length()==0) {
			dto.setAddress("방문");
		}
		
		int num = 0;
		if(!list.isEmpty()&&res>0) {
			dao.insert(dto);
			num = dto.getNum();
			System.out.println(dto.getNum());
			res = 0;
			switch (time) {
			case "time1":
				res = dao.updateSchduleA(sdf.format(dto.getStime()),dto.getDegId(),num);
				break;
			case "time2":
				res = dao.updateSchduleB(sdf.format(dto.getStime()),dto.getDegId(),num);
				break;
			case "time3":
				res = dao.updateSchduleC(sdf.format(dto.getStime()),dto.getDegId(),num);
				break;
			}
		}
		
		ajax.setCnt(res);
		
		
		
		model.addAttribute("ajax", ajax);
		
		
		
	}

}
