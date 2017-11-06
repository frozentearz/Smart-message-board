package com.test;

import com.DAO.impl.UserDAOImpl;
import com.models.User;

/**
 * @author Frazier
 *	测试UserDAOImpl类
 */
public class UserDAOImplTest {
	static UserDAOImpl uDAOImpl = new UserDAOImpl();
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//不要直接执行，先看下方各个方法，修改变量后再测试。
		addUserTest();
		getUserByUsernameTest();
		updateUserTest();
		GetUserTest();
	}
	
	/**
	 *  测试 getUser()
	 */
	private static void GetUserTest() {
		// TODO 自动生成的方法存根
		User u = new User();
		u = uDAOImpl.getUser(1);
		if (u != null) {
			System.out.println(u.getName());
			System.out.println(u.getPasswd());
			System.out.println(u.getSex());
			System.out.println(u.getHead());
		} else {
			System.out.println("数据库无此数据！");
		}
	}
	
	/**
	 *  测试 getUserByUsername()
	 */
	private static void getUserByUsernameTest() {
		// TODO 自动生成的方法存根
		User u = new User();
		u = uDAOImpl.getUserByUsername("");
		if (u != null) {
			System.out.println(u.getUid());
			System.out.println(u.getPasswd());
			System.out.println(u.getSex());
			System.out.println(u.getHead());
		} else {
			System.out.println("数据库无此数据！");
		}
	}
	
	/**
	 * 测试 updateUser()
	 */
	private static void updateUserTest() {
		// TODO 自动生成的方法存根
		User u = new User();
		u.setName("frazier");
		u.setHead("https://avatars0.githubusercontent.com/u/18512486?s=460&v=4");
		u.setPasswd("Frazier");
		u.setSex("男");
		u.setUid(1);
		if (uDAOImpl.updateUser(u)) {
			System.out.println("数据修改成功！");
		} else {
			System.out.println("数据修改失败！");
		}
	}
	
	/**
	 *  测试 addUser()
	 */
	private static void addUserTest() {
		User u = new User();
		u.setName("邹豪");
		u.setHead("https://avatars0.githubusercontent.com/u/18512486?s=460&v=4");
		u.setPasswd("zouhao");
		u.setSex("M");
		u.setUid(1);
		if (uDAOImpl.addUser(u)) {
			System.out.println("增加成功！");
		} else {
			System.out.println("增加失败！");
		}
	}

}
