package com.rest.mvc.app.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.mvc.app.bean.Product;
import com.rest.mvc.app.dao.ProductDao;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public long save(Product product) {
		Long flag = 0L;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(product);
		transaction.commit();
		flag = 1L;
		return flag;
	}

	public Product get(long id) {
		return(Product) sessionFactory.openSession().get(Product.class, id);
	}

	public List<Product> list() {
		Session session = sessionFactory.openSession();
		/*CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root);
		Query<Product> query = session.createQuery(cq);
		return query.getResultList();*/
		return session.createCriteria(Product.class).list();
	}

	public Product update(long id) {
		return null;
	}

	public boolean delete(long id) {
		boolean flag = false;
		Session session = sessionFactory.openSession();
		Product product = (Product) session.load(Product.class, id);
		session.delete(product);
		session.beginTransaction().commit();
		flag = true;
		System.out.println(flag);
		return flag;
		
	}

}
