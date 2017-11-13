package com.test;

import com.controller.Factory;
import com.models.User;

public class FactoryTest {
	public static void main(String[] args) {
		Factory factory=new Factory();
		User u = new User();
		u.setName("GGG");
		u.setPasswd("111111");
		u.setSex("F");
		u.setHead("img//avatar//avater_01.jpg");
		u.setUid(26);
		System.out.println(factory.UpdateUser(u));
	}
}