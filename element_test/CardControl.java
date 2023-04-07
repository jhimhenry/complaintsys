/**Implemented by Ntini Edwards(1904701)
 * Card layout is used to switch between displays
 * Used to allow user to register/login and access dashboard*/
package com.element_test;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CardControl extends JFrame{
	private static final long serialVersionUID = 1L;
	CardLayout layout = new CardLayout();
	private JPanel parentPanel = new JPanel();//will be container for all JPanels
	private Login loginPanel = new Login();
	private RegisterStudent registerStudentPanel = new RegisterStudent();
	private RegisterStaff registerStaffPanel = new RegisterStaff();
	private StudentDashboard studentDashboardPanel = new StudentDashboard();
	private StaffDashboard staffDashboardPanel = new StaffDashboard();
	
	//buttons to control switching among panels
	private JButton loginButton = new JButton();
	private JButton registerStudButton = new JButton();
	private JButton registerStaffButton = new JButton();
	private JButton logoutButton = new JButton("Logout");
	
	public void initButtons() {
		loginButton = loginPanel.createButton(loginButton);
		registerStudButton = registerStudentPanel.createButton(registerStudButton);
		registerStaffButton = registerStaffPanel.createButton(registerStaffButton);
		studentDashboardPanel.add(logoutButton);
		staffDashboardPanel.add(logoutButton);
	}
	public CardControl() {
		//initialise buttons to control navigation
		initButtons();
		
		setTitle("UTech Complaint System");
		
		//set card layout for parent panel
		parentPanel.setLayout(layout);
		parentPanel.setSize(700, 700);	
		
		//action listeners on buttons allow changing visible panel
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO to complete login
				/**insert code to check if credentials exist
				 * if credentials exist, check if credentials are correct
				 * if correct, and staff is selected, proceed to 5
				 * if correct and student is selected, proceed to 4
				 * if incorrect clear 1, allow 3 tries
				 * if credentials do not exist and student is selected, redirect to 2
				 * if credentials do not exist and staff is selected, redirect to 3*/
	
				if(loginPanel.getStaff().isSelected()) {
					JOptionPane.showMessageDialog(null, "Staff Login Successful","Login Status", JOptionPane.INFORMATION_MESSAGE);
					layout.show(parentPanel, "5");						
				}
				if(loginPanel.getStudent().isSelected()){
					JOptionPane.showMessageDialog(null, "Student Login Successful","Login Status", JOptionPane.INFORMATION_MESSAGE);
					layout.show(parentPanel, "4");					
				}							
			}			
		});
		//add button to relevant panel
		loginPanel.add(loginButton);
		layout.show(parentPanel, "1");
		
		registerStudButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO for student registration
				/**insert code to check if credentials were successfully added to students table
				 * if credentials were added proceed to login
				 * if not try again*/
				JOptionPane.showMessageDialog(null, "Details added successfully","Registration Status", JOptionPane.INFORMATION_MESSAGE);
				layout.show(parentPanel, "1");				
			}			
		});
		registerStudentPanel.add(registerStudButton);   
		
		
		/*registerStaffButton.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO for staff registration
				/**insert code to check if credentials were successfully added to staff table
				 * if credentials were added proceed to login
				 * if not try again*/
				/*JOptionPane.showMessageDialog(null, "Details added successfully","Registration Status", JOptionPane.INFORMATION_MESSAGE);
				layout.show(parentPanel, "1");				
			}			
		});*/
		
		/*logoutButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"Are you certain you wish to logout?","Confirm Logout", JOptionPane.INFORMATION_MESSAGE);
				layout.show(parentPanel, "1");
			}			
		});*/
		
		//add content panels to container panel
		parentPanel.add(loginPanel, "1");
		parentPanel.add(registerStudentPanel, "2");
		parentPanel.add(registerStaffPanel, "3");
		parentPanel.add(studentDashboardPanel, "4");
		parentPanel.add(staffDashboardPanel, "5");
		
		//determines which panel is visible first
		layout.show(parentPanel, "1");
		
		//add component to frame
		add(parentPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//may be changed later on
		setSize(parentPanel.getSize());
		//pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new CardControl();
			}
		});
	}

}
