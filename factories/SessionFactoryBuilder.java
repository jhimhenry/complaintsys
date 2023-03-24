package factories;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder {
	private static SessionFactory session = null;
	
	public static SessionFactory getSessionFactory() throws HibernateException
	{
			if(session == null)
			{
				session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass
						(Student.class).buildSessionFactory();
			}
		return session;
	}
	public static void closeSessionFactory()
	{
		if(session == null)
		{
			session.close();
		}
	}
	
	


}
