package com.wei.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wei.utils.FreemarkerUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@WebServlet(name="ToAddUserServlet",urlPatterns={"/toadduser"})
public class ToAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FreemarkerUtil freemarkerUtil;  
	private Map<String, Object> rootMap = null; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		freemarkerUtil = new FreemarkerUtil();  
        rootMap = new HashMap<String, Object>();
        
        PrintWriter out = response.getWriter();
        //开始设置Freemarker  
        Configuration cfg = new Configuration();  
        //设置Freemarker默认编码，如果不设，FreeMarker在遇见中文操作系统时，会使用默认的GBK编码方式  
        cfg.setDefaultEncoding("UTF-8");  
        //设置模板文件所在的目录  
        cfg.setServletContextForTemplateLoading(getServletContext(),  
                "/templates");  
        
        // 取得模板文件  
        Template temp = cfg.getTemplate("adduser.ftl");  
        //设置响应编码  
        response.setContentType("text/html; charset=UTF-8");  
  
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
