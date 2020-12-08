package com.sqld.pettime.user.command;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.ClassPath;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dao.ResDetailDAO;
import com.sqld.pettime.dao.ResListDAO;

import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.dto.ResDetailDTO;
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
		String [] menu = (String[])model.getAttribute("menu");
		HttpServletRequest request =(HttpServletRequest)model.getAttribute("request");

		MultipartFile multipartFile =(MultipartFile)model.getAttribute("photo");
		

		
		
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
		
		if(dto.getAddress()==null||dto.getAddress().trim().length()==0) {
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
			
			ResDetailDAO resdetaildao = DBSession.sqlSession.getMapper(ResDetailDAO.class);
			for (String string : menu) {
				String [] menusplit = string.split("/");
				ResDetailDTO detail = new ResDetailDTO();
				detail.setContent(menusplit[0]);
				detail.setPrice(Integer.parseInt(menusplit[1]));
				detail.setResnum(num);
				res = resdetaildao.insert(detail);
			}
			
		}
	
		ajax.setCnt(res);
		System.out.println(request.getRealPath("/petimg/"));
		File file = new File(request.getRealPath("/petimg/")+num+".jpg"); 
		try {
			if(!file.exists()) {
			multipartFile.transferTo(file);
			}else {
				file.delete();
				multipartFile.transferTo(file);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		model.addAttribute("ajax", ajax);
		
		
		
	}

}
