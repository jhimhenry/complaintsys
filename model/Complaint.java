/**Name: Ntini Edwards 
 * ID:1904701*/
package model;

import java.io.Serializable;

public class Complaint implements Serializable{
	private String compType;
	private String compDetails;
	private boolean compResolved; //may be included in relationship, still working on this
	//private Date queryResDate; //date class to be created d/m/y or import date
	private String compResDate;//may be in relationship
	private String compResponder;//to be modified, should take staff id
	
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
	
	public static void main(String[] args) {
		Complaint c = new Complaint("Blank timetable", "I see nothing", true, "March 4, 2023", "789624");
		String w = c.toString();
		System.out.println(w);
	}

}
