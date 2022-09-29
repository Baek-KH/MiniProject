package com.lec.project.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.project.dao.UserDAO;
import com.lec.project.vo.UserVO;



public class UserLoginService {

	public UserVO loginUser(String user_id, String user_pw) {
		
		UserVO user;
		
		Connection conn = JDBCUtil.getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(conn);

		user = userDAO.loginUser(user_id,user_pw);
		
		return user;
	}
	
	
	
	

}
