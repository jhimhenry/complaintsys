/**Completed by Ntini Edwards
 * ID: 1904701*/
package model;

import java.io.Serializable;

public class Student implements Serializable{
	private String studentId;
	private String sFirstName;
	private String sLastName;
	private String studentEmail;
	private String studentContact;
	private String studentPw;
	
	//default constructor
	public Student() {
		this.studentId = " ";
		this.sFirstName = " ";
		this.sLastName = " ";
		this.studentEmail = " ";
		this.studentContact = " ";
		this.studentPw = " ";
	}
	
	//primary constructor
	public Student(String studentId, String sFirstName, String sLastName, String studentEmail, String studentContact,
			String studentPw) {
		//will be modified later on i.e. password option may be removed
		this.studentId = studentId;
		this.sFirstName = sFirstName;
		this.sLastName = sLastName;
		this.studentEmail = studentEmail;
		this.studentContact = studentContact;
		this.studentPw = studentPw;
	}
	
	//copy constructor
	public Student(Student obj) {
		this.studentId = obj.studentId;
		this.sFirstName = obj.sFirstName;
		this.sLastName = obj.sLastName;
		this.studentEmail = obj.studentEmail;
		this.studentContact = obj.studentContact;
		this.studentPw = obj.studentPw;
	}
	
	//Constructor to write student emails
	public Student(String studentId, String email) {
		this.studentId = studentId;
		this.sFirstName = studentEmail;
	}
	
	//method to write student contact
	public void StudentContact(String studentId, String studentContact) {
		this.studentId = studentId;
		this.sFirstName = studentContact;
	}
	
	//method to allow student to login
	public void StudentAccess(String studentId, String studentPw) {
		//will be modified later on
		this.studentId = studentId;
		this.studentPw = studentPw;
	}

	//Accessors and Mutators
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getsFirstName() {
		return sFirstName;
	}

	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}

	public String getStudentPw() {
		return studentPw;
	}

	public void setStudentPw(String studentPw) {
		this.studentPw = studentPw;
	}

	@Override
	public String toString() {
		return "Student Details:\n"
				+ "ID: "+ studentId 
				+ "\nName: " + sFirstName + " " + sLastName
				+ "\nEmail: " + studentEmail 
				+ "\nContact: " + studentContact + "\n***************************\n";
	}
	
	public static void main(String[] args) {
		Student s = new Student("144444", "John", "Doe", "jdoe@utech.edu.jm", "876458741", "123456789" );
		String w = s.toString();
		System.out.println(w);
	}

}
