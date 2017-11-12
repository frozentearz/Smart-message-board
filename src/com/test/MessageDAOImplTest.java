package com.test;

import java.util.List;

import com.DAO.*;
import com.DAO.impl.MessageDAOImpl;
import com.models.*;

 
public class MessageDAOImplTest {
	public static void main(String[] args) {
 		// TODO Auto-generated method stub
		MessageDAO message=new MessageDAOImpl();
		
		List list= message.getMessages(1, 20);
		Message m=new Message();
		User u=new User();
		for(int i=0; i<list.size(); i++) {
			m=(Message) list.get(i);
			u=(User)m.getCreator();
			System.out.println(m.toString());
			System.out.println();
			System.out.println(u.toString());
		}
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