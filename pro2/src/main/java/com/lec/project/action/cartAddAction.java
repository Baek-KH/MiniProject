package com.lec.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.CartAddService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.CartVO;
import com.lec.project.vo.UserVO;

public class cartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null; 
		UserVO user;	
		
		boolean isCartAddSuccess = false;

		HttpSession sess = req.getSession();
		user = (UserVO) sess.getAttribute("user");
		int pro_num = Integer.parseInt(req.getParameter("p_num"));
		
		if(user != null) {
			CartAddService cartAddService = new CartAddService();
			isCartAddSuccess = cartAddService.addCart(user, pro_num); 
			if(isCartAddSuccess) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("productList.do");
				
			} else {
				res.setContentType("text/html; charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println(" alert('카트담기에 실패했습니다.')");
				out.println(" history.back()");
				out.println("</script>");
				
			}
		} else {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println(" alert('로그인 되어있지 않습니다. 로그인을 먼저 진행해주세요.')");
			out.println(" history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
