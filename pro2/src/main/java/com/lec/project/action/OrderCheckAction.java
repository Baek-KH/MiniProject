package com.lec.project.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.OrderService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.OrderVO;
import com.lec.project.vo.Order_detailVO;
import com.lec.project.vo.UserVO;

public class OrderCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		OrderVO orderVO = null;
		ArrayList<Order_detailVO> orderDList = null; 
		
		HttpSession sess = req.getSession();
		if(sess.getAttribute("user") != null) {
		UserVO user = (UserVO) sess.getAttribute("user");
		
		OrderService orderService = new OrderService();
		orderVO = orderService.selectOrder(user);
		orderDList = orderService.selectOrder_detail(orderVO);
		
		req.setAttribute("orderVO", orderVO);
		req.setAttribute("orderDList", orderDList);
		ActionForward forward =new ActionForward() ;
		forward.setPath("/orderCheck.jsp" );
		return forward;
		
		} else {
			ActionForward forward =new ActionForward() ;
			forward.setPath("/login.jsp" );
			return forward;
			
		}
	}
}
