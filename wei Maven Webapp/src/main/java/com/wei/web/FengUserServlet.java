package com.wei.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wei.service.UserService;
import com.wei.utils.SpringUtil;

@WebServlet(name="FengUserServlet",urlPatterns={"/fengUser"})
public class FengUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out =null;
	HttpSession session =null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		out = response.getWriter();
		session = request.getSession();
        UserService um= (UserService)SpringUtil.getBean("userService"); 
        String id =  request.getParameter("id");
        String state =  request.getParameter("state");
        int st = Integer.parseInt(state);
        try{
        	if(st==0){
        		um.updateUser(1, Integer.parseInt(id));
        	}else{
        		um.updateUser(0, Integer.parseInt(id));
        	}
        
        	out.write("success");
        }catch(Exception e){
        	out.write("wrong");
        	e.printStackTrace();
        }
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request,  response);
	}

}
