package com.lti.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.ProductData;
import com.lti.persistence.document.Product;
import com.lti.persistence.repository.ProductRepository;

@Service
public class ProductImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void save(ProductData productData) {
		Product product = new Product();
		
		product.setId(productData.getId());
		product.setName(productData.getName());
		
		productRepository.save(product);
	}

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
}
