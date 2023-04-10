package other;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class missFunc {
	
	//insert into controller/helper class to count elements in the database
	/*private int countComplaints() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Complaint comp = (Complaint) session.get(Complaint.class, this.id);
		session.count(q);
		transaction.commit();
		session.close()		
	}
	
	private int countQueries() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query q  = (Query) session.get(Query.class, this.id);
		session.count(q);
		transaction.commit();
		session.close();		
	}*/

}
