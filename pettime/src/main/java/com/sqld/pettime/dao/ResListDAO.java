package com.sqld.pettime.dao;

import java.util.List;


import org.mybatis.spring.annotation.MapperScan;

import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.dto.ResListDTO;
@MapperScan
public interface ResListDAO {
	List<DesignerDTO> callDesignersA(String date);
	List<DesignerDTO> callDesignersB(String date);
	List<DesignerDTO> callDesignersC(String date);
	List<DesignerDTO> callDesignersAbyID(String date, String id);
	List<DesignerDTO> callDesignersBbyID(String date, String id);
	List<DesignerDTO> callDesignersCbyID(String date, String id);
	
	int updateSchduleA(String date, String id ,int num);
	int updateSchduleB(String date, String id ,int num);
	int updateSchduleC(String date, String id ,int num);
	
	int insertDayschdule(String date, String degid);
	
	int insert(ResListDTO dto);
	
	int maxcnt();
	
	ResListDTO searchRes(int num);
	
	
	
}
