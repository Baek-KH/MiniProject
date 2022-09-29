package com.lec.db;

import java.sql.*;


import javax.naming.*;
import javax.sql.DataSource;



public class JDBCUtil {
	

	public static Connection getConnection() {
		
		Connection conn = null; 
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/project");	// context resource 정보가 전부 DataSource로 들어온다. 
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null) conn.commit();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null) conn.rollback();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	
}
