package com.test;

import java.util.List;

import com.controller.Factory;
import com.models.Message;
import com.models.User;

public class FactoryTest {
	public static void main(String[] args) {
		Factory factory=new Factory();
//		User u = new User();
		List<Message> list=factory.getMessagesAtPage(0);
		
		System.out.println(list.size());
	}
}