package com.sqld.pettime.dao;

import org.apache.ibatis.annotations.Param;

import com.sqld.pettime.dto.DesignerDTO;

public interface DesignerDAO {
	
	public DesignerDTO selectMyInfo(String id);
	public int updateMyInfo(@Param("a") DesignerDTO dto);
	DesignerDAO selectById(String id);
	
}
