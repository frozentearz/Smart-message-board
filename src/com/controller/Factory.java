package src.com.controller;

import java.util.List;

import src.com.DAO.MessageDAO;
import src.com.DAO.UserDAO;
import src.com.DAO.impl.MessageDAOImpl;
import src.com.DAO.impl.UserDAOImpl;
import src.com.models.Message;
import src.com.models.User;

/**
 * 抽象工厂.
 * 前端JSP会直接跟这个类做交流。也就是说，前端的所有信息，如果想要操作DAO
 * 的话，都必须通过这个类来做验证。通过验证，才能正常使用DAO.
 * 因为这个类就像一个大工厂一样，提供了前端所需要的所有服务，所以我们把这个类
 * 称为抽象工厂.
 */
public class Factory {
	
	private UserDAO userDAO;
	private MessageDAO messageDAO;
	
	public Factory() {
		this.userDAO = new UserDAOImpl();
		this.messageDAO = new MessageDAOImpl();
	}
	
	/**
	 * 用户登陆.
	 * @param username 用户名.
	 * @param passowrd 密码.
	 * @return 成功的话，返回一个完整的User对象. 否则返回null.
	 */
	public User login(String username, String password) {
		// TODO
		UserDAOImpl udi=new UserDAOImpl();
		User u=udi.getUserByUsername(username);
		if( !( username.equals(u.getName() ) && password.equals(u.getPasswd() ) ) ) {
			return null;
		}
		return u;
	}
	
	/**
	 * 注册新用户. 注册的时候，需要判断一下信息的正确性.
	 * 新的注册用户，名字不能和系统里面任何一个用户的名字一样.
	 * 密码的长度必须在5位以上，并且不超过15位.
	 * @param user 一个新的用户.
	 * @return 成功的话，返回一个完整的User对象. 否则返回null.
	 */
	public User registerUser(User user) {
		// TODO
		UserDAOImpl udi=new UserDAOImpl();
		if(udi.getUserByUsername(user.getName())==null
				&& !(user.getPasswd().length()>5 && user.getPasswd().length()<=15)) {
			
			return null;
		}
		udi.addUser(user);
		return user;
	}
	
	/**
	 * 查看用户信息.
	 * @param userid 用户id.
	 * @return 用户信息.
	 */
	public User getUserProfile(int userid) {
		// TODO
		UserDAOImpl udi=new UserDAOImpl();
		User u=udi.getUser(userid);
		return u;
	}
	
	/**
	 * 在数据库中查找一条信息.
	 * @param mid 消息的id.
	 * @return 这条消息. 如果消息不存在，则返回null.
	 */
	public Message getMessage(int mid) {
		// TODO
		MessageDAOImpl mdi=new MessageDAOImpl();
		Message m=mdi.getMessage(mid);
		return m;
	}

	/**
	 * 修改一条消息的内容.
	 * @param message 新的消息.
	 * @return 新修改过的消息. 如果修改失败，返回null.
	 */
	public Message updateMessage(Message message) {
		// TODO
		MessageDAOImpl mdi=new MessageDAOImpl();
		return mdi.updateMessage(message)?message:null;
	}
	
	/**
	 * 获取一整页的消息.
	 * 我们的网站上规定，每一页显示20条消息. 这个函数是用来获取第n页
	 * 的所有消息. 例如：当n=1时，返回从第1到第20条消息的列表.
	 * @param n 第n页.
	 * @return 一个消息列表.
	 */
	public List<Message> getMessagesAtPage(int n) {
		// TODO
		MessageDAOImpl mdi=new MessageDAOImpl();	
		List<Message> list=mdi.getMessages(n==1?n:n*10+1, n*10+19);
		return list;
	}
	
	/**
	 * 统计一下整个数据库一共有多少条消息.
	 * @return 数据库总共的消息数量.
	 */
	public int countTotalMessages() {
		// TODO
		MessageDAOImpl mdi=new MessageDAOImpl();
		return mdi.countTotalMessages();
	}
	
	/**
	 * 统计一下整个数据库的消息一共可以分成多少页.
	 * @return 返回总共的页数.
	 */
	public int countTotalPages() {
		// TODO
		MessageDAOImpl mdi=new MessageDAOImpl();	
		return  countTotalMessages()%20==0?countTotalMessages()/20:(countTotalMessages()/20)+1;
	}
	
}
