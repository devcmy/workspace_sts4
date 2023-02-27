package com.itwill.user.dao.mybatis;

import java.sql.Types;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwill.user.dao.mybatis.mapper.UserMapper;
@Repository
public class UserDaoImplMybatis implements UserDao {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int create(User user) throws Exception {
		return userMapper.create(user);
	}

	@Override
	public int update(User user) throws Exception {
		return userMapper.update(user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return userMapper.remove(userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return userMapper.findUser(userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return userMapper.findUserList();
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		return userMapper.existedUser(userId);
	}

	
	
}
