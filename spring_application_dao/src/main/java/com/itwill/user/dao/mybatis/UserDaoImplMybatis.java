package com.itwill.user.dao.mybatis;

import java.sql.Types;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImplMybatis implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int create(User user) throws Exception {
		return sqlSession.insert("create", user);
	}

	@Override
	public int update(User user) throws Exception {
		return sqlSession.update("update", user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return sqlSession.delete("remove", userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return sqlSession.selectOne("findUser", userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return sqlSession.selectList("findUserList");
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		return sqlSession.selectOne("existedUser",userId);
	}

	
	
}
