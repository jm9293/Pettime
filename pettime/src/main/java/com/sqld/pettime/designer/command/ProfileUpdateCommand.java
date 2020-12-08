package com.sqld.pettime.designer.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.sqld.pettime.dao.DesignerDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;
import com.sqld.pettime.util.Fileupload;

public class ProfileUpdateCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesignerDAO dao = DBSession.sqlSession.getMapper(DesignerDAO.class);
		String id = (String)model.getAttribute("id");
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		dto.setId(id);
		MultipartFile photo = (MultipartFile)model.getAttribute("photo");
		DesignerDTO origin = dao.selectMyInfo(id);
		System.out.println(origin.getEmail());
		HttpServletRequest request = (HttpServletRequest)model.getAttribute("request");
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
		if(result>0 && photo!=null) {
			Fileupload.proflieImgupload(request, photo, "designerimg", dto.getId());
		}
		model.addAttribute("result", result);
		System.out.println(dto);
		
		
		
		
	}

}
