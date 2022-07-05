package com.lti.persistence.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.lti.persistence.document.Product;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

}
