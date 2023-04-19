package factories;
import model.Student;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.logging.log4j.LogManager;

public class SessionFactoryBuilder {
	private static SessionFactory session = null;
	
	public static final Logger log = LogManager.getLogger(DBConnection.class);
	
	public static SessionFactory getSessionFactory() throws HibernateException
	{
			if(session == null)
			{
				session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass
						(Student.class).buildSessionFactory();
				log.info("Starting session");
			}
		return session;
	}
	public static void closeSessionFactory()
	{
		if(session == null)
		{
			log.info("Closing session");
			session.close();
		}
	}
	
	


}
