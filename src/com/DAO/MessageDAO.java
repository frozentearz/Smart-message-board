package com.DAO;

import java.util.List;

import com.models.Message;

/**
 * 不要修改这个文件的任何内容。这个文件里面的代码，请写到com.DAO.impl.UserMessageImpl里面.
 * @author Haojie
 */
public interface MessageDAO {
	
	/**
	 * 查询所有的留言根据时间排序
	 * @return List<Message>
	 */
	public List<Message> getMessage();
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
	 * @return 一个消息列表. 如果数据库是空的，则返回一个空列表(不是单纯返回null).
	 */
	public List<Message> getMessages(int offset, int amount);
	
	/**
	 * 根据一个用户的id，查找属于该用户指定范围内的所有消息.
	 * @param userId 用户id.
	 * @param offset 从第offset条消息开始.
	 * @param amount 往后查找amount条.
	 * @return 一个消息列表. 如果查不到该用户的任何数据，则返回一个空列表(不是单纯返回null).
	 */
	public List<Message> getMessages(int userId, int offset, int amount);
	
	/**
	 * 根据mid删除一条消息.
	 * @param mid 消息id.
	 * @return 删除成功的话返回true, 否则返回false.
	 */
	public boolean deleteMessage(int mid);
	
	/**
	 * 更新一条消息的内容.
	 * @param message 消息.
	 * @return 更新成功的话返回true, 否则返回false.
	 */
	public boolean updateMessage(Message message);
	
	/**
	 * 往数据库里添加一条新的消息. 
	 * @param message 需要添加的消息的具体内容.
	 * @return 添加成功的话返回true, 否则返回false.
	 */
	public boolean addMessage(Message message);
	
	/**
	 * 统计一下整个数据库一共有多少条消息.
	 * @return 数据库总共的消息数量.
	 */
	public int countTotalMessages();
}
