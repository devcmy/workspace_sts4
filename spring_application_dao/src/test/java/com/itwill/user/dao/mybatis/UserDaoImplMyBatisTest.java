package com.itwill.user.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@SpringBootTest
class UserDaoImplMyBatisTest {
	
	@Autowired
	private UserDao userDao;
	
	@Disabled
	@Test
	void init() {
		System.out.println(userDao);
	}
	
	@Transactional
	@Disabled
	@Test
	void testCreate() throws Exception{
		User user = new User("test81", "1234", "name", "mail");
		assertEquals(userDao.create(user), 1);
		System.out.println(user);
	}
	
	@Disabled
	@Test
	void testDelete() throws Exception {
		int rowCount= userDao.remove("sond");
		assertEquals(rowCount, 1);
		System.out.println("삭제여부 : "+rowCount);
	}
	@Test
	@Disabled
	void testUpdate() throws Exception{
		User user = new User("test88", "4321", "e", "a");
		System.out.println(userDao.update(user));
		assertEquals(userDao.update(user), 1);
	}
	
	@Test
	@Disabled
	void testfindUserList() throws Exception {
		assertNotNull(userDao.findUserList());
		System.out.println(userDao.findUserList());
	}
	@Disabled
	@Test
	void testfindUser() throws Exception {
		assertNotNull(userDao.findUser("aa"));
		System.out.println(userDao.findUser("aa"));
	}
	
	@Test
	void testExistedUser() throws Exception {
		assertNotNull(userDao.existedUser("aa"));
		System.out.println("aa");
	}
	
	
}
