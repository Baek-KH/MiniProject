package com.lec.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.project.service.ProductDetailService;
import com.lec.project.vo.ActionForward;
import com.lec.project.vo.ProductVO;
import com.lec.project.vo.UserVO;

public class productDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		ProductVO productVO = new ProductVO();
		HttpSession sess = req.getSession();
		UserVO user = (UserVO) sess.getAttribute("user");
		
		int pro_num = Integer.parseInt(req.getParameter("p_num"));
		ProductDetailService productDetailService = new ProductDetailService();
		productVO = productDetailService.selectProduct(pro_num);
		
		req.setAttribute("productVO", productVO);
		sess.setAttribute("user", user);
		ActionForward forward =new ActionForward() ;
		forward.setPath("/prodetail.jsp" );
		return forward;
	}

}
