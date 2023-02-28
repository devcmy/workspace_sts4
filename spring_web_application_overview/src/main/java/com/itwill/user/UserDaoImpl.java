package com.itwill.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository //만들어주는 태그(없으면 안됨)
public class UserDaoImpl implements UserDao {
	
	
	
	
	@Override
	public List<User> list() {
		List<User> userList = Arrays.asList(//list로 만들어주는 메소드
											new User(1,"김"),
											new User(2,"이"),
											new User(3,"박"),
											new User(4,"최"),
											new User(5,"정")
											); 
		return userList;
	}

}
