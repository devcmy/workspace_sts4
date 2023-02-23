package com.itwill.user.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
@SpringBootApplication
@SpringBootTest
class UserDaoImplJdbcTemplateTest {
	
	@Autowired
	UserDao userDao;
	
	@Disabled
	@Test
	void testCreate() {
		User user = new User("ssss","password","name","name@name.com");
		try {
			int rowCount = userDao.create(user);
			assertEquals(rowCount, 1); //1이 반환되는개 맞니? 맞으면 성공, 아니면 실패

		} catch (Exception e) {
			//fail(e.getMessage());
			assertInstanceOf(DuplicateKeyException.class, e); //PK위반 -> 성공이긴함.
			}
	}
	
	@Disabled
	@Test
	void testUpdate() {
		User user = new User("ssss","password2","name2","name2@name2.com");
		try {
			int rowCount = userDao.update(user);
			assertEquals(rowCount, 1);
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
	}
	
	@Disabled
	@Test
	void testRemove() {
		try {
			int rowCount = userDao.remove("ssss");
			assertEquals(rowCount, 1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Disabled
	@Test
	void testFindUser() throws Exception {
		User user = userDao.findUser("ssss");
		assertNotNull(user);
		System.out.println(user);
		
	}
	
	@Disabled
	@Test
	void testFindUserList() throws Exception {
		List<User> userList = userDao.findUserList();
		assertNotNull(userList);
		System.out.println(userList);
	}
	
	
	@Test
	void testExistedUser() throws Exception {
		boolean isExistedUser = userDao.existedUser("guard20");
		assertTrue(isExistedUser);
		System.out.println(isExistedUser);
	}

}
