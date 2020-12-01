package com.admin.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
@MapperScan
public interface adminInfoDAO {

	public List<adminUserDTO> selectUserlist();
	public List<adminUserDTO> selectUserByNum(int userNum);
	public List<adminDesDTO> selectDeslist();
	public List<adminDesDTO> selectDesByNum(int num);
	public int updateDesInfo(int num, @Param("a") adminDesDTO dto);
	public int updateUserInfo(int num, @Param("a") adminUserDTO dto);
	public int insertDes(@Param("a")adminDesDTO dto);
}
