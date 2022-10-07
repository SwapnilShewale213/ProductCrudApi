package com.algodomain_solutions.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.algodomain_solutions.entity.Product;
import com.algodomain_solutions.service.ProductService;

/*
 * @Developed by Swapnil Shewale
 *  4 Oct 2022 
 */


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")   
	public ResponseEntity<List<Product>> getAllProduct(){
		
		return ResponseEntity.ok().body(productService.getAllProduct()); 
	}
	
	@GetMapping("/products/{pId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long pId){
		
		return ResponseEntity.ok().body(this.productService.getProductById(pId));	
		
	}      
	
	
	@PostMapping( value="/products" , consumes ="application/json" , produces="application/json")
	
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}
	
	
	@PutMapping( value = "products/{pId}" , consumes="application/json", produces="application/json")
	public ResponseEntity<Product> updateProduct
	(@PathVariable Long pId , @RequestBody Product product){
		product.setpId(pId);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}
	
	@DeleteMapping(value="products/{pId}")
	public HttpStatus deleteProduct(@PathVariable Long pId) {
		this.productService.deleteProductById(pId);
		return HttpStatus.OK;
	 }
	}
	
	

    