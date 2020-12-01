package com.admin.beans;


import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
@MapperScan
public interface adResAjaxDAO {
	
	public List<adminResDTO> searchRes();
	public List<adminResDTO> readRes(String date);
}
