package com.jkxy.tang.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.tang.dao.IPoetryDAO;
import com.jkxy.tang.entity.Poetry;

public class PoetryDAO implements IPoetryDAO {
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List getAllByName(String name) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Poetry p where p.poet.name=:name");
		query.setString("name", name);
		List peotries=query.list();
		ts.commit();
		session.close();
		
		return peotries;
	}

	@Override
	public Poetry getByTitle(String title) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Poetry p where p.title=:title");
		query.setString("title", title);
		Poetry poetry=(Poetry) query.list().get(0);
		ts.commit();
		session.close();
		
		return poetry;
	}

	@Override
	public Poetry getByContent(String content) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Poetry p where p.content like :content");
		query.setString("content", "%"+content+"%");
		query.setMaxResults(1);
		Poetry poetry=(Poetry) query.list().get(0);
		ts.commit();
		session.close();
		
		return poetry;
	}

}
