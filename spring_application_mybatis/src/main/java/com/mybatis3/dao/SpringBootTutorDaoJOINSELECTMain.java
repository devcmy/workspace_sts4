package com.mybatis3.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;
import com.mybatis3.domain.Student;

@SpringBootApplication
@MapperScan(basePackages = "com.mybatis3.dao.mapper")
public class SpringBootTutorDaoJOINSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootTutorDaoJOINSELECTMain.class, args);
		TutorDao tutorDao = (TutorDao)appicationContext.getBean(TutorDao.class);
		System.out.println("---------findTutorByIdWithCourses-----------------------------");
		//System.out.println(tutorDao.findTutorByIdWithCourses(1));
		System.out.println(tutorDao.findTutorByIdWithCourses(2));
		
		
		
		
		
		
	}
}
