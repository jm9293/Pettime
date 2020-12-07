package com.sqld.pettime.user.beans;

import java.util.List;

public class UserDataJSON {
String status;
	
	int cnt;
	
	List data;
	
	List data2;
	
	public List getData2() {
		return data2;
	}


	public void setData2(List data2) {
		this.data2 = data2;
	}

	int maxpage;
		
	public UserDataJSON() {
		
	}
	 

	public int getMaxpage() {
		return maxpage;
	}


	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
	
	
	
}
