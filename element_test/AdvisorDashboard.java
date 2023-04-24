package element_test;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AdvisorDashboard extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextArea message;
	
	public AdvisorDashboard() {
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
		message = new JTextArea("Hello Student Services Advisor.\nThis is your operations dashboard."
											+ "\nHere you can provide various services to students.\n"
											+ "These services include: viewing and responding to student issues."
											+ "\n Feel free to explore");
		message.setBounds(90,70,600,80);
		message.setEditable(false);
		add(message);
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
		setLabel(label,"Student Services Advisor Dashboard ",50,50,250,20);
		add(getLabel());
	}
}
