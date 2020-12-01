package com.admin.command;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.ui.Model;

import com.admin.beans.adResAjaxDAO;
import com.admin.beans.adminResDTO;
import com.admin.common.C;

public class adResListCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		adResAjaxDAO dao = C.sqlSession.getMapper(adResAjaxDAO.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<adminResDTO> dto = dao.searchRes();
		for (int i = 0; i < dto.size(); i++) {
			sdf.format(dto.get(i).getStime());
		}
		
		model.addAttribute("list", dto);

	}

}
