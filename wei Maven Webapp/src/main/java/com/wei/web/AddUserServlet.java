package com.wei.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wei.entity.User;
import com.wei.service.UserService;
import com.wei.utils.EncryptUtil;
import com.wei.utils.SpringUtil;


@WebServlet(name="AddUserServlet",urlPatterns={"/adduser"})
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out =null;
	HttpSession session =null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		session = request.getSession();
        UserService um= (UserService)SpringUtil.getBean("userService"); 
        
        String account =  request.getParameter("account");
        String name =  request.getParameter("name");
        String nickname =  request.getParameter("nickname");
        String password =  EncryptUtil.encryptString(request.getParameter("password"));
        String state_str =  request.getParameter("state");
        String type_str =  request.getParameter("type");
        String encode = "GBK"; 
        name = new String(name.getBytes(encode), "UTF-8");
        nickname= new String(nickname.getBytes(encode), "UTF-8");
        
        int state = Integer.parseInt(state_str);
        int type = Integer.parseInt(type_str);
        Date createdate = new Date();
        User user = new User(account,name,nickname,password,state,createdate,type);
        try{
        	um.addUser(user);
        	out.write("success");
        }catch(Exception e){
        	out.write("wrong");
        }
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request,  response);
	}

}
