package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
@SpringBootApplication
@SpringBootTest
class GuestDaoImplMyBatisTest {
	
	@Autowired
	private GuestDao guestDao;
	
	@Disabled
	@Test
	void init() {
		System.out.println(guestDao);
	}
	
	
	@Test
	void testSelectAll() throws Exception {
		assertNotNull(guestDao.selectAll());
		System.out.println(guestDao.selectAll());
	}
	
	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		System.out.println(guestDao.selectByNo(264));
		assertNotNull(guestDao.selectByNo(264));
	}
	
	@Disabled
	@Transactional //insert 후 바로 rollback
	@Test
	void testInsertGuest() {

	}
	
	@Disabled
	@Test
	void testUpdateGuest() {
		fail("Not yet implemented");
	}
	
	@Disabled
	@Test
	void testDeleteGuest() {
		fail("Not yet implemented");
	}

}
