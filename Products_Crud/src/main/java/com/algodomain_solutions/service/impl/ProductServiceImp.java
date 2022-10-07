package com.algodomain_solutions.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.algodomain_solutions.service.ProductService;
import com.algodomain_solutions.entity.Product;
import com.algodomain_solutions.exception.ResourceNotFoundException;
import com.algodomain_solutions.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
	
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> productDb = Optional.ofNullable(this.productRepository.getById(product.getpId()));
		if(productDb.isPresent())
		{
			Product  productUpdate = productDb.get() ;
			productUpdate.setpId(product.getpId());
			productUpdate.setPname(product.getPname());
			productUpdate.setProductType(product.getProductType());
			productUpdate.setProductCategory(product.getProductCategory());
			productUpdate.setProductPrice(product.getProductPrice());
			return productUpdate;
		}
		else {
			throw new ResourceNotFoundException("Product not found with pid" + product.getpId());
		}
		
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();	}

	@Override
	public Product getProductById(Long pId) {
		// TODO Auto-generated method stub
		Optional<Product> productDb =this.productRepository.findById((long) pId);
		if(productDb.isPresent()) {
			return productDb.get();
		}
		else {
			throw new ResourceNotFoundException("Product not found with pid" + pId);
		}
	}

	@Override
	public void deleteProductById(Long pId) {
	
		Optional<Product> productDb = this.productRepository.findById((long) pId);
		
		if(productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		}
		else {
			throw new ResourceNotFoundException("Product not found with pid" + pId);
		  }
	    }

	
	}
  
	


