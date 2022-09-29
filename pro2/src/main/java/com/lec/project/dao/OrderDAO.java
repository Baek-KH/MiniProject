package com.lec.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.lec.db.JDBCUtil;

import com.lec.project.vo.CartVO;
import com.lec.project.vo.OrderVO;
import com.lec.project.vo.Order_detailVO;
import com.lec.project.vo.UserVO;


public class OrderDAO {
	
	
	private OrderDAO () {};
	private static OrderDAO orderDAO;
	public static OrderDAO getInstance() {
		if(orderDAO == null) orderDAO = new OrderDAO();
		return orderDAO;
	}
	
	Connection conn = null;
	
	public void setConnection(Connection conn) {
		this.conn= conn;
	}

	public int addOrderDetail(ArrayList<CartVO> cartList) {
	
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String sql = "insert into order_detail values(?,?,?,?,?)";
		
		int insertCount = 0; 
		int num = 0; 
		
		try {
			pstmt=conn.prepareStatement("select max(order_num) from order_detail");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1) +1; 
			} else {
				num = 1; 
			}
			for(int i=0;i<cartList.size();i++) {
				
				try {
				pstmt= conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setInt(2, cartList.get(i).getPro_num());
				pstmt.setInt(3, cartList.get(i).getPro_count());
				pstmt.setInt(4, cartList.get(i).getPro_price() * cartList.get(i).getPro_count());
				pstmt.setString(5, "n");
				insertCount = insertCount + pstmt.executeUpdate();
				
				} catch (SQLException e) {
					System.out.println("주문상세 등록1 실패 !! "+ e.getMessage());
				} finally {
					JDBCUtil.commit(conn);
				}
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("주문상세 등록2 실패 !! "+ e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		
		return num;
	}

	@SuppressWarnings("resource")
	public boolean addOrder(UserVO user, int orderNum) {
		
		
		boolean isOrderSuccess = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into `order` values(?,?,now(),?,?,?,?,?,?)";
		int totalPrice = 0; 
		int insertCount = 0;
		try {
			pstmt = conn.prepareStatement("select sum(pro_price) from order_detail where order_num = "+orderNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			totalPrice = rs.getInt(1);
			
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNum);
			pstmt.setString(2, user.getUser_id());
			pstmt.setString(3, user.getUser_addr1());
			pstmt.setString(4, user.getUser_addr2());
			pstmt.setString(5, user.getUser_addr3());
			pstmt.setString(6, user.getUser_name());
			pstmt.setString(7, user.getUser_phone());
			pstmt.setInt(8, totalPrice);
			insertCount = pstmt.executeUpdate();
			if(insertCount>0) isOrderSuccess = true;
			System.out.println(insertCount +"  "+ isOrderSuccess);
			
		} catch (SQLException e) {
			System.out.println("주문 등록2 실패 !! "+ e.getMessage());

		} finally {
			JDBCUtil.commit(conn);
			JDBCUtil.close(null, pstmt, rs);
		}
		
		
		
		
		


		
		
		return isOrderSuccess;
	}

	public OrderVO selectOrder(UserVO user) {
		
		OrderVO orderVO = new OrderVO(); 

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from `order` where user_id = ? order by order_num desc limit 1";
				
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
			orderVO.setOrder_num(rs.getInt(1));
			orderVO.setOrder_date(rs.getString(3));
			orderVO.setOrder_addr1(rs.getString(4));
			orderVO.setOrder_addr2(rs.getString(5));
			orderVO.setOrder_addr3(rs.getString(6));
			orderVO.setOrder_name(rs.getString(7));
			orderVO.setOrder_phone(rs.getString(8));
			orderVO.setTotal_price(rs.getInt(9));
			}
			
		} catch (SQLException e) {
			System.out.println("주문 등록3 실패 !! "+ e.getMessage());

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		
		
		
		
		return orderVO;
	}

	public ArrayList<Order_detailVO> selectOrder_detail(OrderVO orderVO) {
		
		ArrayList<Order_detailVO> orderDList = new ArrayList<Order_detailVO>(); 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select o.order_num"
				+ ",o.pro_num "
				+ ",p.pro_name"
				+ ",o.pro_count"
				+ ",o.pro_price"
				+ " from order_detail o, product p where o.pro_num = p.pro_num and o.order_num = " + orderVO.getOrder_num();
		
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			Order_detailVO order_detailVO= new Order_detailVO();
			order_detailVO.setOrder_num(rs.getInt(1));
			order_detailVO.setPro_num(rs.getInt(2));
			order_detailVO.setPro_name(rs.getString(3));
			order_detailVO.setPro_count(rs.getInt(4));
			order_detailVO.setPro_price(rs.getInt(5));
			
			orderDList.add(order_detailVO);
			}
			
		} catch (SQLException e) {
			System.out.println("주문 등록4 실패 !! "+ e.getMessage());

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		
		
		
		
		return orderDList;
	}

	
	
}
