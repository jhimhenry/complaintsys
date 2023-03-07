/**Implemented by Ntini Edwards
 * ID: 1904701*/
package model;

import java.io.Serializable;

public class Staff implements Serializable{
	private String staffId;
	private String staffPw;
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
