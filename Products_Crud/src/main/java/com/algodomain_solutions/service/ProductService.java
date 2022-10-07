package com.algodomain_solutions.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algodomain_solutions.entity.Charges;
import com.algodomain_solutions.entity.Product;

@Service
@Transactional
public interface ProductService {
	
	Product createProduct(Product product);
	Product updateProduct(Product product);
	List<Product>getAllProduct();
	Product getProductById(Long pId );
	void deleteProductById(Long pId);
	
	




}
 