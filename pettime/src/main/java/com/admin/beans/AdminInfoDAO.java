package com.admin.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
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
}
