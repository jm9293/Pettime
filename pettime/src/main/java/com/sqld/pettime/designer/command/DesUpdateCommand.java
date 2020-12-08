package com.sqld.pettime.designer.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.sqld.pettime.dao.DesignerDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;
import com.sqld.pettime.util.Fileupload;

public class DesUpdateCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesignerDAO dao = DBSession.sqlSession.getMapper(DesignerDAO.class);
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		String id = (String)model.getAttribute("id");
		dto.setId(id);
		dto.setPassword(DBSession.passwordEncoder.encode(dto.getPassword()));
		MultipartFile photo = (MultipartFile)model.getAttribute("photo");
		HttpServletRequest request = (HttpServletRequest)model.getAttribute("request");
		
		int result = dao.updateMyInfo(dto);
		if(result > 0 && photo != null) {
			Fileupload.proflieImgupload(request, photo, "designerimg", dto.getId());
		}
		model.addAttribute("dto", dto);
	}

}
