package com.lec.project.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.lec.project.service.ProductListService;
import com.lec.project.service.UserLoginService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.PageInfo;
import com.lec.project.vo.ProductVO;
import com.lec.project.vo.UserVO;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		
		int page = 1; 
		int limit= 9; 
		String field = "";
		String query ="";
		
		if(req.getParameter("f") != null) field = req.getParameter("f"); else field ="pro_num";
		if(req.getParameter("q") != null) query = req.getParameter("q");
		if(req.getParameter("p") != null) page = Integer.parseInt(req.getParameter("p"));
		
		
		
		ProductListService productListService = new ProductListService();
		int listCount = productListService.productListCount(query);
		productList = productListService.getProductList(page,field,limit,query);
		
		// 총페이지수 
		int totalPage = (int) ((double)listCount / limit +0.95);
		// 현재페이지의 시작페이지수(1, 11, 21 ... ) 
		int startPage = ((int) ((double)page / 10 + 0.9) -1) *10+1 ; 
		// 현재페이지의 마지막페이지 수 
		int endPage = startPage +10 -1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(listCount);
		pageInfo.setPage(page);
		pageInfo.setTotalPage(totalPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		
		
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("productList", productList);
		
		
		
		ActionForward forward =new ActionForward() ;
		forward.setPath("/prolist.jsp" );
		return forward;
		
	}

}
