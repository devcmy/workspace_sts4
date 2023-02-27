package com.itwill.guest.dao.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.guest.dao.mybatis.mapper")
public class GuestMapperTestMain  {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=SpringApplication.run(GuestMapperTestMain.class, args);
		GuestDao guestDao = (GuestDao)applicationContext.getBean(GuestDao.class);
		
		//System.out.println(guestDao.selectAll());
		
		//System.out.println(guestDao.selectByNo(523));
		
		//Guest guest = new Guest(0, "mon", null, "mon@itwill.com", "ho", "ti", "co");
		//System.out.println(guestDao.insertGuest(guest));
		
		//Guest upGuest = new Guest(524, "월", null, "요일", "테", "스", "트");
		//System.out.println(guestDao.updateGuest(upGuest));
			
		//System.out.println(guestDao.deleteGuest(524));
	}

}
