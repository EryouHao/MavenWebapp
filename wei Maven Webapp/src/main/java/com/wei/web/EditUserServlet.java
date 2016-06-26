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


@WebServlet(name="EditUserServlet",urlPatterns={"/edituser"})
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out =null;
	HttpSession session =null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		session = request.getSession();
        UserService um= (UserService)SpringUtil.getBean("userService"); 
        String id =  request.getParameter("id");
        String account =  request.getParameter("account");
        String name =  request.getParameter("name");
        String nickname =  request.getParameter("nickname");
        String password =  EncryptUtil.encryptString(request.getParameter("password"));
        String type_str =  request.getParameter("type");
        int type = Integer.parseInt(type_str);
        
        
        
        try{
        	um.updateUser(account, name, nickname, password, type, Integer.parseInt(id));;
        	out.write("success");
        }catch(Exception e){
        	out.write("wrong");
        }
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request,  response);
	}

}
