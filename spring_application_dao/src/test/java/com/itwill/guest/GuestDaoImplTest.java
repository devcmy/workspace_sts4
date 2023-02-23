package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication //상위에 @SpringBootApplication을 갖고 있는게있으면 찾고 끌어당겨서 테스트해줌 아니면, 지금처럼 @SpringBootApplication 이라고 기술할것.
@SpringBootTest
class GuestDaoImplTest {
	
	@Autowired
	GuestDao guestDao;
	
	
	@Test
	void testSelectAll() throws Exception {
		guestDao.selectAll();
	}

}
