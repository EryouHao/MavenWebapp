package com.wei.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wei.entity.User;
import com.wei.service.UserService;
import com.wei.utils.FreemarkerUtil;
import com.wei.utils.SpringUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@WebServlet(name="IndexServlet",urlPatterns={"/index"})
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private FreemarkerUtil freemarkerUtil;  
	PrintWriter out =null;
	private Map<String, Object> rootMap = null; 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码  
		response.setContentType("text/html;charset=utf-8");
		freemarkerUtil = new FreemarkerUtil();  
        rootMap = new HashMap<String, Object>();
        
        PrintWriter out = response.getWriter();
		  //开始设置Freemarker  
        Configuration cfg = new Configuration();  
        //设置Freemarker默认编码，如果不设，FreeMarker在遇见中文操作系统时，会使用默认的utf8编码方式  
        cfg.setDefaultEncoding("UTF-8");  
        //设置模板文件所在的目录  
        cfg.setServletContextForTemplateLoading(getServletContext(),  
                "/templates");  
        UserService um= (UserService)SpringUtil.getBean("userService"); 
        List<User> userlist =  um.getUserList();
        // 取得模板文件  
        Template temp = cfg.getTemplate("index.ftl");  
        
        rootMap.put("userlist", userlist);
        try {
			temp.process(rootMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} 
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request,  response);
	
	}

}
