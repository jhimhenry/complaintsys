package com.element_test;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//TODO change inheritance to JPanel for card layout
public class RegisterStaff extends JFrame{
	private JButton regButton;
	private JLabel label;
	private JTextField IDTF;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JRadioButton posAdvisor;
	private JRadioButton posSupervisor;
	private JTextField passwordTF;
	
	public RegisterStaff() {
		setTitle("Complaint System Registration");//JFrame title
		
		//Create and add form fields
		createID();		
		createFName();		
		createLName();		
		createPosition();	
		createPassword();		
		createButton();
		
		//Setting frame properties
		setSize(500,500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private void createButton() {
		regButton = new JButton("Save");
		regButton.setBounds(200,300,90,40);
		add(regButton);
	}

	//Getter and setter for label	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label,String labelText, int x, int y, int w, int h) {
		this.label = new JLabel(labelText);
		this.label.setBounds(x, y, w, h);		
	}
	
	private void createID() {
		setLabel(label,"ID: ",50,50,250,20);
		IDTF = new JTextField();
		IDTF.setBounds(180,50,150,25);
		add(getLabel());
		add(IDTF);
	}
		
	private void createFName() {
		setLabel(label,"First Name: ",50,80,250,20);
		firstNameTF = new JTextField();
		firstNameTF.setBounds(180,80,150,25);
		add(getLabel());
		add(firstNameTF);
	}
		
	private void createLName() {
		setLabel(label,"Last Name: ",50,110,250,20);
		lastNameTF = new JTextField();
		lastNameTF.setBounds(180,110,150,25);
		add(getLabel());
		add(lastNameTF);
	}
	
	private void createPosition() {
		ButtonGroup group = new ButtonGroup();//group to add radio buttons
		
		setLabel(label,"Position: ",50,140,250,20);
		posAdvisor = new JRadioButton("Advisor");
		posSupervisor = new JRadioButton("Supervisor");
		posAdvisor.setBounds(180,145,150,25);
		posSupervisor.setBounds(180,175,150,25);
		
		group.add(posAdvisor);
		group.add(posSupervisor);
		add(getLabel());
		add(posAdvisor);
		add(posSupervisor);		
	}
	
	private void createPassword() {
		setLabel(label,"New Password: ",50,200,250,20);
		JTextField pwTf = new JTextField();
		pwTf.setBounds(180,200,150,25);
		add(getLabel());
		add(pwTf);	
		setLabel(label,"Confirm Password: ",50,230,250,20);
		passwordTF = new JTextField();
		passwordTF.setBounds(180,230,150,25);
		add(getLabel());
		add(passwordTF);			
	}

	


	public static void main(String[] args) {
		new RegisterStaff();

	}

}
