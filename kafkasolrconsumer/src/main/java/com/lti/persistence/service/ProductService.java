package com.lti.persistence.service;

import com.lti.model.ProductData;
import com.lti.persistence.document.Product;

public interface ProductService {
	public void save(ProductData productData);
	
	public Iterable<Product> findAll();
}
