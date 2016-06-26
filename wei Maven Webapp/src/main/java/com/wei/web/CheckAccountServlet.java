package com.wei.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wei.entity.User;
import com.wei.service.UserService;
import com.wei.utils.EncryptUtil;
import com.wei.utils.FreemarkerUtil;
import com.wei.utils.SpringUtil;

@WebServlet(name="CheckAccountServlet",urlPatterns={"/checkaccount"})
public class CheckAccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	PrintWriter out =null;
	HttpSession session =null;
	User user = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		out = response.getWriter();
        UserService um= (UserService)SpringUtil.getBean("userService"); 
        String account =  request.getParameter("account");
        user = um.getUserByAccount(account);
//        System.out.println(user.getAccount());
        //没有用户 返回 no_user
        if(user!=null){
        	out.write("has_this_user");
        	user=null;
        }else{
        	//不存在这个用户
        	out.write("no_this_user");
        	
        }
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request,  response);
	}

}
