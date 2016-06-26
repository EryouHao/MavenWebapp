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

@WebServlet(name="LoginServlet",urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	PrintWriter out =null;
	HttpSession session =null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		out = response.getWriter();
		session = request.getSession();
        UserService um= (UserService)SpringUtil.getBean("userService"); 
        String account =  request.getParameter("account");
        String password =  request.getParameter("password");
        User user = um.getUserByAccount(account);
        //没有用户 返回 no_user
        if(user==null){
        	out.write("没有这个用户");
        	
        }else{
        	
        	//查看账户是否封存
        	
        	if(user.getState()==1){
        		out.write("该账户已封存");
        	}else{
        		//前台传来密码加密后与 数据库中密码比对
        		String pass = EncryptUtil.encryptString(password);
            	
            	if(pass.equals(user.getPassword())){
            		session.setAttribute("user", user);
            		
            		//修改用户最后登录时间
            		try{
            			um.updateUserdate(new Date(), user.getId());
            			out.write("success");
            		}catch(Exception e){
            			out.write("更新登录时间错误");
            			
            		}
                }else{
                	out.write("密码错误");
                }
        	}
        	
        	
        }
        
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request,  response);
	}

}
