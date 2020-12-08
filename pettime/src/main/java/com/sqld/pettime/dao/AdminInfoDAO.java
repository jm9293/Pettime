package com.sqld.pettime.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.sqld.pettime.dto.AdminDTO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.dto.UserDTO;
@MapperScan
public interface AdminInfoDAO {

	public List<UserDTO> selectUserlist();
	public List<UserDTO> selectUserByNum(int userNum);
	public List<DesignerDTO> selectDeslist();
	public List<DesignerDTO> selectDesByNum(int num);
	public int updateDesInfo(int num, @Param("a") DesignerDTO dto);
	public int updateUserInfo(int num, @Param("a") UserDTO dto);
	public int insertDes(@Param("a")DesignerDTO dto);
	public int idChk(String id);
	public int adminIdChk(String id);
	public int emailChk(String email);
	public int grantDes(String degId, String grant);
	public int grantAdmin(String id, String grant);
	public int insertAdmin(@Param("a") AdminDTO dto);
	public List<AdminDTO> selectAdmin();
	public int updatePassword(@Param("a") DesignerDTO dto);
}
