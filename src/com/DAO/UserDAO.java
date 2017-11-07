package src.com.DAO;

import src.com.models.User;

/**
 * 不要修改这个文件的任何内容。这个文件里面的代码，请写到com.DAO.impl.UserDAOImpl里面.
 * @author Haojie
 */
public interface UserDAO {
	/**
	 * 根据一个user的uid，查找这个user.
	 * @param uid
	 * @return 返回一个完整的User对象. 如果该用户不存在，则返回null.
	 */
	public User getUser(int uid);
	
	/**
	 * 根据用户名，查找相应的用户.
	 * @param username 用户名.
	 * @return 一个User对象. 如果该用户不存在，则返回null.
	 */
	public User getUserByUsername(String username);
	
	/**
	 * 修改一个用户的信息.
	 * @param user
	 * @return 如果修改成功，返回true.
	 */
	public boolean updateUser(User user);
	
	/**
	 * 往数据库里面添加一个新的User.
	 * @param user
	 * @return 如果添加成功，返回true.
	 */
	public boolean addUser(User user);
	
}
