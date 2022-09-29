package com.lec.project.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.project.dao.UserDAO;
import com.lec.project.vo.UserVO;

public class UserCreateService {

	public boolean createUser(UserVO user) {
		
		boolean isCreateSuccess = false; 
		
		Connection conn = JDBCUtil.getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(conn);
		
		int createCount = userDAO.createUser(user);
		
		if(createCount >0) {
			JDBCUtil.commit(conn);
			isCreateSuccess = true;
		} else {
			JDBCUtil.rollback(conn);
		}
		JDBCUtil.close(conn, null, null);

		return isCreateSuccess;
	}

	public boolean updateUser(UserVO userT) {
		
		boolean isUpdateSuccess = false;
		
		Connection conn = JDBCUtil.getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(conn);
		
		int updateCount = userDAO.updateUser(userT);
		
		if(updateCount >0) {
			JDBCUtil.commit(conn);
			isUpdateSuccess = true;
		} else {
			JDBCUtil.rollback(conn);
		}
		JDBCUtil.close(conn, null, null);

		
		return isUpdateSuccess;
	}
	
	
}
