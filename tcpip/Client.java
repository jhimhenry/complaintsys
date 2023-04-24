package tcpip;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.swing.*;
import element_test.*;
import model.Complaint;
import model.Query;
import model.Staff;
import model.Student;

public class Client {
    private Socket socket;
    private ObjectOutputStream objOs;
    private ObjectInputStream obIs;
    private String action;
    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea resultArea;
    
    static Login l;
    
    public static ArrayList<Complaint> complaintList = null;
    public static Complaint complaint = null;
    public static ArrayList<Query> queryList = null;
    public static Query query = null;
    
    public static final Logger log = LogManager.getLogger(Client.class);
    
    public void createConnection() {
        try {
            socket = new Socket("127.0.0.1", 8888);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void closeConnection() {
        try {
            objOs.close();
            obIs.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void configureStreams() throws IOException {
        obIs = new ObjectInputStream(socket.getInputStream());
        try {
            objOs = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendAction(String action) {
        this.action = action;
        try {
            objOs.writeObject(action);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void sendQuery(Query query) {
        try {
            objOs.writeObject(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendComplaint(Complaint comp) {
        try {
            objOs.writeObject(comp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendStudent(Student stu) {
        try {
            objOs.writeObject(stu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendStaff(Staff staff) {
        try {
            objOs.writeObject(staff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client() throws Exception {
        // Connect to the server
    	this.createConnection();
    	this.configureStreams();

//        // Create the GUI
//        frame = new JFrame("Client");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(3, 2));
//
//        panel.add(new JLabel("Name:"));
//        nameField = new JTextField();
//        panel.add(nameField);
//
//        panel.add(new JLabel("Age:"));
//        ageField = new JTextField();
//        panel.add(ageField);
//
//        JButton createButton = new JButton("Create");
//        createButton.addActionListener(new CreateButtonListener());
//        panel.add(createButton);
//
//        JButton readButton = new JButton("Read");
//        readButton.addActionListener(new ReadButtonListener());
//        panel.add(readButton);
//
//        frame.getContentPane().add(BorderLayout.CENTER, panel);
//
//        resultArea = new JTextArea(20, 40);
//        frame.getContentPane().add(BorderLayout.SOUTH, resultArea);
//
//        frame.pack();
//        frame.setVisible(true);
    }

    public void receiveResponse() {
        try {
            if (action.equalsIgnoreCase("ADD-COMPLAINT")) {
                Boolean flag = (Boolean) obIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(null, "COMPLAINT RECORDED",
                            "COMPLAINT", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Added a complaint to database"); 
                } else {
                    JOptionPane.showMessageDialog(null, "FAILED TO ADD COMPLAINT",
                            "COMPLAINT", JOptionPane.INFORMATION_MESSAGE);
                    log.error("Encountered an error while trying to add complaint"); 
                }
            }
            if (action.equalsIgnoreCase("FILTER-COMPLAINTS")) {
                Boolean flag = (Boolean) obIs.readObject();
                Complaint complaints = (Complaint) obIs.readObject();
                if (flag) {
                    complaint = complaints;
                    System.out.println(complaint);
                }
            }
            if (action.equalsIgnoreCase("GET-ASSIGNED-COMPLAINTS")) {
                Boolean flag = (Boolean) obIs.readObject();
                ArrayList<Complaint> complaints = (ArrayList<Complaint>) obIs.readObject();
                if (flag) {
                    complaintList = complaints;
                    System.out.println(complaints);
                }
            }
            if (action.equalsIgnoreCase("ADD-QUERY")) {
                Boolean flag = (Boolean) obIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(null, "QUERY RECORDED",
                            "COMPLAINT", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Added a query to database"); 
                } else {
                    JOptionPane.showMessageDialog(null, "FAILED TO ADD QUERY",
                            "COMPLAINT", JOptionPane.INFORMATION_MESSAGE);
                    log.error("Encountered an error while trying to add query"); 
                }
            }
	        if (action.equalsIgnoreCase("GET-COMPLAINTS")) {
	            Boolean flag = (Boolean) obIs.readObject();
	            ArrayList<Complaint> complaints = (ArrayList<Complaint>) obIs.readObject();
	            if (flag) {
	                complaintList = complaints;
	                System.out.println(complaints);
	                log.info("Reading compalints from database"); 
	            }
	        }
	        if (action.equalsIgnoreCase("GET-QUERY")) {
	            Boolean flag = (Boolean) obIs.readObject();
	            ArrayList<Query> query = (ArrayList<Query>) obIs.readObject();
	            if (flag) {
	                queryList = query;
	                System.out.println(query);
	                log.info("Reading query from database"); 
	            }
	        }
	        if (action.equalsIgnoreCase("ADD-RESPONSE")) {
                Boolean flag = (Boolean) obIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(null, "RESPONSE RECORDED",
                            "RESPONSE", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Responding"); 
                } else {
                    JOptionPane.showMessageDialog(null, "FAILED TO PROVIDE RESPONSE",
                            "RESPONSE", JOptionPane.INFORMATION_MESSAGE);
                    log.error("Encountered an error while trying to add a response");
                }
            }
            if (action.equalsIgnoreCase("ASSIGN-STUDENT-ADVISOR")) {
                Boolean flag = (Boolean) obIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(null, "ADVISOR ASSIGNED",
                            "RESPONSE", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Advisor has be assigned to issue"); 
                } else {
                    JOptionPane.showMessageDialog(null, "ADVISOR TO ASSIGN ISSUE",
                            "RESPONSE", JOptionPane.INFORMATION_MESSAGE);
                    log.error("Encountered an error while trying to assign an advisor"); 
                }
            }
        } catch (ClassCastException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) throws Exception {
//
//        l= new Login();
//        l.setVisible(true);
//    }
//
//    class CreateButtonListener implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            // Send a CREATE request to the server
//            String name = nameField.getText();
//            int age = Integer.parseInt(ageField.getText());
//            String request = "CREATE " + name + "," + age;
//            sendAction(request);
//            receiveResponse();
//        }
//    }
//
//    class ReadButtonListener implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            // Send a READ request to the server
//            String request = "READ";
//            sendAction(request);
//            receiveResponse();
//        }
//    }
}

