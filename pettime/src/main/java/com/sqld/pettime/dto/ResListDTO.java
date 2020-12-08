package com.sqld.pettime.dto;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class ResListDTO {
	
	private int num;
	private Timestamp stime;
	private String address;
	private String userId;
	private String degId;
	private String petName;
	private String petKind;
	private String petMemo;
	private int tPrice;
	private String state;
	
	
}
