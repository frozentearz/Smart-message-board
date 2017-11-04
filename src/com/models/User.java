package com.models;

public class User {
	private int uid;
	private String name;
	private String passwd;
	private String sex;  
	private String head; //头像（使用连接地址）
	
	public User() {
		
	}
	
	public int getUid() {
		return this.uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", passwd=" + passwd + ", sex=" + sex + ", head=" + head + "]";
	}

}
