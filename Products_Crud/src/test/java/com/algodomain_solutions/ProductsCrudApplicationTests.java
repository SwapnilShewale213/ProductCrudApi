package com.algodomain_solutions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algodomain_solutions.entity.Product;
import com.algodomain_solutions.repository.ProductRepository;

@SpringBootTest
class ProductsCrudApplicationTests {
    @Autowired
	ProductRepository productRepository;   
	
    
    //Test for add products 
	@Test 
	public void testCreateProduct() {
		 Product product = new Product();
		 product.setpId(20l);
		 product.setPname("OnePlus7");
		 product.setProductCategory("Electronics");
		 product.setProductPrice(30000);
		 product.setProductType("SmartPhone");
		 product.setDiscount(2340);
		 productRepository.save(product);
		 assertNotNull(productRepository.findAll().get(0));
	}
	
	//test for update products
    @Test 
    public void testUpdateProduct() {
    	
    	Product product = new Product();
    	product.setpId(3l);
    	product.setPname("Acer");
    	product.setProductCategory("Electronics");
    	product.setProductPrice(44000);
    	product.setProductType("Laptop");
    	product.setDiscount(2456);
    	productRepository.save(product);
    	assertNotNull(productRepository.save(product).getpId());
    }
    
    
    //test for delete products
    @Test 
    public void testDeleteProduct() {
    	
    	Product product = new Product();
    	product.setpId(13l);
    	product.setPname("OnePlus7");
    	product.setProductCategory("Electronics");
    	product.setProductPrice(30000);
    	product.setProductType("SmartPhone");
    	product.setDiscount(2340);
    	productRepository.delete(product);
    	
    }
 
}
