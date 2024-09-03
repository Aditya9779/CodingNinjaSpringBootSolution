package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@Author(name = "Aditya Srivastava" ,date = "31-07-2024")
public class TaxApplication {
	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Tax incomeTax = (Tax) context.getBean("incomeTax");
		Tax propertyTax = (Tax) context.getBean("propertyTax");
	}

}
