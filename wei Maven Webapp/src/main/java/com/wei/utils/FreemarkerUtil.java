package com.wei.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {

	
	 	public Template getTemplate(String name) {  
	        Template temp = null;  
	        try {  
	            // 通过Freemarker的Configuration读取相应的Ftl  
	            Configuration cfg = new Configuration();  
	            cfg.setDefaultEncoding("UTF-8");  
	            // 设定去哪里读取相应的ftl模板  
	            
	            cfg.setClassForTemplateLoading(this.getClass(), "/templates");  
	            // 在模板文件目录中寻找名称为name的模板文件  
	            temp = cfg.getTemplate(name);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return temp;  
	    }  
	  
	    /** 
	     * 将指定 Template 的内容输出到页面
	     *
	     */  
	    public void print(String name, Map<String, Object> rootMap,PrintWriter out) {  
	        try {  
	            // 通过Template类可以将模板文件输出到相应的文件  
	            Template temp = this.getTemplate(name);  
	            temp.process(rootMap, out);  
	        } catch (TemplateException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    
	    
	    
	    
	    
	    
	    
}
