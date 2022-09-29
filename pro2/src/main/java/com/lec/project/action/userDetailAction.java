package com.lec.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.lec.project.service.UserDetailService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.UserVO;

public class userDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {

		ActionForward forward = null; 
		UserVO user;	
		
		HttpSession sess = req.getSession();
		user = (UserVO) sess.getAttribute("user");
		
		if(user != null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/pro2/myPage.jsp");
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
