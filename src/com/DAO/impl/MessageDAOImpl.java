package com.DAO.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.*;
import com.controller.DBConnector;
import com.models.*;

/**
 * 这个文件的每个方法说明在com.DAO.MessageDAO中.
 * @author Haojie
 */
public class MessageDAOImpl implements MessageDAO {
	
	@Override
	public List<Message> getMessages(){
		List list = new ArrayList();
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m.MID,m.message,m.createTime,u.UID,u.Uname,u.Uhead from message as m join user as u on m.creatorId=u.UID order by createTime desc;";
	    try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Message m = new Message();
				User u=new User();
				m.setMid(rs.getInt(1));
				m.setMessage(rs.getString("Message"));
				m.setCreatetime(rs.getTimestamp("createtime"));
				u.setUid(rs.getInt("UID"));
				u.setName(rs.getString("Uname"));
				u.setHead(rs.getString("Uhead"));
				m.setCreator(u);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@Override
	public Message getMessage(int mid) {
		// TODO Auto-generated method stub
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m.MID,m.message,m.createTime,u.UID,u.Uname,u.Uhead from message as m join user as u on m.creatorId=u.UID where mid = ? order by ctreatetime desc;";
		Message m = new Message();
	    try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setMid(rs.getInt(1));
				m.setMessage(rs.getString("Message"));
				m.setCreatetime(rs.getTimestamp("createtime"));
//				m.getCreator().setUid(rs.getInt("creatorId"));
//				m.setCreatetime(rs.getDate("createTime"));
				User u=new User();
				u.setUid(rs.getInt("UID"));
				u.setName(rs.getString("Uname"));
				u.setHead(rs.getString("Uhead"));
				m.setCreator(u);
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
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		   return m;
	}

	@Override
	public List<Message> getMessages(int offset, int amount) {
		// TODO Auto-generated method stub
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from (select m.MID, m.Message,m.createTime,u.UID,u.Uname,u.Uhead from message as m join user as u on creatorId=UID order by createtime desc ) as m limit ?,?;";
		List<Message> list=new ArrayList<Message>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, amount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Message m = new Message();
				User u = new User();
				m.setMid(rs.getInt(1));
				m.setMessage(rs.getString("Message"));
				m.setCreatetime(rs.getTimestamp("createtime"));
				u.setUid(rs.getInt("UID"));
				u.setName(rs.getString("Uname"));
				u.setHead(rs.getString("Uhead"));
				m.setCreator(u);
				list.add(m);
			} 
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Message> getMessages(int userId, int offset, int amount) {
		// TODO Auto-generated method stub
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from (select MID, Message,createtime,UId,Uname,Uhead from message join user on creatorID = UId where UId=? order by createtime desc) as m limit ?,?;";
		List<Message> list=new ArrayList<Message>();
		User u=new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, offset);
			pstmt.setInt(3, amount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Message m = new Message();
				m.setMid(rs.getInt("MID"));
				m.setMessage(rs.getString("Message"));
				m.setCreatetime(rs.getTimestamp("createTime"));
				if(u.getUid()==0) {
					u.setUid(rs.getInt("UID"));
					u.setName(rs.getString("Uname"));
					u.setHead(rs.getString("Uhead"));
				}
				m.setCreator(u);
				list.add(m);
			} 
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean deleteMessage(int mid) {
		// TODO Auto-generated method stub
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql="delete from message where MID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql="update message set message=?,createtime=now() where MID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getMessage());
			pstmt.setInt(3, message.getMid());
			if(pstmt.executeUpdate()<0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql="insert into message(message, createtime, creatorID) values(?,now(),?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getMessage());
			pstmt.setInt(2, message.getCreator().getUid()); //这个这样写
			if(pstmt.executeUpdate()<0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public int countTotalMessages() {
		// TODO Auto-generated method stub
		Connection conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int countTotal=0;
		String sql="select count(*) from message";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				countTotal=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return countTotal;
	}

}