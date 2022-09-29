package com.lec.project.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.lec.db.JDBCUtil;
import com.lec.project.dao.OrderDAO;
import com.lec.project.vo.CartVO;
import com.lec.project.vo.OrderVO;
import com.lec.project.vo.Order_detailVO;
import com.lec.project.vo.UserVO;

public class OrderService {
	
	public static OrderDAO DAOconn() {
		Connection conn = JDBCUtil.getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(conn);
		
		return orderDAO;
	}

	public int addOrder_detail(ArrayList<CartVO> cartList) {
		
		
		int orderNum = DAOconn().addOrderDetail(cartList);
		
		return orderNum;
	}

	public boolean addOrder(UserVO user, int orderNum) {
		
		boolean isOrderSuccess = DAOconn().addOrder(user,orderNum);
		
		
		
		return isOrderSuccess;
	}

	public OrderVO selectOrder(UserVO user) {
		
		OrderVO orderVO = null; 
		
		orderVO = DAOconn().selectOrder(user);
		
		
		return orderVO;
	}

	public ArrayList<Order_detailVO> selectOrder_detail(OrderVO orderVO) {
		
		ArrayList<Order_detailVO> orderDList = null; 
		
		orderDList = DAOconn().selectOrder_detail(orderVO);
		
		return orderDList;
	}

}
