/**Implemented by Ntini Edwards
 * ID: 1904701*/
package model;

import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.annotations.Entity;

import com.sun.istack.internal.logging.Logger;

import factories.SessionFactoryBuilder;
import model.Student;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.*;
import org.hibernate.Session;

@Table(name="Query")

public class Query implements Serializable{
	@Column (name="QueryType")
	private String queryType;
	@Column (name="QueryDetails")
	private String queryDetails;
	@Column(name="QueryResolved")
	private boolean queryResolved; //may be included in relationship, still working on this
	//private Date queryResDate; //date class to be created d/m/y or import date
	@Column(name="QueryResDate")
	private String queryResDate;//may be in relationship
	@Column(name="QueryResponser")
	private String queryResponder;//to be modified, should take staff id
	
	public static final Logger log = Logger.getLogger(Query.class);
	 
	//default constructor
	public Query() {
		this.queryType = " ";
		this.queryDetails = " ";
		this.queryResolved = false;
		this.queryResDate = " ";
		this.queryResponder = " ";
	}
	
	//primary constructor
	public Query(String queryType, String queryDetails, boolean queryResolved, String queryResDate,
			String queryResponder) {
		this.queryType = queryType;
		this.queryDetails = queryDetails;
		this.queryResolved = queryResolved;
		this.queryResDate = queryResDate;
		this.queryResponder = queryResponder;
	}
	
	//copy constructor
	public Query(Query obj) {
		this.queryType = obj.queryType;
		this.queryDetails = obj.queryDetails;
		this.queryResolved = obj.queryResolved;
		this.queryResDate = obj.queryResDate;
		this.queryResponder = obj.queryResponder;
	}
	
	//accessors and mutators
	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryDetails() {
		return queryDetails;
	}

	public void setQueryDetails(String queryDetails) {
		this.queryDetails = queryDetails;
	}

	public boolean isQueryResolved() {
		return queryResolved;
	}

	public void setQueryResolved(boolean queryResolved) {
		this.queryResolved = queryResolved;
	}

	public String getQueryResDate() {
		return queryResDate;
	}

	public void setQueryResDate(String queryResDate) {
		this.queryResDate = queryResDate;
	}

	public String getQueryResponder() {
		return queryResponder;
	}

	public void setQueryResponder(String queryResponder) {
		this.queryResponder = queryResponder;
	}

	@Override
	public String toString() {
		return "Query Details:" 
				+ "\nType: "+ queryType 
				+ "\nDetails: " + queryDetails 
				+ "\nResolved? " + queryResolved
				+ "\nDate Resolved: " + queryResDate 
				+ "\nResponder: " + queryResponder + "\n****************************\n";
	}

	public void create()
	{
		Session session = 
				SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		session.save(this);
		transaction.commit();
		log.info("Lodging a query");
		session.close();
	}
	
	public void update()
	{
		Session session = 
				SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		Query query= (Query) session.get(Query.class, this.queryType);

		query.setQueryDetails(this.queryDetails);
		query.setQueryResDate(this.queryResDate);
		query.setQueryResolved(this.queryResolved);
		query.setQueryResponder(this.queryResponder);
	
		session.update(query);
		transaction.commit();
		log.info("Updating a query");
		session.close();
	}
	
	@SuppressWarnings("unchecked")
   public List<Query> readAll()
	{
		List<Query> queryList = new ArrayList<>();
		Session session = 
				SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		queryList = (List<Query>) session.createQuery("FROM Query")
				.getResultList();
		transaction.commit();
		log.info("Listing queries");
		session.close();
		
		return queryList;
	}
/* 	public void delete()
	{
		Session session = 
				SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = (Query) session.get(Query.class,this.QueryId);
		session.delete(stu);
		transaction.commit();
		log.info("Deleting a query");
		session.close();
	} */

	public static void main(String[] args) {
		Query q = new Query("Lost Id", "Fell at the spin gate", true, "March 1, 2023",
				"100056");
		String w = q.toString();
		System.out.println(w);
	}

}
