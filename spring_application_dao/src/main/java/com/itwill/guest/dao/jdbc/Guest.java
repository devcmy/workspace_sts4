package com.itwill.guest.dao.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
	private int guest_no; //이름이 다르면 BeanPropertyRowMapper 자동으로 못만들어준다(객체생성은 o,  데이터 받아오진못함) -> custom해줘야한다.
	private String guest_name; //Camel케이스로 작성해도, snake케이스로 변환해준다.
	private String guest_date;
	private String guest_email;
	private String guest_homepage;
	private String guest_title;
	private String guest_content;
}
