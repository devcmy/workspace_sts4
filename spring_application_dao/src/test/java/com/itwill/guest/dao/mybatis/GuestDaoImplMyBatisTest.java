package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

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
	
	@Disabled
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
	void testInsertGuest() throws Exception {
		Guest guest = new Guest(0, "아이유", null, "iu@iu.com", "homp", "title", "content");
		assertEquals(guestDao.insertGuest(guest), 1);
		System.out.println(guest);
	}
	
	@Disabled
	@Transactional
	@Test
	void testUpdateGuest() throws Exception {
		Guest guest = new Guest(518, "이지은", null, "iu", "홈피", "타이틀", "내용");
		System.out.println(guestDao.updateGuest(guest));
		assertEquals(guestDao.updateGuest(guest), 1);
		
		
	}
	
	@Disabled
	@Test
	void testDeleteGuest() throws Exception {
		int rowCount = guestDao.deleteGuest(512);
		assertEquals(rowCount, 1);
		System.out.println("삭제여부 : "+rowCount);
		
	}

}
