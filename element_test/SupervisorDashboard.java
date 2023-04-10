package com.element_test;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SupervisorDashboard extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextArea message;
	
	public SupervisorDashboard() {		
		//Create and add form fields
		createLabel();
		
		createMessage();
		//Setting frame properties
		setSize(500,500);
		setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@SuppressWarnings("unused") JButton createButton(JButton regButton, String title, int x, int y, int w, int h) {
		regButton = new JButton(title);
		regButton.setBounds(x,y,w,h);
		add(regButton);
		return regButton;
	}
	
	private void createMessage() {
		int queries = 0;//equate to result from the helper class count
		int complaints = 0;//equate to result from helper class count
		//TODO insert code to count entries in database
		message = new JTextArea("Hello Student Services Supervisor.\nThis is your operations dashboard."
											+ "\nHere you can provide various services to students and Student Services Advisors.\n"
											+ "These services include: assigning a student issue to an advisor and viewing past student issues."
											+ "\n Feel free to explore\n\n\n\n\n"
											+ "Total # Queries Made: "+queries
											+ "Total # Complaints Made: "+complaints);
		message.setBounds(90,70,600,80);
		message.setEditable(false);
		add(message);
	}
	
	//or put count here
	//a method to provide a summary of student issuess
	private void countIssues() {
		
	}

	//Getter and setter for label	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label,String labelText, int x, int y, int w, int h) {
		this.label = new JLabel(labelText);
		this.label.setBounds(x, y, w, h);		
	}
	
	private void createLabel() {
		setLabel(label,"Student Services Supervisor Dashboard ",50,50,250,20);
		add(getLabel());
	}
}
