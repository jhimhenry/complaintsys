package com.element_test;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField IDTF;
	private JTextField password;
	private JRadioButton staff;
	private JRadioButton student;
	
	public Login() {
		setName("Complaint System Login");//JFrame title
		
		//Create and add form fields
		createID();		
		createPassword();
		createCategory();
		
		//Setting frame properties
		setSize(500,500);
		setLayout(null);
		setVisible(true);
	}
	
	JButton createButton(JButton logButton) {
		logButton = new JButton("Login");
		logButton.setBounds(200,190,90,40);
		add(logButton);
		return logButton;
	}
	
	//Getters and Setters
	public JRadioButton getStaff() {
		return staff;
	}

	public void setStaff(JRadioButton staff) {
		this.staff = staff;
	}

	public JRadioButton getStudent() {
		return student;
	}

	public void setStudent(JRadioButton student) {
		this.student = student;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label,String labelText, int x, int y, int w, int h){
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
	
	//add event listener to hide password input
	private void createPassword() {
		setLabel(label,"Password: ",50,80,250,20);
		password = new JTextField();
		password.setBounds(180,80,150,25);
		add(getLabel());
		add(password);			
	}

	private void createCategory() {
		ButtonGroup group = new ButtonGroup();//group to add radio buttons
		
		staff = new JRadioButton("Staff");
		student = new JRadioButton("Student");
		staff.setBounds(180,110,150,25);
		student.setBounds(180,140,150,25);
		
		group.add(staff);
		group.add(student);
		add(staff);
		add(student);		
	}
	

	/*public static void main(String[] args) {
		new Login();
	}*/

}
