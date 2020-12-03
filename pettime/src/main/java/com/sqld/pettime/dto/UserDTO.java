package com.sqld.pettime.dto;

import lombok.Data;

@Data
public class UserDTO {
	private int userNum;
	private String id;
	private String name;
	private String phone;
	private String email;
	private char enabled;
}
