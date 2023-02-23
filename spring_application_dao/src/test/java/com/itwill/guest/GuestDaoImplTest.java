package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication //상위에 @SpringBootApplication을 갖고 있는게있으면 찾고 끌어당겨서 테스트해줌 아니면, 지금처럼 @SpringBootApplication 이라고 기술할것.
//붙이면 guestDaoIMPL만 테스트된다.
@SpringBootTest
class GuestDaoImplTest {
	
	@Autowired
	GuestDao guestDao;
	
	@Disabled //testselectall 메소드 테스트안함
	@Test
	void testSelectAll() throws Exception {

		assertNotEquals(guestDao.selectAll(), null); //guestDao.all의 결과 값이면 성공하면 다음으로 넘어감
		assertNotEquals(guestDao.selectAll().size(), 0); //괄호안의 앞,뒤 비교=> 제로이면 실패
		
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_no(), 196); //121번에 select한 결과의 넘버가 121번이랑 equal이니?
		
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
	}
	@Test
	void testSelectByNo() throws Exception {
		assertNull(guestDao.selectByNo(98989898));
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_name(), "요셉짱"); //equals 같은지 비교 cf.same은 참조비교(interger을 넣어도 참조비교해야함)
		
		System.out.println(guestDao.selectByNo(196));
	}
	
	@Disabled
	@Test
	void testInsertGuest() throws Exception {
		Guest insertGuest = new Guest(0, "테스트", null, "test@gmail.com", "test.com", "타이틀", "내용");
		assertEquals(guestDao.insertGuest(insertGuest), 1); //괄호내의 첫번째 매개변수, 두번째 매개변수가 같은지 ?
	}
	
	@Test
	void testUpdateGuest() throws Exception {
		Guest updateGuest = new Guest(263, "테스트수정", null, "testchange@naver.com", "test.co.kr", "타이틀수정", "내용수정");
		int updateRowCount = guestDao.updateGuest(updateGuest);
		if(updateRowCount!=1) {
			fail("update 실패");
		}
		
	}
	
	
}
