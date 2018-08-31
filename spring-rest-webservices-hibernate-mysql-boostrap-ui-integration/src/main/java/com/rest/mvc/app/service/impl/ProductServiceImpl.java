package com.rest.mvc.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.mvc.app.bean.Product;
import com.rest.mvc.app.dao.ProductDao;
import com.rest.mvc.app.service.ProductService;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	public long save(Product product) {
		return productDao.save(product);
	}

	public Product get(long id) {
		return productDao.get(id);
	}

	public List<Product> list() {
		return productDao.list();
	}

	public Product update(long id) {
		return productDao.update(id);
	}

	public boolean delete(long id) {
		return productDao.delete(id);
	}

}
