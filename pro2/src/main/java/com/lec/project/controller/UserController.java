package com.lec.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.project.action.Action;
import com.lec.project.action.OrderCheckAction;
import com.lec.project.action.ProductListAction;
import com.lec.project.action.UserCreateAction;
import com.lec.project.action.UserLoginAction;
import com.lec.project.action.UserUpdateAction;
import com.lec.project.action.cartAddAction;
import com.lec.project.action.cartDeleteAction;
import com.lec.project.action.cartListAction;
import com.lec.project.action.logoutAction;
import com.lec.project.action.orderListAction;
import com.lec.project.action.productDetailAction;
import com.lec.project.action.userDetailAction;
import com.lec.project.vo.ActionForward;



@WebServlet("*.do")
public class UserController extends HttpServlet {
	
	
	Action action = null; 
	ActionForward forward = null; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doProcess(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	
		doProcess(req, res);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		
		if(command.equals("/test.do")) {
			
			forward  = new ActionForward();
			forward.setPath("/test.jsp");
			
		} else if (command.equals("/createForm.do")) {
			action = new UserCreateAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		}  else if (command.equals("/loginAction.do")) {
			action = new UserLoginAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		} else if (command.equals("/productList.do")) {
			action = new ProductListAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		} else if (command.equals("/myPage.do")) {
			action = new userDetailAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
		
		} else if (command.equals("/addCart.do")) {
			action = new cartAddAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		} else if (command.equals("/cartList.do")) {
			action = new cartListAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
		
		} else if (command.equals("/detailProduct.do")) {
			action = new productDetailAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		} else if (command.equals("/orderList.do")) {
			action = new orderListAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		} else if (command.equals("/cartDelete.do")) {
			action = new cartDeleteAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		} else if (command.equals("/logOut.do")) {
			action = new logoutAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		}  else if (command.equals("/orderCheck.do")) {
			action = new OrderCheckAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		}  else if (command.equals("/userUpdate.do")) {
			action = new UserUpdateAction();
			
			try {forward = action.execute(req, res);				
			} catch (Exception e) {	e.printStackTrace();}
			
		} 		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath());	// 					
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
			}
		} 
		
		
	}
	
	
	
}
