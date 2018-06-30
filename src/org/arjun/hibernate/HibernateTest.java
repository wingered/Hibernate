package org.arjun.hibernate;

import java.util.Date;

import org.arjun.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		//first we need to inistiate the Data Transfer Object to create data
		
		UserDetails user = new UserDetails();
		
		user.setUserId(1);
		user.setUserName("Arjun Rao");
		user.setAddress("My home address");
		user.setJoinDate(new Date());
		user.setDescription("Description of the user goes hear");
		
	
		
		//now we need to save this user object to hibernate, using hibernate api, for this we need a session factory object
		//this session factory is defined in hibernate.cfg.xml 
		//sessionfactory object should be created just one for applicaiton and then for each time hiberante is acesses, we need to obtain a 
		//session objet and open a transaction
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		//this this point we have created a modle object and populated it and saved it in
		//postgres database
		//now lets retrieve that object back form database
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		//now we got the object
		System.out.println("The object retrieved from the database is "+user.getUserName());
		
		
		
	}

}
