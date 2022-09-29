package com.lec.project.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.CartAddService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.CartVO;
import com.lec.project.vo.UserVO;

public class cartDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		UserVO user = null; 
		HttpSession sess = req.getSession();
		if(sess != null) {
		user = (UserVO) sess.getAttribute("user");
		}
		CartAddService cartService = new CartAddService();
		boolean isReset = cartService.resetCart(user);
		
		ActionForward forward =new ActionForward() ;
		forward.setPath("/cartList.do" );
		return forward;
	
		
	}
}
