package com.lec.project.dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.db.JDBCUtil;
import com.lec.project.vo.CartVO;
import com.lec.project.vo.UserVO;

public class CartDAO {
	
	private CartDAO () {};
	private static CartDAO cartDAO;
	public static CartDAO getInstance() {
		if(cartDAO == null) cartDAO = new CartDAO();
		return cartDAO;
	}
	
	Connection conn = null; 
	
	public void setConnection(Connection conn) {
		this.conn= conn;
	}

	public int insertCart(UserVO user, int pro_num) {
		
		int cartAddCount = 0;

		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String sql ="select * from cart where user_id= ? and pro_num = ? ";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setInt(2, pro_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt(4);
				sql = "update cart set pro_count = ? where user_id=? and pro_num=? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, count+1);
				pstmt.setString(2, user.getUser_id());
				pstmt.setInt(3, pro_num);
				cartAddCount = pstmt.executeUpdate();			
				
			} else {
				
				sql = "INSERT INTO cart(user_id,pro_num,pro_count) VALUES(? ,?, 1) ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUser_id());
				pstmt.setInt(2, pro_num);
				cartAddCount = pstmt.executeUpdate();
				
			}
			
		
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		
		
		
		return cartAddCount;
	}

	public ArrayList<CartVO> selectCartList(String user_id) {
		
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		
		PreparedStatement pstmt = null; 
		ResultSet rs = null ;
		
//		String sql = "select * from cart where user_id = ? ";
		String sql = "SELECT c.user_id, p.pro_num ,p.pro_name, c.pro_count, p.pro_price from cart c, product p"
					+" where c.pro_num = p.pro_num and user_id = ? ";	
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartVO cart = new CartVO();
				cart.setUser_id(rs.getString("user_id"));
				cart.setPro_name(rs.getString("pro_name"));
				cart.setPro_num(rs.getInt("pro_num"));
				cart.setPro_count(rs.getInt("pro_count"));
				cart.setPro_price(rs.getInt("pro_price"));
				cartList.add(cart);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		
		
		
		
		return cartList;
	}

	public boolean deleteCart(UserVO user) {
		
		boolean isReset = false;
		
		PreparedStatement pstmt = null; 
		String sql = "delete from cart where user_id = ? ";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,user.getUser_id());
			int deleteCount = pstmt.executeUpdate();
			
			if(deleteCount>0) isReset = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		
		
		return isReset;
	}
	
}
