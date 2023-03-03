package com.itwill.guest.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc 
class GuestControllerTest {
	
	@Autowired//가짜로 mvc만듦
	MockMvc mockMvc;
	
	@MockBean //가짜객체만듦, 가짜로 bean 생성
	GuestService guestService;
	
	
	//ctrl+shift+o -> static으로 넣어줌(import)

	void testGuest_list() throws Exception{
		List<Guest> guestlist = new ArrayList<Guest>();
		guestlist.add(new Guest(1, null, null, null, null, null, null));
		guestlist.add(new Guest(2, null, null, null, null, null, null));
		given(guestService.selectAll()).willReturn(guestlist);
		
		mockMvc.perform(get("/guest_list"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/views/guest_list.jsp"))
		.andDo(print());
		
		verify(guestService).selectAll();
		
	}

	//@Test
	void testGuest_viewIntModel() {
		//fail("Not yet implemented");
	}

}
