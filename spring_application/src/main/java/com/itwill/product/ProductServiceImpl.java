package com.itwill.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("productService")
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	
	//1. 생성자에서 생성
	public ProductServiceImpl() {
		//productDao=new ProductDaoImpl();
		System.out.println("2.#### ProductServiceImpl()생성자:"+this);
	}
	//2. 외부에서 DAO참조받아서 넣는법(둘중하나 SELECT) - 생성시에 의존성 객체 주입
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		System.out.println("2.#### ProductServiceImpl("+productDao+")생성자:"+this);
		this.productDao=productDao;
	}
	
	
	//1->3.기본생성자에서 생성후, setter에서 의존성 객체 인자로 주입받음
	@Override
	public void setProductDao(ProductDao productDao) {
		System.out.println("3.#### ProductServiceImpl.setProductDao("+productDao+")호출");
		this.productDao = productDao;
	}
	@Override
	public List<Product> productList(){
		return productDao.productList();
	}
	@Override
	public Product productDetail(int p_no) {
		return productDao.productDetail(p_no);
	}
}
