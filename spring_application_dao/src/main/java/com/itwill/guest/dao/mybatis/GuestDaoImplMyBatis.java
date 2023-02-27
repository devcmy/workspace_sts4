package com.itwill.guest.dao.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwill.guest.dao.mybatis.mapper.GuestMapper;
import com.itwill.user.dao.jdbctemplate.User;
import com.itwill.user.dao.jdbctemplate.UserSQL;

@Repository
public class GuestDaoImplMyBatis implements GuestDao {
	
	@Autowired
	private GuestMapper guestMapper;

	@Override
	public List<Guest> selectAll() throws Exception {
		return guestMapper.selectAll();
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return guestMapper.selectByNo(no);
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		return guestMapper.insertGuest(guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		return guestMapper.updateGuest(guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return guestMapper.deleteGuest(no);
	}
	
	
	
	
}
