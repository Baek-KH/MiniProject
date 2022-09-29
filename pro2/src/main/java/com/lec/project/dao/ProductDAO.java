package com.lec.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.lec.db.JDBCUtil;
import com.lec.project.vo.ProductVO;

public class ProductDAO {
	
	
	private ProductDAO () {};
	private static ProductDAO productDAO;
	public static ProductDAO getInstance() {
		if(productDAO == null) productDAO = new ProductDAO();
		return productDAO;
	}
	
	Connection conn = null;
	
	public void setConnection(Connection conn) {
		this.conn= conn;
	}

	public int selectListCount(String query) {
		
		int listCount = 0;
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String sql = "select count(*) from product where pro_name like ? ";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			rs= pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		
		return listCount;
	}

	public ArrayList<ProductVO> selectBoardList(int page, String field, int limit, String query) {
		
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		ProductVO product = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String sql = "select * from product where pro_name like ? "
					+" order by "+field+" desc limit ? , " + limit; 
		
		int startRow = (page - 1) * limit; 
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,"%"+query+"%" );    // mriadb 특징
			pstmt.setInt(2, startRow );    // mriadb 특징
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product = new ProductVO();
				product.setPro_num(rs.getInt("pro_num"));
				product.setCategory_code(rs.getString("category_code"));
				product.setPro_name(rs.getString("pro_name"));
				product.setPro_price(rs.getInt("pro_price"));
				product.setPro_stock(rs.getInt("pro_stock"));
				product.setPro_desc(rs.getString("pro_num"));
				product.setPro_date(rs.getDate("pro_date"));
				product.setPro_hit(rs.getInt("pro_hit"));
				product.setPro_img(rs.getString("pro_img"));
				
				productList.add(product);

			}
			
		} catch (SQLException e) {
			System.out.println("게시글 조회 실패 !! "+ e.getMessage());

		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return productList;
	
	}

	
	public ProductVO selectPro(int pro_num) {
		
		ProductVO productVO = new ProductVO();
		
		
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String sql = "select * from product where pro_num = ? ";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, pro_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				productVO.setPro_num(rs.getInt("pro_num"));
				productVO.setCategory_code(rs.getString("category_code"));
				productVO.setPro_name(rs.getString("pro_name"));
				productVO.setPro_price(rs.getInt("pro_price"));
				productVO.setPro_stock(rs.getInt("pro_stock"));
				productVO.setPro_desc(rs.getString("pro_num"));
				productVO.setPro_date(rs.getDate("pro_date"));
				productVO.setPro_hit(rs.getInt("pro_hit"));
				productVO.setPro_img(rs.getString("pro_img"));
								
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시글 조회 실패 !! "+ e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		
		
		return productVO;
	}

	public int updateHit(ProductVO productVO) {
		
		PreparedStatement pstmt = null; 
		int updateCount = 0;
		int pro_num = productVO.getPro_num();
		int hit = productVO.getPro_hit()+1;

		String sql = "update product set pro_hit = ? where pro_num= " + pro_num;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hit );
			updateCount = pstmt.executeUpdate();
			if(updateCount==0) {
				System.out.println("조회수 업데이트 실패 !! ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		
		
		
		return updateCount;
	}
	
	
	
	
}
