package com.mybatis3.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Student;
@Mapper
public interface StudentBasicMapper {
	/*
	 * 	<select id="findStudent" parameterType="java.lang.Integer" resultType="com.mybatis3.domain.Student">
		select stud_id, name, email, dob from students where stud_id = #{studId}
		</select> -> mapper.xml의 내용을 직접 인터페이스로 만들어서 기술함(설정파일 대신해서 기술)but join query는 넘 길어서, 설정파일도 같이 작성함.
	 */
	@Select("select stud_id, name, email, dob from students where stud_id = #{studId}")
	public Student findStudent(@Param(value ="studId") Integer studId);
	//findStudent는 직접 기술한것을 이용 -> 둘다있으면 중복이니 하나만 기술할 것.
	
	public List<Student> studentList();
	//studentList는 mapper.xml의 <select>를 이용
}
