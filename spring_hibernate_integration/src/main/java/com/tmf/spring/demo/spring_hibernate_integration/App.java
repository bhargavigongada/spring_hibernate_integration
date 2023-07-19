package com.tmf.spring.demo.spring_hibernate_integration;

import java.sql.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tmf.spring.demo.spring_hibernate_integration.config.SpringConfig;
import com.tmf.spring.demo.spring_hibernate_integration.models.Product;
import com.tmf.spring.demo.spring_hibernate_integration.services.ProductServices;
import com.tmf.spring.demo.spring_hibernate_integration.services.ProductServicesImpl;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx;
    	ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	ProductServices service = ctx.getBean(ProductServicesImpl.class);
    	Product pro = new Product(1,"Beer Shampoo",125.0,"Cosmetics");
    	service.addProduct(pro);
    	
    }
}
