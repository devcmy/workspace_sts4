package com.mybatis3.dao;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoDMLMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoDMLMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1 = new Student(10000, "만원", "10000@gmail.com", new Date());
		System.out.println("### row Count(영향받은 행의수) : " + studentDao.insertStudent(student1));
		
		System.out.println("---------insertStudentBySequence1--------------------");
		
		System.out.println("---------insertStudentBySequence2--------------------");
		
		System.out.println("---------updateStudentById---------------------------");
		
		System.out.println("---------deleteStudentById---------------------------");
		
		System.out.println("---------deleteStudentByName-------------------------");
		
		System.out.println("---------deleteStudentByNameLike---------------------");
	}
}