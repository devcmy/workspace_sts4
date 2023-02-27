package com.itwill.guest.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.guest.dao.mybatis.Guest;

public interface GuestMapper {
	
	@Select("select * from guest")
	public List<Guest> selectAll();
	
	@Select("select * from guest where guest_no=#{guestNo}")
	public Guest selectByNo(Integer no);
	
	@Insert("insert into guest values(guest_no_seq.nextval,#{guest_name},sysdate,#{guest_email},#{guest_homepage},#{guest_title},#{guest_content})")
	public int insertGuest(Guest guest);
	@Update(" update guest set guest_name=#{guest_name},guest_email=#{guest_email},"
			+ "    guest_homepage=#{guest_homepage},guest_title=#{guest_title},"
			+ "    guest_content=#{guest_content} where guest_no=#{guest_no}")
	public int updateGuest(Guest guest);
	
	@Delete(" delete from guest where guest_no=#{guest_no}")
	public int deleteGuest(Integer no);
	

}
