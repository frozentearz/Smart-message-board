package com.test;

import com.controller.DBConnector;

public class TestJDBC {
	public static void main(String[] args) {
	    DBConnector db = new DBConnector();
	    db.getConnection();
	}
}
