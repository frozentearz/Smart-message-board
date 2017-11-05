package com.DAO.impl;

import java.util.List;

import com.DAO.MessageDAO;
import com.models.Message;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public Message getMessage(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessages(int offset, int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessages(int userId, int offset, int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMessage(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

}
