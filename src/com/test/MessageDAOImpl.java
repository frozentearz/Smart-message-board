package com.test;

import java.util.List;
import java.sql.Date;

import com.models.*;
import com.DAO.*;
 
public class MessageDAOImpl {
	static MessageDAOImpl mDAOImpl = new MessageDAOImpl();
	public static void main(String[] args) {
 		// TODO Auto-generated method stub
		
 		//getMessage（int mid）测试
// 		Message mm=mDAOImpl.getMessage(2);           // bug here
// 		System.out.println(mm.getMessage());
 		//getMessage(int offset, int amount)测试
// 		List list=m.getMessages(2, 4);
 		
 		//		System.out.println(list.toString());
 			
 				//getMessage(int uid,int offset,int amount)测试
 		//		List list=m.getMessages(2, 1, 3);
 		//		System.out.println(list.toString());
 		 		
 		 		//addMessage(message)测试
 		//		Message message=new Message();
 		//		message.setMessage("Hello");
 		//		Date currentDate = new Date(System.currentTimeMillis());
 		//		message.setCreatetime(currentDate);
 		//		User u=new User();
 		//		u.setUid(2);
 		//		message.setCreator(u);
 		//		System.out.println(m.addMessage(message));
 		
 	}
 
 }