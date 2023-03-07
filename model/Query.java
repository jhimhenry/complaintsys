/**Implemented by Ntini Edwards
 * ID: 1904701*/
package model;

import java.io.Serializable;

public class Query implements Serializable{
	private String queryType;
	private String queryDetails;
	private boolean queryResolved; //may be included in relationship, still working on this
	//private Date queryResDate; //date class to be created d/m/y or import date
	private String queryResDate;//may be in relationship
	private String queryResponder;//to be modified, should take staff id
	 
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

	public static void main(String[] args) {
		Query q = new Query("Lost Id", "Fell at the spin gate", true, "March 1, 2023",
				"100056");
		String w = q.toString();
		System.out.println(w);
	}

}
