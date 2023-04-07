package com.element_test;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentDashboard extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	
//TODO change placeholder code in dashboard 2

	public StudentDashboard() {
			setName("STUDENT DASHBOARD");//JPanel title
			
			//Create and add form fields
			createLabel();
			
			//Setting frame properties
			setSize(500,500);
			setLayout(null);
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		private void createButton(JButton regButton) {
			regButton = new JButton("DASHBOARD");
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
		
		private void createLabel() {
			setLabel(label,"Student Dashboard Placeholder: ",50,50,250,20);
			add(getLabel());
		}
	
	/*public static void main(String[] args) {
		new StudentDashboard();
	}*/

}
