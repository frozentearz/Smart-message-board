package com.test;

import java.util.List;

import com.controller.Factory;
import com.models.Message;
import com.models.User;

public class FactoryTest {
	public static void main(String[] args) {
		Factory factory=new Factory();
//		User u = new User();
		int num=factory.countTotalMessages(2);
		
		System.out.println(num);
	}
}