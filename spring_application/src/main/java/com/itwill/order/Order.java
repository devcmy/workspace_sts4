package com.itwill.order;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data //Getter, Setter, equals, hashCode, toString 메서드를 자동으로 생성합니다.
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 자동으로 생성합니다.
@NoArgsConstructor //파라미터 없는 기본 생성자를 자동으로 생성합니다.
@ToString //toString 메서드를 자동으로 생성합니다.
public class Order {
	private int orderNo;
	private String orderTitle;
	private Date orderDate;
}
