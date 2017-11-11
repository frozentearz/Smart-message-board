package com.models;

import java.sql.Date;

public class Message {
	private int mid;
	private String message;
	private Date createtime;
	private User creator;
	
	public Message() {
		
	}
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Message [mid=" + mid + ", message=" + message + ", createtime=" + createtime + ", creator=" + creator + "]";
	}

}
