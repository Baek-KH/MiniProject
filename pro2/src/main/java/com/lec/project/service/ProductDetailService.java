package com.lec.project.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.project.dao.ProductDAO;
import com.lec.project.vo.ProductVO;

public class ProductDetailService {

	public ProductVO selectProduct(int pro_num) {
		
		ProductVO productVO = null;
		int updateCount = 0;
		
		Connection conn = JDBCUtil.getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(conn);
		
		productVO = productDAO.selectPro(pro_num);
		updateCount = productDAO.updateHit(productVO);
		
		if(updateCount >0) {
			JDBCUtil.commit(conn);
			
		} else {
			JDBCUtil.rollback(conn);
		}
		JDBCUtil.close(conn, null, null);
		return productVO;
	}

}
