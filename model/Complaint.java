/**Name: Ntini Edwards 
 * ID:1904701*/
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

//@Entity
@Table (name="Complaint")

public class Complaint implements Serializable{
	@Column (name="CompType")
	private String compType;
	@Column (name="CompDetails")
	private String compDetails;
	@Column (name="CompResolved")
	private boolean compResolved; //may be included in relationship, still working on this
	@Column(name="CompResDate")
	//private Date queryResDate; //date class to be created d/m/y or import date
	private String compResDate;//may be in relationship
	@Column(name="CompResponder")
	private String compResponder;//to be modified, should take staff id
	
	public static final Logger log = Logger.getLogger(Complaint.class);
	
	//default constructor
	public Complaint() {
		this.compType = " ";
		this.compDetails = " ";
		this.compResolved = false;
		this.compResDate = " ";
		this.compResponder = " ";
	}
	//primary constructor
	public Complaint(String compType, String compDetails, boolean compResolved, String compResDate,
			String compResponder) {
		this.compType = compType;
		this.compDetails = compDetails;
		this.compResolved = compResolved;
		this.compResDate = compResDate;
		this.compResponder = compResponder;
	}

	//copy constructor
	public Complaint(Complaint obj) {
		this.compType = obj.compType;
		this.compDetails = obj.compDetails;
		this.compResolved = obj.compResolved;
		this.compResDate = obj.compDetails;
		this.compResponder = obj.compResponder;
	}

	//Accessors and Mutators
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
	public String getCompDetails() {
		return compDetails;
	}
	public void setCompDetails(String compDetails) {
		this.compDetails = compDetails;
	}
	public boolean isCompResolved() {
		return compResolved;
	}
	public void setCompResolved(boolean compResolved) {
		this.compResolved = compResolved;
	}
	public String getCompResDate() {
		return compResDate;
	}
	public void setCompResDate(String compResDate) {
		this.compResDate = compResDate;
	}
	public String getCompResponder() {
		return compResponder;
	}
	public void setCompResponder(String compResponder) {
		this.compResponder = compResponder;
	}
	
	@Override
	public String toString() {
		return "Complaint Details:"
				+"\nType: " + compType 
				+ "\nDetails: " + compDetails 
				+ "\nResolved? " + compResolved
				+ "\nDate Resolved: " + compResDate 
				+ "\nResponder: " + compResponder + "\n**************************\n";
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
		log.info("Lodging a complaint");
		session.close();
	}
	
	public void update()
	{
		Session session = 
				SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		Complaint complaint = (Complaint) session.get(Complaint.class, this.co);

     complaint.setCompDetails(this.compDetails);
	 complaint.setCompResDate(this.compResDate);
	 complaint.setCompResolved(this.compResolved);
	 complaint.setCompResponder(this.compResponder);

		
		session.update(complaint);
		transaction.commit();
		log.info("Updating a complaint");
		session.close();
	}
	
	@SuppressWarnings("unchecked")
   public List<Complaint> readAll()
	{
		List<Complaint> complaintList = new ArrayList<>();
		Session session = 
				SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		complaintList = (List<Complaint>) session.createQuery("FROM Complaint")
				.getResultList();
		log.info("Listing complaints");
		transaction.commit();
		session.close();
		
		return complaintList;
	}
	public void delete()
	{
		Session session = 
				SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Student stu = (Complaint) session.get(Complaint.class,this.//studentId);
		session.delete(stu);
		log.info("Deleting a complaint");
		transaction.commit();
		session.close();
	} 
	
	public static void main(String[] args) {
		Complaint c = new Complaint("Blank timetable", "I see nothing", true, "March 4, 2023", "789624");
		String w = c.toString();
		System.out.println(w);
	}

}
