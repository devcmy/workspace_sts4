package com.itwill1.bean.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;
import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;

/*
 * 현재 클래스가 위치하는 패키지와 하위패키지의 클래스의 @Annotation을 스캔해서 
 * 초기화(객체생성, 의존성 주입)	
 */
@SpringBootApplication
/*
 * @ComponentScan(basePackages = {"com.itwill.guest"})
 * @ComponentScan(value = {"com.itwill.guest"})
 */
@ComponentScan(basePackages = {"com.itwill.guest","com.itwill.user"}) //값만 넣어주면 default annotation이 value로 되어 있다. 여러주소(개) 쓰러면 윗방식과 같이 작성할것.
public class SpringBootBeanCreateApplicationMain {

	public static void main(String[] args) {
		System.out.println("-----Spring Container 초기화 시작[ApplicationContext객체생성 시작]-------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanCreateApplicationMain.class, args);
		System.out.println("-----Spring Container 초기화 끝[ApplicationContext객체생성 끝]-------");
		
		System.out.println("-----Container에 등록되어 있는 Spring Bean 참조 얻기-------");
		
		System.out.println("-----bean의 아이디로 Spring Container에 등록되어 있는 스프링빈 참조얻기-------");
		UserDao userDao1 = (UserDao)applicationContext.getBean("userDao");
		UserService userService1 = (UserService)applicationContext.getBean("userService");
		GuestDao guestDao1 = (GuestDao)applicationContext.getBean("guestDao");
		GuestService guestSerivce1 = (GuestService)applicationContext.getBean("guestService");
		System.out.println(userDao1);
		System.out.println(userService1);
		System.out.println(guestDao1);
		System.out.println(guestSerivce1);
		
		System.out.println("-----bean의 클래스로 Spring Container에 등록되어 있는 스프링빈 참조얻기-------");
		UserDao userDao2 = (UserDao)applicationContext.getBean(UserDao.class);
		UserService userService2 = (UserService)applicationContext.getBean(UserService.class);
		GuestDao guestDao2 = (GuestDao)applicationContext.getBean(GuestDao.class);
		GuestService guestSerivce2 = (GuestService)applicationContext.getBean(GuestService.class);
		System.out.println(userDao2);
		System.out.println(userService2);
		System.out.println(guestDao2);
		System.out.println(guestSerivce2);
		
		System.out.println("------bean의 scope[singleton]-----------"); //한개 만들어서 주기
		System.out.println(applicationContext.getBean(GuestDao.class));
		System.out.println(applicationContext.getBean(GuestDao.class));
		System.out.println(applicationContext.getBean(GuestService.class));
		System.out.println(applicationContext.getBean(GuestService.class));
		
		System.out.println("------bean의 scope[prototype]-----------"); //요청할때 마다 새로운 객체 만들어줌
		System.out.println(applicationContext.getBean(User.class)); //생성된게 다 다름
		System.out.println(applicationContext.getBean(User.class)); //생성된게 다 다름
		System.out.println(applicationContext.getBean(User.class)); //생성된게 다 다름
         		
		
	}

}
