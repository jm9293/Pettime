package com.sqld.pettime.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ResListDTO {
	
	private int num;
	private Date stime;
	private String address;
	private String userId;
	private String degId;
	private String petName;
	private String petKind;
	private String petMemo;
	private int tPrice;
	private String state;
	
	
}
