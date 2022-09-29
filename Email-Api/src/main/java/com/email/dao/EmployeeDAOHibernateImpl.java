package com.email.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.email.entity.EmailContent;
import com.email.entity.EmailParameters;
import com.email.entity.EmailSubject;
import com.email.entity.EmailUser;

import org.apache.log4j.Logger; 

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	 static Logger log = Logger.getLogger(EmployeeDAOHibernateImpl.class.getName());  

	
	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EmailUser findEmailByUsername(String username) {
		log.info("here usernamne=="+username);
        Session currentSession =  entityManager.unwrap(Session.class);
        EmailUser emailUser = currentSession.get(EmailUser.class, username);
		return emailUser;
	}



	@Override
	public List<EmailSubject> findByEmailId(String subject) {
		 Session currentSession =  entityManager.unwrap(Session.class);
		 Query<EmailSubject> query =  currentSession.createQuery("from EmailSubject where subjectTopic=:subject", EmailSubject.class);
		 query.setParameter("subject", subject);
		 List<EmailSubject> emailSubject = query.getResultList();
		 return emailSubject;
	}

	@Override
	public EmailContent findByConentId(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		EmailContent content = currentSession.get(EmailContent.class, theId);
		return content;
	}



	@Override
	public List<EmailParameters> findByKey(String value) {
		Session currentSession =  entityManager.unwrap(Session.class);
		 Query<EmailParameters> query =  currentSession.createQuery("from EmailParameters where emailValue=:subject", EmailParameters.class);
		 query.setParameter("subject", value);
		 List<EmailParameters> emailParam = query.getResultList();
	
		return emailParam;
	}
	
	

}

