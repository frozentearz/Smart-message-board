package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/smartboard?useUnicode=true&characterEncoding=utf8";
	private static String username="smart";
	private static String password="smart";
	static Connection conn;	
	/**
	 * �������ݿ�
	 * @author Gavin
	 * ʱ�� 2017/11/3
	 * version 1.0
	 */
	public static Connection getConnection(){
		try {
			Class.forName(driver);
		    System.out.println("���������ɹ�");
		    conn = DriverManager.getConnection(url, username, password);
		    System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}	
}