package com.anurag.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.anurag.domain.Login;

public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	private final String VERIFICATION_AND_GET_ROLE=
			"SELECT userID,userRole FROM Login WHERE userName=:name AND password=:pwd";

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Login login(Login login) {
		// get Session
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(VERIFICATION_AND_GET_ROLE);
		query.setParameter("name", login.getUserName());
		query.setParameter("pwd", login.getPassword());
		Object[] objects=(Object[]) query.uniqueResult();
		if ( objects!=null) {
			login.setPassword(null);
			if (objects.length>0 ) {
				login.setUserID((Integer)objects[0]);
				login.setUserRole((String)objects[1]);
			}
		}
		return login;
	}
	
	

}
