package com.sqld.pettime.user.beans;



public class UserLoginJSON {
	String status;
	
	String username;
	
	String message;
	
	boolean islogin;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isIslogin() {
		return islogin;
	}

	public void setIslogin(boolean islogin) {
		this.islogin = islogin;
	}
	
	
	
	
	
	
	
}
