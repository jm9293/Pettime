package com.sqld.pettime.dao;

import java.util.List;

import com.sqld.pettime.dto.MenuDTO;

public interface MenuDAO {
	
	public List<MenuDTO> selectList();
}
