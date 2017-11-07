package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.controller.DBConnector;
import com.models.User;

import com.DAO.*;

/**
 * 这个文件的每个方法说明在com.DAO.UserDAO中.
 * @author Haojie
 */
public class UserDAOImpl implements UserDAO {
	DBConnector db = new DBConnector();
	Connection conn = DBConnector.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public User getUser(int uid) {
		// TODO
		String sql = "select * from user where uid = ?;";
		User u = new User();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				u.setName(rs.getString("Uname"));
				u.setPasswd(rs.getString("Upasswd"));
				u.setSex(rs.getString("Usex"));
				u.setHead(rs.getString("Uhead"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return u;
	}
	
	@Override
	public User getUserByUsername(String username) {
		// TODO
		String sql = "select * from user where Uname = ?;";
		User u = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u.setUid(rs.getInt("UID"));
				u.setPasswd(rs.getString("Upasswd"));
				u.setSex(rs.getString("Usex"));
				u.setHead(rs.getString("Uhead"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return u;
	}
	
	@Override
	public boolean updateUser(User user) {
		// TODO
		boolean flag = false;
		String sql = "update user set Uname = ?, Upasswd = ?, Usex = ?, Uhead = ? where UID = ?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getHead());
			pstmt.setInt(5, user.getUid());
			if (pstmt.executeUpdate()>0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		} finally {
			db.closeConnection();
		}
		return flag;
	}
	
	@Override
	public boolean addUser(User user) {
		// TODO
		String sql = "insert into user(UID, Uname, Upasswd, Usex, Uhead) values(?, ?, ?, ?, ?);";
		boolean flag = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUid());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getHead());
			if (pstmt.executeUpdate()>0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		} finally {
			db.closeConnection();
		}
		return flag;
	}
}
