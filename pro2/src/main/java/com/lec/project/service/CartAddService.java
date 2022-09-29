package com.lec.project.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.project.dao.CartDAO;
import com.lec.project.vo.CartVO;
import com.lec.project.vo.UserVO;

public class CartAddService {
	
	public boolean addCart(UserVO user, int pro_num) {
		
		boolean isCartAddSuccess = false;
		
		int cartAddCount = 0;
		Connection conn = JDBCUtil.getConnection();
		CartDAO cartDAO = CartDAO.getInstance();
		cartDAO.setConnection(conn);
		
		cartAddCount = cartDAO.insertCart(user,pro_num);
		
		if(cartAddCount >0) {
			JDBCUtil.commit(conn);
			isCartAddSuccess = true;
		} else {
			JDBCUtil.rollback(conn);
		}
		JDBCUtil.close(conn, null, null);
		
		return isCartAddSuccess;
	}

	public boolean resetCart(UserVO user) {
		
		boolean isReset = false;
		
		Connection conn = JDBCUtil.getConnection();
		CartDAO cartDAO = CartDAO.getInstance();
		cartDAO.setConnection(conn);
		
		isReset = cartDAO.deleteCart(user);
		
		if(isReset) {
			JDBCUtil.commit(conn);
		} else {
			JDBCUtil.rollback(conn);
		}
		JDBCUtil.close(conn, null, null);
		
		return isReset;
	}

}
