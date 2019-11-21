package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceController.class);

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProducts() {
		log.info("get product");
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProducts(@PathVariable("id") String id, @RequestBody Product product) {
		log.info("update product with id : "+id);
		productService.upadteProduct(id, product);
		return new ResponseEntity<>("Product got updtaded successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id){
		log.info("delete product with id : "+id);
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product got deleted successfuly", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		log.info("create product");
		productService.createProduct(product);
		return new ResponseEntity<>("Product got created successfully", HttpStatus.CREATED);
	}

}
