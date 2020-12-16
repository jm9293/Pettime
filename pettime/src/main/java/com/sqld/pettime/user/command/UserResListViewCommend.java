package com.sqld.pettime.user.command;



import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesignerDAO;
import com.sqld.pettime.dao.ResDetailDAO;
import com.sqld.pettime.dao.ResListDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.dto.ResDetailDTO;
import com.sqld.pettime.dto.ResListDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserResListViewCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<ResListDTO> list = null;
		UserDataJSON ajax = new UserDataJSON();
		String id = (String)model.getAttribute("id");
		ResListDAO dao = DBSession.sqlSession.getMapper(ResListDAO.class);
		ResDetailDAO dao2 = DBSession.sqlSession.getMapper(ResDetailDAO.class);
		DesignerDAO dao3 =  DBSession.sqlSession.getMapper(DesignerDAO.class);
		
		list = dao.selectByUidandID(id,(int)model.getAttribute("uid"));
		List<ResDetailDTO> list2 =dao2.searchDetail(list.get(0).getNum());
		DesignerDTO designer = dao3.selectMyInfo(list.get(0).getDegId());
		list.get(0).setDegId(designer.getName());
		if(list.isEmpty()||list2.isEmpty()) {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			ajax.setData(null);
		}else {
			
			ajax.setStatus("OK");
			ajax.setCnt(list.size());
			ajax.setData(list);
			ajax.setData2(list2);
		}
		
		
		model.addAttribute("ajax", ajax);
		
		
		
	}

}
