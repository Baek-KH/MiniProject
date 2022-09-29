package com.lec.project.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.CartAddService;
import com.lec.project.service.OrderService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.CartVO;
import com.lec.project.vo.OrderVO;
import com.lec.project.vo.Order_detailVO;
import com.lec.project.vo.UserVO;

public class orderListAction implements Action {

	
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		ArrayList<CartVO> cartList = null; 
		UserVO user = null; 
		HttpSession sess = req.getSession();
		if(sess != null) {
		cartList = (ArrayList<CartVO>) sess.getAttribute("cartList");
		user = (UserVO) sess.getAttribute("user");
		}
		
		ArrayList<Order_detailVO> order_detailVOList = null; 
		OrderVO orderVO = null; 
		
		OrderService orderService = new OrderService();
		CartAddService cartService = new CartAddService();
		int orderNum = orderService.addOrder_detail(cartList);
		boolean isOrderSuccess = orderService.addOrder(user,orderNum);
		boolean isReset = cartService.resetCart(user);
		
		
		ActionForward forward =new ActionForward() ;
		forward.setPath("/orderSuccess.jsp" );
		return forward;
	}

}
