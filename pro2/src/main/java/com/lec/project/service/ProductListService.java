package com.lec.project.service;

import java.sql.Connection;
import java.util.ArrayList;
import com.lec.db.JDBCUtil;
import com.lec.project.dao.ProductDAO;
import com.lec.project.vo.ProductVO;

public class ProductListService {

	public int productListCount(String query) {
		
		int listCount = 0; 
		
		Connection conn = JDBCUtil.getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(conn);
		listCount = productDAO.selectListCount(query);
		
		JDBCUtil.close(conn, null, null);
		return listCount;
	}

	public ArrayList<ProductVO> getProductList(int page, String field, int limit, String query) {
		
		ArrayList<ProductVO> productList = null;
		Connection conn = JDBCUtil.getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(conn);
		productList = productDAO.selectBoardList(page,field,limit,query);
		
		JDBCUtil.close(conn, null, null);
		
		return productList;
	} 
	
	
	
	
	

}
