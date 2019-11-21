package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static Map<String, Product> productRepo = new HashMap<String, Product>();
	
	static {
		Product honey = new Product();
		honey.setName("Honey");
		honey.setId("1");
		productRepo.put(honey.getId(), honey);
		
		Product almond = new Product();
		honey.setName("Almond");
		honey.setId("2");
		productRepo.put(honey.getId(), honey);
	}

	@Override
	public void createProduct(Product product) {
		productRepo.put(product.getId(), product);

	}

	@Override
	public void upadteProduct(String id, Product product) {
		productRepo.put(id, product);

	}

	@Override
	public void deleteProduct(String id) {
		productRepo.remove(id);

	}

	@Override
	public Collection<Product> getProducts() {
		return productRepo.values();
	}

}
