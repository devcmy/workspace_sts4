package com.itwill.user.dao.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.user.dao.mybatis.mapper")
public class UserMapperTestMain  {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=SpringApplication.run(UserMapperTestMain.class, args);
		UserDao userDao = (UserDao)applicationContext.getBean(UserDao.class);
		
		//System.out.println(userDao.findUserList());
		
		//System.out.println(userDao.findUser("test88"));
		
		//User user = new User("new", "1234", "이름", "메일");
		//System.out.println(userDao.create(user));		
		
		//User upUser = new User("new", "4321", "name", "mail");
		//System.out.println(userDao.update(upUser));
		
		//Boolean isTrue = userDao.existedUser("new");
		//System.out.println("존재여부? : "+isTrue);
		
		//System.out.println(userDao.remove("new"));
	}

}
