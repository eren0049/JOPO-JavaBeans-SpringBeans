package com.example.Beans;

import java.io.Serializable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * This is a example practice to see difference POJO, Java- and SpringBeans
 */
public class JOPOJavaSpringBeans {
	

	public static void main(String[] args) {
		
		
		// for POJO class
		Pojo pojo = new Pojo();
		System.out.println(pojo.toString());
		
		
		//for JavaBeans
		JavaBeans javaBeans= new JavaBeans();
		javaBeans.setStrJavaBeans("I am String from JavaBeans class");
		System.out.println(javaBeans.getStrJavaBeans());
		
		
		// for Spring Beans
		springBeansMethod(SpringBean.class,"strMethod");
		
	}
	
	/**
	 * Calls Beans from @Configuration Class Spring Beans.
	 * @param c : name of class
	 * @param str : name of Method
	 */
	public static void springBeansMethod(Class c, String str) {
		
		var context=  new AnnotationConfigApplicationContext(c);
		System.out.println(context.getBean(str));
	}
	
} // Class



/**
 * Plain Old Java Object
 */
class Pojo{
	private String strPojo = "I am String from Pojo class and my number is";
	
	private int numberPojo = 1;
	
	public String toString() {
		return strPojo + " : " + numberPojo;
	}
}



/**
 * JavaBean
 */
class JavaBeans implements Serializable{
	// JavaBeans consist of 3 part: 
	
	//#1
	//Empty Constructor
	public JavaBeans() {
		
	}
	private String strJavaBeans;
	private int nmbrJavaBeans;
	
	
	
	//#2
	// Getter and Setter
	public String getStrJavaBeans() {
		return strJavaBeans;
	}
	public void setStrJavaBeans(String strJavaBeans) {
		this.strJavaBeans = strJavaBeans;
	}
	public int getNmbrJavaBeans() {
		return nmbrJavaBeans;
	}
	public void setNmbrJavaBeans(int nmbrJavaBeans) {
		this.nmbrJavaBeans = nmbrJavaBeans;
	}	
	
	
	
	
	// #3
	// implementing Serializable (Interface)
	
}


/**
 * SpringBean
 * This can be inner or a separate Class
 */
@Configuration
class SpringBean{
	
	@Bean
	public String strMethod() {
		
		return "Hello World, I am Spring Bean in Main Class";
	}
}










