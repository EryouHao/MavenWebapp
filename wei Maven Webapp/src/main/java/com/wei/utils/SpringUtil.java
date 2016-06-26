package com.wei.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	
	public SpringUtil() {
	}

	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(  
            "beans.xml");  
  
    public static Object getBean(String beanName) {  
        return ctx.getBean(beanName);  
    } 
}
