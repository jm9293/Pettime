package com.admin.beans;


import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
@MapperScan
public interface AdResAjaxDAO {
	
	public AdminResDTO searchRes(int num);
	public List<AdminResDTO> readRes(String date);
	public int updateListA(String degId, String stime);
	public int updateListB(String degId, String stime);
	public int updateListC(String degId, String stime);
	public int deleteList(int [] num);
}
