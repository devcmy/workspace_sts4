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

		assertNotEquals(guestDao.selectAll(), null); //guestDao.all의 결과 값이면 성공하면 다음으로 넘어감
		assertNotEquals(guestDao.selectAll().size(), 0); //괄호안의 앞,뒤 비교=> 제로이면 실패
		
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_no(), 196); //121번에 select한 결과의 넘버가 121번이랑 equal이니?
		
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
		
		
	}

}
