package com.sqld.pettime.dao;

import org.apache.ibatis.annotations.Param;

import com.sqld.pettime.dto.UserDTO;

public interface UserDAO {
	int idchk(String id);
	int emailchk(String email);
	int insert(@Param("dto") UserDTO dto);
	int grantUser(String id);
	UserDTO selectById(String id);
	int update(@Param("dto") UserDTO dto);
}
