/**Implemented by Ntini Edwards
 * ID: 1904701*/
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;

import factories.SessionFactoryBuilder;


import javax.persistence.*;
import javax.persistence.Table;
import java.util.*;
import org.hibernate.Session;

@Entity 
@Table(name="Staff")


public class Staff implements Serializable{
	@ID
	@Column(name="ID")
	private String staffId;
	@Column(name="Password")
	private String staffPw;
	@Column (name="Postion")
	private String position;
	
	//default constructor
	public Staff() {
		this.staffId = " ";
		this.staffPw = " ";
		this.position = " ";
	}

	//primary constructor
	public Staff(String staffId, String staffPw, String position) {
		this.staffId = staffId;
		this.staffPw = staffPw;
		this.position = position;
	}
	
	//copy constructor
	public Staff(Staff obj) {
		this.staffId = obj.staffId;
		this.staffPw = obj.staffPw;
		this.position = obj.position;
	}
	
	//Accessors and Mutators
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffPw() {
		return staffPw;
	}

	public void setStaffPw(String staffPw) {
		this.staffPw = staffPw;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public void update() {
		Session session =
				SessionFactoryBuilder 
				.getSessionFactory()
				.getCurrentSession();
		
		Transaction transaction =session.beginTransaction();
		Staff staff=(Staff)session.get(Staff.class,this.staffId);
		staff.setPosition(position);
		staff.setStaffPw(staffPw);
		session.update(staff);
		transaction.commit();
		session.close();
		
		 @SuppressWarnings("unchecked")
			public List<Staff> readAll()
			 {
				 List<Staff> staffList = new ArrayList<>();
				 Session session = 
						 SessionFactoryBuilder
						 .getSessionFactory()
						 .getCurrentSession();
				 Transaction transaction = session.beginTransaction();
				 staffList = (List<Staff>) session.createQuery("FROM Staff")
						 .getResultList();
				 transaction.commit();
				 session.close();
				 
				 return staffList;
			 }
			 public void delete()
			 {
				 Session session = 
						 SessionFactoryBuilder
						 .getSessionFactory()
						 .getCurrentSession();
				 Transaction transaction = session.beginTransaction();
				 Staff staff= (Staff) session.get(Staff.class,this.staffId);
				 session.delete(staff);
				 transaction.commit();
				 session.close();
			 } 
	
	
	
	
	
	
	//toString method
	@Override
	public String toString() {
		return "Staff Details:"
				+"\nID: " + staffId 
				+"\nPosition: " + position + "\n********************************\n";
	}

	public static void main(String[] args) {
		Staff s = new Staff("10001", "741589", "Advisor");
		String w = s.toString();
		System.out.println(w);
	}

	

}
