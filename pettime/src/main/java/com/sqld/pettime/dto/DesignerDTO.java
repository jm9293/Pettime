package com.sqld.pettime.dto;

import lombok.Data;

@Data
public class DesignerDTO {
	
	private int num;
	private String id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String intro;
	private char enabled;
}
