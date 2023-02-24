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
		Student student2 = new Student(0, "금요일", "friday@gmail.com", new Date());
		System.out.println("### row Count(영향받은 행의수) : " + studentDao.insertStudentBySequence1(student2));
		
		
		System.out.println("---------insertStudentBySequence2--------------------");
		Student student3 = new Student(0, "시퀀스2", "seq2@gmail.com", new Date());
		System.out.println("### row Count(영향받은 행의수) : " + studentDao.insertStudentBySequence2(student3));
		System.out.println("### pk-->"+student3.getStudId());
		System.out.println("### "+student3.getStudId()+"번 pk student : "+studentDao.findStudentById(student3.getStudId()));
		
		
		
		
		
		System.out.println("---------updateStudentById---------------------------");
		
		System.out.println("---------deleteStudentById---------------------------");
		
		System.out.println("---------deleteStudentByName-------------------------");
		
		System.out.println("---------deleteStudentByNameLike---------------------");
	}
}