package src.com.DAO.impl;

import java.util.List;

import src.com.DAO.MessageDAO;
import src.com.models.Message;

/**
 * 这个文件的每个方法说明在com.DAO.MessageDAO中.
 * @author Haojie
 */
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

	@Override
	public int countTotalMessages() {
		// TODO Auto-generated method stub
		return 0;
	}

}
