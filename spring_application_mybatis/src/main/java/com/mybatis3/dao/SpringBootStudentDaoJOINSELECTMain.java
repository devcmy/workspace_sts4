package com.mybatis3.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootStudentDaoJOINSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoJOINSELECTMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------findStudentByIdWithAddress------------------"); //1:1
		
		System.out.println("---------findStudentByIdWithCourses------------------"); //1:N
		
		System.out.println("---------findStudentByIdWithAddressWithCourses-------");
		
		
		
		
	}
}