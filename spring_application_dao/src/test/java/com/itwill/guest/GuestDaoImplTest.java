package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@SpringBootTest
class GuestDaoImplTest {
	
	@Autowired
	GuestDao guestDao;
	
	
	@Test
	void testSelectAll() throws Exception {
		guestDao.selectAll();
	}

}
