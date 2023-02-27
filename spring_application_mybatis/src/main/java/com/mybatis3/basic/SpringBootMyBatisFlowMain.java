package com.mybatis3.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.mapper.StudentBasicMapper;
import com.mybatis3.domain.Student;
@SpringBootApplication
public class SpringBootMyBatisFlowMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootMyBatisFlowMain.class, args); //mapper도 같이 올라옴.
		/*
		 * 1. SqlSession객체얻기 -> xml 정보가 map형태로 되어 있음
		 */
		SqlSession sqlSession = appicationContext.getBean(SqlSession.class);
		System.out.println("1. #### SqlSession객체얻기:"+sqlSession);
	
	
		
		/*
		 * 2. SqlSession사용(CRUD)
		 */
		
		/*
		 * com.mybatis3.dao.mapper.StudentBasicMapper를 namespace로가지는 xml파일의 findStudent이름의 sql문
		 * id 안겹치게 mapper.xml파일의 namespace 기술해야함.
		 */
		
		Student student = sqlSession.selectOne("com.mybatis3.dao.mapper.StudentBasicMapper.findStudent", 1);
		System.out.println("#### findStudent:"+student);
		
		List<Student> studentList = sqlSession.selectList("com.mybatis3.dao.mapper.StudentBasicMapper.studentList"); //list로 반환해달라 (namespace 생략해봄)
		System.out.println("#### studentList:"+studentList);
		/*
		 * 5. SqlSession close
		 */
	
	}
}
