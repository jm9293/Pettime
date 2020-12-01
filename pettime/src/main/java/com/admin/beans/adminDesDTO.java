package com.admin.beans;

import lombok.Data;

@Data
public class adminDesDTO {
	
	private int num;
	private String id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String intro;
	private char enabled;
}
