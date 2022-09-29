/**
 * 
 */
package com.lec.project.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.lec.db.JDBCUtil;
import com.lec.project.dao.CartDAO;
import com.lec.project.vo.CartVO;


/**
 * @author 505-20
 *
 */
public class CartListService {

	public ArrayList<CartVO> getCartList(String user_id) {
		
		ArrayList<CartVO> cartList = null;
		Connection conn = JDBCUtil.getConnection();
		CartDAO cartDAO = CartDAO.getInstance();
		cartDAO.setConnection(conn);
		cartList = cartDAO.selectCartList(user_id);
		
		
		return cartList;
		

	}

}
