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
		//user.setUserId(1);
		user.setUserName("Arjun Rao");
		UserDetails user2 = new UserDetails();
		user2.setUserName("siddharth");
		/*user.setAddress("My home address");
		user.setJoinDate(new Date());
		user.setDescription("Description of the user goes hear");
		
	*/
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		
		session.getTransaction().commit();
		session.close();
		
		/*user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("The object retrieved from the database is "+user.getUserName());
		
		*/
		
	}

}
