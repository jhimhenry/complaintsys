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
	private JRadioButton supervisor;
	private JRadioButton advisor;
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
		logButton.setBounds(350,200,90,40);
		add(logButton);
		return logButton;
	}
	
	//Getters and Setters
	public JRadioButton getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(JRadioButton staff) {
		this.supervisor = staff;
	}
	
	public JRadioButton getAdvisor() {
		return advisor;
	}

	public void setAdvisor(JRadioButton staff) {
		this.advisor = staff;
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
		setLabel(label,"ID: ",280,50,250,20);
		setIDTF(new JTextField());
		getIDTF().setBounds(350,50,150,25);
		add(getLabel());
		add(getIDTF());
	}
	
	//add event listener to hide password input
	private void createPassword() {
		setLabel(label,"Password: ",280,80,250,20);
		password = new JTextField();
		password.setBounds(350,80,150,25);
		add(getLabel());
		add(password);			
	}

	private void createCategory() {
		ButtonGroup group = new ButtonGroup();//group to add radio buttons
		
		supervisor = new JRadioButton("Supervisor");
		advisor = new JRadioButton("Advisor");
		student = new JRadioButton("Student");
		supervisor.setBounds(370,110,150,25);
		advisor.setBounds(370,140,150,25);
		student.setBounds(370,170,150,25);
		
		group.add(supervisor);
		group.add(advisor);
		group.add(student);
		add(advisor);
		add(supervisor);
		add(student);		
	}

	public JTextField getIDTF() {
		return IDTF;
	}

	public void setIDTF(JTextField iDTF) {
		IDTF = iDTF;
	}
	

	/*public static void main(String[] args) {
		new Login();
	}*/

}
