package com.lec.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.project.service.UserCreateService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.UserVO;
import com.lec.project.vo.User_addressVO;

public class UserCreateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null; 
		UserVO user = new UserVO();
		
		String user_id = req.getParameter("user_id");
		String user_addr1 = req.getParameter("user_addr1");
		String user_addr2 = req.getParameter("user_addr2");
		String user_addr3 = req.getParameter("user_addr3");
		
		
		user.setUser_id(user_id);
		user.setUser_pw(req.getParameter("user_pw"));
		user.setUser_name(req.getParameter("user_name"));
		user.setUser_phone(req.getParameter("user_phone"));
		user.setUser_gender(req.getParameter("user_gender"));
		user.setUser_email(req.getParameter("user_email"));
		user.setUser_addr1(user_addr1);
		user.setUser_addr2(user_addr2);
		user.setUser_addr3(user_addr3);
		

		UserCreateService userCreateService = new UserCreateService();
		boolean isCreateSuccess = userCreateService.createUser(user);

		if(isCreateSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/pro2/page/Congraturation.jsp");
		} else {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println(" alert('게시글 등록이 실패했습니다.')");
			out.println(" history.back()");
			out.println("</script>");
		}
		
		
		
		
		return forward;
	}

}
