package com.itwill.guest.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class GuestDaoImplJdbcTemplateTest {
	@Autowired
	GuestDao guestDao;
	
	@Disabled
	@Test
	void testSelectAll() throws Exception{
		assertNotNull(guestDao.selectAll());
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll());
		
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		Guest guest = guestDao.selectByNo(466);
		assertNotNull(guest);
		System.out.println(guest);
	}
	@Disabled
	@Test
	void testInsertGuest() throws Exception {
		Guest insertGuest = new Guest(0, "장세종",null,"test@gmail.com","test@test.com","제목","내용");
		assertEquals(guestDao.insertGuest(insertGuest), 1);
	}
	@Disabled
	@Test
	void testUpdateGuest() throws Exception {
		Guest updateGuest = new Guest(466, "박세종",null,"1","1","제목","내용");
		int updateRowCount = guestDao.updateGuest(updateGuest);
		if (updateRowCount != 1) {
			fail("update 실패");
		}
	}
	
	@Test
	void testDeleteGuest() throws Exception {
		int rowCount = guestDao.deleteGuest(466);
		assertEquals(rowCount, 1);
		System.out.println("삭제가되었니?"+rowCount);
	}

}
