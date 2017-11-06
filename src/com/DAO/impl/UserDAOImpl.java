package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.*;
import com.controller.DBConnector;
import com.models.User;

/**
 * 这个文件的每个方法说明在com.DAO.UserDAO中.
 * @author Haojie
 */
public class UserDAOImpl implements UserDAO {
	DBConnector db = new DBConnector();
	Connection conn = db.getConnection();
	
	@Override
	public User getUser(int uid) {
		// TODO
		String sql = "select * from user where uid = ?";
		User u = new User();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				while (rs.next()) {
					u.setName(rs.getString("Uname"));
					u.setPasswd(rs.getString("Upasswd"));
					u.setSex(rs.getString("Usex"));
					u.setHead(rs.getString("Uhead"));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User getUserByUsername(String username) {
		// TODO
		
		return null;
	}
	
	@Override
	public boolean updateUser(User user) {
		// TODO
		return false;
	}
	
	@Override
	public boolean addUser(User user) {
		// TODO
		return false;
	}
}
