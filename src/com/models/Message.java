package com.models;

import java.util.Date;

public class Message {
	private int mid;
	private String topic;
	private Date createtime;
	private String creator;
	
	public Message() {
		
	}
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Message [mid=" + mid + ", topic=" + topic + ", createtime=" + createtime + ", creator=" + creator + "]";
	}

}
