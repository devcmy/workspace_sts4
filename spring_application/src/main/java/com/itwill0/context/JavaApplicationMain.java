package com.itwill0.context;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductDaoImpl;
import com.itwill.product.ProductService;
import com.itwill.product.ProductServiceImpl;

public class JavaApplicationMain {
	public static void main(String[] args) {
		/*******************case1***************************/
		ProductDao productDao = new ProductDaoImpl();
		ProductService productService = new ProductServiceImpl();
		
		System.out.println(productService.productList());
	}
}
