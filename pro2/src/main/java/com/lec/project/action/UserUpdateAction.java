package com.lec.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.UserCreateService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.UserVO;

public class UserUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		ActionForward forward = null; 
		UserVO user;	
		UserVO userT = new UserVO();	
		
		HttpSession sess = req.getSession();
		user = (UserVO) sess.getAttribute("user");
		userT.setUser_id(req.getParameter("user_id"));
		userT.setUser_phone(req.getParameter("user_phone"));
		userT.setUser_addr1(req.getParameter("user_addr1"));
		userT.setUser_addr2(req.getParameter("user_addr2"));
		userT.setUser_addr3(req.getParameter("user_addr3"));

		if(user.getUser_pw().equals(req.getParameter("pw_c"))) {
			
			UserCreateService userCreateService = new UserCreateService();
			boolean isUpdateSuccess = userCreateService.updateUser(userT);
			

			if(isUpdateSuccess) {

				user.setUser_phone(req.getParameter("user_phone"));
				user.setUser_addr1(req.getParameter("user_addr1"));
				user.setUser_addr2(req.getParameter("user_addr2"));
				user.setUser_addr3(req.getParameter("user_addr3"));
				
				sess.setAttribute("user", user);
				
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("/pro2/index.jsp");
			} else {
				res.setContentType("text/html; charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println(" alert('회원정보를 수정할 수 없습니다.')");
				out.println(" history.back()");
				out.println("</script>");
			}
		} else {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println(" alert('패스워드가 일치하지 않습니다.')");
			out.println(" history.back()");
			out.println("</script>");
		}
		
				
		
		return forward;
	}

}
