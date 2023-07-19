package com.tmf.spring.demo.spring_hibernate_integration.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tmf.spring.demo.spring_hibernate_integration.models.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sf;
	
	public Session getSession() {
		return sf.getCurrentSession();
	}
	@Override
	public void addProduct(Product pro) {
		getSession().save(pro);
		
	}

	@Override
	public List<Product> displayAllProducts() {
		return getSession().createQuery("from Product").list();
	}

	@Override
	public Product displayProductById(long ProductId) {
		return getSession().get(Product.class,ProductId);
	}

	@Override
	public List<Product> displayAllProductByCategory(String category) {
		return null;
	}

	@Override
	public void updateProduct(Product pro) {
		getSession().merge(pro);
	}

	@Override
	public void deleteProduct(Product pro) {
		getSession().delete(pro);

	}

}
