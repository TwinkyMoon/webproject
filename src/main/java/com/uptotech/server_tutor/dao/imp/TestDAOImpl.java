package com.uptotech.server_tutor.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uptotech.server_tutor.dao.TestDAO;
import com.uptotech.server_tutor.model.EnglishCategory;
import com.uptotech.server_tutor.model.EnglishWord;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "testDAO")
public class TestDAOImpl implements TestDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<EnglishWord> getInstances() {
		/*
		 * String url = "jdbc:mysql://" + "127.10.221.130" + ":" + "3306" + "/"
		 * + "basictutor"; String user = "adminTVitrUP"; String password =
		 * "n-WzIMwcQDcQ";
		 * 
		 * // Load the Connector/J driver try {
		 * Class.forName("com.mysql.jdbc.Driver").newInstance(); } catch
		 * (InstantiationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } // Establish connection to MySQL Connection
		 * conn = null; try { conn = DriverManager.getConnection(url, user,
		 * password); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		Session session = sessionFactory.getCurrentSession();
		
		return (ArrayList<EnglishWord>) session.createCriteria(EnglishWord.class).list();

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<EnglishCategory> getCategoryInstances() {
		Session session = sessionFactory.getCurrentSession();
		return (ArrayList<EnglishCategory>) session.createCriteria(EnglishCategory.class).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<EnglishWord> getWordInstances(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(EnglishWord.class);
		cr.add(Restrictions.eq("categoryId", categoryId));
		return (ArrayList<EnglishWord>) cr.list();
	}

}
