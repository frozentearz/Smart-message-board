package com.test;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import com.DAO.*;
import com.DAO.impl.MessageDAOImpl;
import com.models.*;

 
public class MessageDAOImplTest {
	public static void main(String[] args) {
 		// TODO Auto-generated method stub
		MessageDAO m=new MessageDAOImpl();
		
//		List list= message.getMessages(1, 20);
//		Message m=new Message();
//		User u=new User();
//		for(int i=0; i<list.size(); i++) {
//			m=(Message) list.get(i);
//			u=(User)m.getCreator();
//			System.out.println(m.toString());
//			System.out.println();
//			System.out.println(u.toString());
//		}
 		//getMessage（int mid）测试
// 		Message mm=m.getMessage(10);           // bug here
// 		
// 		System.out.println(mm.getCreatetime());
 		//getMessage(int offset, int amount)测试
// 		List list=m.getMessages(2, 4);
 		
 		//		System.out.println(list.toString());
 			
 				//getMessage(int uid,int offset,int amount)测试
 		//		List list=m.getMessages(2, 1, 3);
 		//		System.out.println(list.toString());
 		 		
 		 	//	addMessage(message)测试
 				Message message=new Message();
 				message.setMessage("世上无难事");
 				User u=new User();
 				u.setUid(18);
 				message.setCreator(u);
 				System.out.println(m.addMessage(message));
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		java.util.Date now = new java.util.Date(); 
//		String resultDate = sdf.format(now);
//		java.sql.Date date=new Date(System.currentTimeMillis());
//		System.out.println(date);
//		System.out.println(resultDate);
 		
 	}
 
 }