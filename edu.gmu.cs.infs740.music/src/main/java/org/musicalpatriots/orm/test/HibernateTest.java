package org.musicalpatriots.orm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.musicalpatriots.orm.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component(value="hibernateTest")
public class HibernateTest {
	
	public int id;
	
	@PersistenceContext
	EntityManager em;
	
	public HibernateTest() {
		id = 101;
	}

	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("datasource-context.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("persistence-context.xml");
		//ctx = new ClassPathXmlApplicationContext("persistence-context.xml");
		
		HibernateTest ht = (HibernateTest) ctx.getBean("hibernateTest");
		
		System.out.print(ht.id);
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("music_persistence_unit");
//		EntityManager em = emf.createEntityManager();
		try {
			UserEntity ue = ht.em.find(UserEntity.class, new Long(1));
			System.out.println(ue.getFullName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
		String sql = "insert into user (username,full_name,password) values ('jim','bobo','cake');";
		
		
//		user.setFullName("Harry Barry");
//		user.setUsername("harry@bobo.com");
//		
//		@SuppressWarnings("deprecation")
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(user);
//		session.getTransaction().commit();
	}

}
