package com.tmf.spring.demo.spring_hibernate_integration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmf.spring.demo.spring_hibernate_integration.dao.ProductDAO;
import com.tmf.spring.demo.spring_hibernate_integration.models.Product;

@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	private ProductDAO dao;
	
	@Override
	public void addProduct(Product pro) {
		dao.addProduct(pro);
	}

	@Override
	public List<Product> displayAllProducts() {
		return dao.displayAllProducts();
	}

	@Override
	public Product displayProductById(long ProductId) {
		return dao.displayProductById(ProductId);
	}

	@Override
	public List<Product> displayAllProductByCategory(String category) {
		return dao.displayAllProductByCategory(category);
	}

	@Override
	public void updateProduct(Product pro) {
		dao.updateProduct(pro);

	}

	@Override
	public void deleteProduct(Product pro) {
		dao.deleteProduct(pro);

	}

}
