package com.DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.MessageDAO;
import com.controller.DBConnector;
import com.models.*;

/**
 * 这个文件的每个方法说明在com.DAO.MessageDAO中.
 * @author Haojie
 */
public class MessageDAOImpl implements MessageDAO {
	DBConnector db = new DBConnector();
	Connection conn = db.getConnection();
	
	@Override
	public Message getMessage(int mid) {
		// TODO Auto-generated method stub
    String sql = "select * from message where mid = ?;";
    Message m = new Message();
    try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(mid));
		//	    createtime datetime not null,
		//	    creatorID int not null,
		//	    FOREIGN KEY (creatorID) REFERENCES user(UID)
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			m.setMid(rs.getInt(1));
			m.setMessage(rs.getString("Message"));
			m.setCreatetime(rs.getDate("createtime"));
			//
		} else {
			return null;
		}
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	   return m;
	}

	@Override
	public List<Message> getMessages(int offset, int amount) {
		// TODO Auto-generated method stub
		String sql="select top 20 * from message where MID between ? and ?";
		List<Message> list=new ArrayList();
		Message m = new Message();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, amount);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setMid(rs.getInt(1));
				m.setMessage(rs.getString("Message"));
				m.setCreatetime(rs.getDate("createtime"));
				//
				list.add(m);
			} 
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Message> getMessages(int userId, int offset, int amount) {
		// TODO Auto-generated method stub
		String sql="select top 20 * from message where ceratorID=? and ( MID between ? and ?)";
		List<Message> list=new ArrayList();
		Message m = new Message();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(userId));
			pstmt.setInt(2, offset);
			pstmt.setInt(3, amount);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setMid(rs.getInt(1));
				m.setMessage(rs.getString("Message"));
				m.setCreatetime(rs.getDate("createtime"));
				//
				list.add(m);
			} 
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public boolean deleteMessage(int mid) {
		// TODO Auto-generated method stub
		String sql="delete message where MID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		String sql="update message set Message=?,createtime=? where MID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getMessage());
			pstmt.setDate(2, (Date) message.getCreatetime());
			pstmt.setInt(3, message.getMid());
			if(pstmt.executeUpdate()<0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		String sql="insert into message values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getMid());
			pstmt.setString(2, message.getMessage());
			pstmt.setDate(3, (Date) message.getCreatetime());
		//	pstmt.setInt(4, message.getCreator());
			if(pstmt.executeUpdate()<0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public int countTotalMessages() {
		// TODO Auto-generated method stub
		int countTotal=0;
		String sql="select count(*) from message";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				countTotal=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countTotal;
	}

}