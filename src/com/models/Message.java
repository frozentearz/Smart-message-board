package com.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private int mid;
	private String message;
	private Timestamp createtime;
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

	public String getCreatetime() {
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm" );
 		String s = sdf.format(createtime);
		return s;
	}
	public void setCreatetime(Timestamp timestamp) {
		this.createtime = timestamp;
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
