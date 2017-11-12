package com.test;

import com.controller.Factory;
import com.models.User;

public class FactoryTest {
	public static void main(String[] args) {
		Factory factory=new Factory();
		User u = new User();
		u.setName("不见");
		u.setPasswd("111111");
		u.setSex("F");
		u.setHead("img//avatar//avater_01.jpg");
		System.out.println(factory.registerUser(u));
	}
}