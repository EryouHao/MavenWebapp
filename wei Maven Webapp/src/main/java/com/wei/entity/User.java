package com.wei.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

//	编码；名称，备注；状态；创建时间；最后登录时间;账号类型
	
	private int id;
	private String account;  
	private String name;
	private String nickname;
	private String password;
	private int state;                   // 0 是正常  1 是封号
	private Date createdate;
	private Date lastlogindate;
	private int type;                    //0 是学生 1是老师
	
	
	
	public User() {
		super();
	}
	public User(String account, String name, String nickname, String password,
			int state, Date createdate, int type) {
		super();
		this.account = account;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.state = state;
		this.createdate = createdate;
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getLastlogindate() {
		return lastlogindate;
	}
	public void setLastlogindate(Date lastlogindate) {
		this.lastlogindate = lastlogindate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
	
	
	
	
}
