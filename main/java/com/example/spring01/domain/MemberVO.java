package com.example.spring01.domain;

import java.sql.Date;

public class MemberVO {

	/*
	 	create table member(
			uno int primary key auto_increment,
			userId varchar(50) not null,
			userPass varchar(50) not null,
			userName varchar(50) not null,
			phone varchar(50),
			mail varchar(50),
			regdate timestamp default now(),
			verify int default 0);
	 */
	
	private int uno;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	private String userId;
	private String userPass;
	private String userName;
	private String phone;
	private String mail;
	private Date regDate;
	private int verify;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}  
	
}
