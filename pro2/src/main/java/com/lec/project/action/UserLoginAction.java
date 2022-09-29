package com.lec.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.UserCreateService;
import com.lec.project.service.UserLoginService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.UserVO;

public class UserLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		
		
		ActionForward forward = null; 
		UserVO user;
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		

		UserLoginService userLonginService = new UserLoginService();
		user = userLonginService.loginUser(user_id,user_pw);
		if(user!=null) {
			HttpSession sess = req.getSession();
			sess.setAttribute("user", user);
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/pro2/loginSuccess.jsp");
		} else {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println(" alert('로그인이 실패했습니다.')");
			out.println(" history.back()");
			out.println("</script>");
		}
		
		
		
		
		return forward;
	}

}
