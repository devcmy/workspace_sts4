package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.mybatis.spring.annotation.MapperScans;

import com.mybatis3.domain.Student;
@Mapper
public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * StudentMapper 인터페이스와 같은 위치에 StudentMapper.xml위치시켜야한다.(.properties에 작성안하려고하면)
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 * mapper location을 applcation.properties에 작성을 안할려고 하면, 같은 directory 에 둬야한다.
	 */
	
	public Student findStudentById(Integer studId);
	public List<Student> findAllStudents();
	public String findStudentNameById(Integer studId);
	public List<String> findStudentNameList();
	public int insertStudent(Student student);
	public int insertStudentBySequence1(Student student);
	public int insertStudentBySequence2(Student student);
	public int updateStudentById(Student student);
	public int deleteStudentById(Integer studId);
	public int deleteStudentByName(String name);
	
	
	
	
	
	
}