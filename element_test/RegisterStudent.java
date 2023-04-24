/**Implemented by Ntini Edwards (1904701)*/
package element_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterStudent extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField IDTF;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField contactTF;
	private JTextField emailTF;
	private JTextField passwordTF;
	
	//default constructor creates and 
	public RegisterStudent() {
		
		setName("Complaint System Student Registration");
		
		//Create and add form fields
		createID();		
		createName();		
		createContact();		
		createEmail();		
		createPassword();
		
		//Setting frame properties
		setSize(500,500);
		setLayout(null);
		setVisible(true);
	}

	JButton createButton(JButton regButton) {
		regButton = new JButton("Save");
		regButton.setBounds(200,300,90,40);
		add(regButton);
		return regButton;
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
		
	private void createName() {
		setLabel(label,"First Name: ",50,80,250,20);
		firstNameTF = new JTextField();
		firstNameTF.setBounds(180,80,150,25);
		add(getLabel());
		add(firstNameTF);
		setLabel(label,"Last Name: ",50,110,250,20);
		lastNameTF = new JTextField();
		lastNameTF.setBounds(180,110,150,25);
		add(getLabel());
		add(lastNameTF);
	}
	
	private void createContact() {
		setLabel(label,"Contact: ",50,140,250,20);
		contactTF = new JTextField();
		contactTF.setBounds(180,140,150,25);
		add(getLabel());
		add(contactTF);		
	}
	
	private void createEmail() {
		setLabel(label,"Email: ",50,170,250,20);
		emailTF = new JTextField();
		emailTF.setBounds(180,170,150,25);
		add(getLabel());
		add(emailTF);	
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
	
	/*private JComboBox<String> createCombo() {
		setLabel(label,"Size: ",50,200,250,20);
		String sizes[] = {"3","3.5","4","4.5", "5","5.5", "6","6.5", "7","7.5","8","8.5","9"};
		sizesCBox = new JComboBox<>(sizes);
		sizesCBox.setBounds(100,200,150,25);
		
		return sizesCBox;
	}
	
	//Action Listeners for processing
	
	//action listener for submit button
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed (ActionEvent a){
		String skuText = skuTextField.getText();
		String typeText = typeTextField.getText();
		String brandText = brandTextField.getText();
		String sizeText = sizesCBox.getItemAt(sizesCBox.getSelectedIndex());
		float size = Float.parseFloat(sizeText);
		
		//this.footWear = new Footwear(skuText, typeText, brandText, size);
		this.helper = new Helper();
		helper.createARecord(footWear);
		
		skuTextField.setText(" ");
		typeTextField.setText(" ");
		brandTextField.setText(" ");
		sizesCBox.setSelectedIndex(0);
		
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Some action was done");
		
	}
	
	public static void main(String[] args) {
		new RegisterStudent();
	}

	

}
