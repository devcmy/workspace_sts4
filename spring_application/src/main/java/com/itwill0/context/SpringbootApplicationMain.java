package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.product.ProductService;

@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.product") 
public class SpringbootApplicationMain {

public static void main(String[] args) {
	//spring"boot"application은 클래스자체가 설정파일.
	ApplicationContext applicationContext= SpringApplication.run(SpringbootApplicationMain.class, args);
	
	//applicationcontext 가 실행되면서 @어노테이션 찾고, 해줌
	
	
	ProductService productSerivce=
			(ProductService)applicationContext.getBean("productService");
	
	System.out.println(productSerivce.productList());
	System.out.println(productSerivce.productDetail(321));
	
}

}
