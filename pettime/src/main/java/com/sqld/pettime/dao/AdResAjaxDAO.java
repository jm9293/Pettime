package com.sqld.pettime.dao;


import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sqld.pettime.dto.AdminResDTO;
import com.sqld.pettime.dto.ResDetailDTO;
@MapperScan
public interface AdResAjaxDAO {
	
	public AdminResDTO searchRes(int num);
	public List<AdminResDTO> readRes(String date);
	public int updateListA(String degId, String stime);
	public int updateListB(String degId, String stime);
	public int updateListC(String degId, String stime);
	public int deleteList(int [] num);
	public List<ResDetailDTO> searchDetail(int num);
}
