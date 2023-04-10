package com.element_test;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class StudentDashboard extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	JTextArea message;
	
	public StudentDashboard() {
			createLabel();
			
			createMessage();
					
			//Setting frame properties
			setSize(500,500);
			setLayout(null);
			setVisible(true);
		}
		
		@SuppressWarnings("unused") JButton createButton(JButton button, String title,int x, int y, int w, int h) {
			button = new JButton(title);
			button.setBounds(x,y,w,h);
			add(button);
			return button;
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
			setLabel(label,"Student Dashboard: ",50,50,250,20);
			add(getLabel());
		}
		
		private void createMessage() {
			message = new JTextArea("Hello Student.\nThis is your operations dashboard."
												+ "\nHere you can gain access to various services from your Students Services Advisors.\n"
												+ "These services include: reporting issues, viewing past student issues and chatting with your student advisors."
												+ "\n Feel free to explore");
			message.setBounds(100,70,600,80);
			message.setEditable(false);
			add(message);
		}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new StudentDashboard();
			}
		});
	}

}
