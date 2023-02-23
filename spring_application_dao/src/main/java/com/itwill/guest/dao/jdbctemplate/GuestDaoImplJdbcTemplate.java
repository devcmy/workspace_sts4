package com.itwill.guest.dao.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDaoImplJdbcTemplate implements GuestDao { //여전히 jdbc template는 sql파일이 필요로 하다.
	//appalicationContext 가 초기화될때,  Datasource와 jdbctemplate을 생성함(datasource 객체를 찾아서 injection주입함)
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Guest> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
