package com.test;

import com.controller.Factory;
import com.models.User;

public class FactoryTest {
	public static void main(String[] args) {
		Factory factory=new Factory();
		User u = new User();
		u.setName("Xiao");
		u.setPasswd("test123456");
		u.setSex("F");
		u.setHead("https://avatars0.githubusercontent.com/u/18512486?s=460&v=4");
		
		System.out.println(factory.registerUser(u));
	}
}