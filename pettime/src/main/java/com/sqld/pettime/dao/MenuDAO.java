package com.sqld.pettime.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.sqld.pettime.dto.MenuDTO;
@MapperScan
public interface MenuDAO {
	
	public List<MenuDTO> selectList();
	public MenuDTO selectNum(int num);
	public int addMenu(String subject, int price);
	public int updateMenu(@Param("a") MenuDTO dto);
	public int deleteMenu(int num);
}
