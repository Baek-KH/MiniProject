package com.lec.project.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.CartListService;
import com.lec.project.service.ProductListService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.CartVO;
import com.lec.project.vo.PageInfo;
import com.lec.project.vo.UserVO;


public class cartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {

		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		
		HttpSession sess = req.getSession();
		
		UserVO user = (UserVO) sess.getAttribute("user");
		String user_id = user.getUser_id();
		
		
		CartListService cartListService = new CartListService();
		cartList = cartListService.getCartList(user_id);
		

		
		req.setAttribute("cartList", cartList);
		sess.setAttribute("user", user);
		sess.setAttribute("cartList", cartList);
		
		ActionForward forward =new ActionForward() ;
		forward.setPath("/cart.jsp" );
		return forward;
		
		
		
	}

}
