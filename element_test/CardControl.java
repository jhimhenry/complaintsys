/**Implemented by Ntini Edwards(1904701)
 * Card layout is used to switch between displays
 * Used to allow user to register/login and access dashboard*/
package element_test;
import model.Student;
import model.Staff;
import model.Complaint;
import model.Query;

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
	private SupervisorDashboard supDashboardPanel = new SupervisorDashboard();
	private AdvisorDashboard advDashboardPanel = new AdvisorDashboard();
	
	//buttons to control switching among panels
	private JButton loginButton = new JButton();
	private JButton registerStudButton = new JButton();
	private JButton registerStaffButton = new JButton();
	private JButton logoutStudButton = new JButton("Logout");
	private JButton logoutAdvButton =new JButton("Logout");
	private JButton logoutSupButton =new JButton("Logout");
	
	private JButton addComplaint = new JButton();
	private JButton addQuery = new JButton();
	private JButton viewComplaint = new JButton();
	private JButton viewQuery = new JButton();
	private JButton searchQuery = new JButton();
	private JButton searchComplaint = new JButton();
	private JButton assignComp = new JButton();
	private JButton viewStudComplaint = new JButton();
	private JButton viewStudQuery = new JButton();
	private JButton viewAssComp = new JButton();
	private JButton viewAssQ = new JButton();
	
	//add buttons to control the operations of the program
	public void initButtons() {
		//Login Screen button
		loginButton = loginPanel.createButton(loginButton);
		
		//Registration screen buttons
		registerStudButton = registerStudentPanel.createButton(registerStudButton);
		registerStaffButton = registerStaffPanel.createButton(registerStaffButton);
		
		//Student Dashboard Buttons
		addComplaint = studentDashboardPanel.createButton(addComplaint, "New Complaint",350,200,200,45);
		addQuery = studentDashboardPanel.createButton(addQuery, "New Query", 350,250,200,45);
		viewComplaint = studentDashboardPanel.createButton(viewComplaint, "View Past Complaints", 350,300,200,45);
		viewQuery = studentDashboardPanel.createButton(viewQuery, "View Past Queries", 350,350,200,45);
		searchQuery = studentDashboardPanel.createButton(searchQuery, "Find Query", 350,400,200,45);
		searchComplaint = studentDashboardPanel.createButton(searchComplaint, "Find Complaint", 350,450,200,45);
		logoutStudButton = studentDashboardPanel.createButton(logoutStudButton, "Logout", 350,500,200,45);
		
		//Supervisor Dashboard buttons
		assignComp  = supDashboardPanel.createButton(assignComp, "Assign Complaint", 350,200,200,45);//an update operation
		viewStudComplaint = supDashboardPanel.createButton(viewStudComplaint, "View Past Complaints", 350,250,200,45);
		viewStudQuery = supDashboardPanel.createButton(viewStudQuery, "View Past Queries", 350,300,200,45);
		logoutSupButton = supDashboardPanel.createButton(logoutSupButton, "Logout", 350,350,200,45);
		
		//Advisor Dashboard Buttons
		viewAssComp = advDashboardPanel.createButton(viewAssComp, "Assigned Complaints",350,200,200,45);
		viewAssQ = advDashboardPanel.createButton(viewAssQ, "Assigned Queries",350,250,200,45);
		logoutAdvButton = advDashboardPanel.createButton(logoutAdvButton, "Logout", 350,300,200,45);
	}
	
	public CardControl() {
		//initialise buttons to control navigation
		initButtons();
		
		setTitle("UTech Complaint System");
		
		//set card layout for parent panel
		parentPanel.setLayout(layout);
		parentPanel.setSize(900, 900);	
		
		//action listeners on buttons allow changing visible panel
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginPanel.getIDTF() != null) {
					if(loginPanel.getSupervisor().isSelected()) {
						//is this id in the database, is this person a supervisor
						JOptionPane.showMessageDialog(null, "Staff Login Successful","Login Status", JOptionPane.INFORMATION_MESSAGE);
						layout.show(parentPanel, "5");
						
						//if false redirect to login
					}
					if(loginPanel.getAdvisor().isSelected()) {
						//is this id in the database, is this person an advisor
						JOptionPane.showMessageDialog(null, "Staff Login Successful","Login Status", JOptionPane.INFORMATION_MESSAGE);
						layout.show(parentPanel, "6");			
						
						//if false redirect to login
					}
					if(loginPanel.getStudent().isSelected()){
						//is it in student database
						JOptionPane.showMessageDialog(null, "Student Login Successful","Login Status", JOptionPane.INFORMATION_MESSAGE);
						layout.show(parentPanel, "4");
						
						//if false redirect to login
					}
					
				}					
			
				//TODO to complete login
				/**insert code to check if credentials exist
				 * if credentials exist, check if credentials are correct
				 * if correct, and staff is selected, proceed to 5
				 * if correct and student is selected, proceed to 4
				 * if incorrect clear 1, allow 3 tries
				 * if credentials do not exist and student is selected, redirect to 2
				 * if credentials do not exist and staff is selected, redirect to 3*/	    
											
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
		
		registerStaffButton.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO for staff registration
				/**insert code to check if credentials were successfully added to staff table
				 * if credentials were added proceed to login
				 * if not try again*/
				JOptionPane.showMessageDialog(null, "Details added successfully","Registration Status", JOptionPane.INFORMATION_MESSAGE);
				layout.show(parentPanel, "1");				
			}			
		});
		registerStaffPanel.add(registerStaffButton);
		
		//Logout of different pages
		logoutStudButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null,"Are you certain you wish to logout?","Confirm Logout", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				//confirm logout
				if (opt == JOptionPane.YES_OPTION) {
					layout.show(parentPanel, "1");
				}else if(opt == JOptionPane.NO_OPTION) {
					layout.show(parentPanel, getName());
				}//end elif					
			}			
		});
		studentDashboardPanel.add(logoutStudButton);
		
		logoutSupButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null,"Are you certain you wish to logout?","Confirm Logout", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				//confirm logout
				if (opt == JOptionPane.YES_OPTION) {
					layout.show(parentPanel, "1");
				}else if(opt == JOptionPane.NO_OPTION) {
					layout.show(parentPanel, getName());
				}//end elif					
			}			
		});
		supDashboardPanel.add(logoutSupButton);
		
		logoutAdvButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null,"Are you certain you wish to logout?","Confirm Logout", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				//confirm logout
				if (opt == JOptionPane.YES_OPTION) {
					layout.show(parentPanel, "1");
				}else if(opt == JOptionPane.NO_OPTION) {
					layout.show(parentPanel, getName());
				}//end elif					
			}			
		});
		advDashboardPanel.add(logoutAdvButton);
		
		//add content panels to container panel
		parentPanel.add(loginPanel, "1");
		parentPanel.add(registerStudentPanel, "2");
		parentPanel.add(registerStaffPanel, "3");
		parentPanel.add(studentDashboardPanel, "4");
		parentPanel.add(supDashboardPanel, "5");
		parentPanel.add(advDashboardPanel, "6");
		
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
