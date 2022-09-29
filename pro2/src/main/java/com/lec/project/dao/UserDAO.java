package com.lec.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.db.JDBCUtil;
import com.lec.project.vo.UserVO;



public class UserDAO {
	
	private UserDAO () {};
	private static UserDAO userDAO;
	public static UserDAO getInstance() {
		if(userDAO == null) userDAO = new UserDAO();
		return userDAO;
	}
	
	Connection conn = null; 
	
	public void setConnection(Connection conn) {
		this.conn= conn;
	}
	
	public int createUser(UserVO user) {
		
		
		int createCount = 0;
		
		PreparedStatement pstmt = null; 
		
		String sql = "insert into user( user_id "
										+",user_pw    "
										+",user_name  "
										+",user_phone "
										+",user_gender"
										+",user_email "
										+",user_joind )"
							+" value(?,?,?,?,?,?, now())";
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pw());
			pstmt.setString(3, user.getUser_name());
			pstmt.setString(4, user.getUser_phone());
			pstmt.setString(5, user.getUser_gender());
			pstmt.setString(6, user.getUser_email());
			
			createCount = pstmt.executeUpdate();
			
			sql = "insert into user_address(user_id"
										+ ",user_addr1"
										+ ",user_addr2"
										+ ",user_addr3 )"
										+ " value(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_addr1());
			pstmt.setString(3, user.getUser_addr2());
			pstmt.setString(4, user.getUser_addr3());
			createCount *= pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, null);
			
		}		
		return createCount;
	}

	
	
	public UserVO loginUser(String user_id, String user_pw) {
		
		boolean loginSuccess = false;
		UserVO user = new UserVO();
		
		
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String sql = "select u.user_id"
				+ ",u.user_pw"
				+ ",u.user_name"
				+ ",u.user_phone"
				+ ",u.user_gender"
				+ ",u.user_email"
				+ ",u.user_joind"
				+ ",a.user_addr1"
				+ ",a.user_addr2"
				+ ",a.user_addr3"
				+ " from user u , user_address a  where u.user_id = a.user_id and u.user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(user_pw.equals(rs.getString("user_pw"))) {
					
				loginSuccess = true;
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_joind(rs.getString("user_joind"));
				user.setUser_addr1(rs.getString("user_addr1"));
				user.setUser_addr2(rs.getString("user_addr2"));
				user.setUser_addr3(rs.getString("user_addr3"));
				
				}
			} else {
				user = null;
				System.out.println("비밀번호가 일치하지 않습니다. 다시 확인하세요.");
			}
			
		} catch (SQLException e) {
			System.out.println("비밀번호가 일치하지 않습니다. 다시 확인하세요." + e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		
		
		
		
		return user;
	}

	public int updateUser(UserVO userT) {
		
		int updateCount =0;
		int updateCount1 =0;
		PreparedStatement pstmt = null; 
		String sql = "update user set user_phone = ? where user_id = ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userT.getUser_phone());
			pstmt.setString(2, userT.getUser_id());
			updateCount1 = pstmt.executeUpdate();
			
			if(updateCount1 > 0) {
				sql = "update user_address "
						+ "set user_addr1 = ?"
						+ " ,user_addr2 = ?"
						+ " ,user_addr3 = ?"
						+ " where user_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userT.getUser_addr1());
				pstmt.setString(2, userT.getUser_addr2());
				pstmt.setString(3, userT.getUser_addr3());
				pstmt.setString(4, userT.getUser_id());
				updateCount = pstmt.executeUpdate();
				
			}
			
			
			
			
		} catch (SQLException e) {
			System.out.println("비밀번호가 일치하지 않습니다. 다시 확인하세요." + e.getMessage());

		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		
		
		return updateCount;
	}

	
	
	
	
	
	
	
	
	
}
