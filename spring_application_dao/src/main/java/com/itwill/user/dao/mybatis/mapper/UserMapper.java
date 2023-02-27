package com.itwill.user.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.dao.mybatis.User;

public interface UserMapper {
	
	@Insert("insert into userinfo values(#{userId}, #{password}, #{name}, #{email})")
	public int create(User user);
	@Update("update userinfo set password=#{password}, name=#{name}, email=#{email} where userid=#{userId}")
	public int update(User user);
	
	@Delete("delete from userinfo where userid=#{userId}")
	public int remove(String userId);
	
	@Select("select * from userinfo where userid=#{userId}")
	public User findUser(String userId);
	
	@Select("select * from userinfo")
	public List<User> findUserList();
	
	@Select("select count(*) cnt from userinfo where userid=#{userId}")
	public boolean existedUser(String userId);

}
