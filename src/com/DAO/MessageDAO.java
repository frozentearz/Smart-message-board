package com.DAO;

import java.util.List;

import com.models.Message;

public interface MessageDAO {
	/**
	 * 根据mid查找相应的消息.
	 * @param mid 消息id.
	 * @return 返回找到的信息。如果没有相应的信息，返回null.
	 */
	public Message getMessage(int mid);
	
	/**
	 * 根据一个搜索范围，查找一个消息列表.
	 * @param offset 例如：offset=5，表示从第5条消息开始查找.
	 * @param amount 例如：amount=10，一共找10条消息.
	 * @return 一个消息列表. 如果数据库是空的，则返回一个空列表.
	 */
	public List<Message> getMessages(int offset, int amount);
	
	public List<Message> getMessages(int userId, int offset, int amount);
	
	public boolean deleteMessage(int mid);
	
	public boolean updateMessage(Message message);
	
	public boolean addMessage(Message message);
	
}
