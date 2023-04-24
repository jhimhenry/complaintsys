package tcpip;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
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
    
    private void createConnection() {
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

    public Client() throws Exception {
        // Connect to the server
    	this.createConnection();
    	this.configureStreams();

        // Create the GUI
        frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(new CreateButtonListener());
        panel.add(createButton);

        JButton readButton = new JButton("Read");
        readButton.addActionListener(new ReadButtonListener());
        panel.add(readButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);

        resultArea = new JTextArea(20, 40);
        frame.getContentPane().add(BorderLayout.SOUTH, resultArea);

        frame.pack();
        frame.setVisible(true);
    }

    public void sendRequest(String request) {
        out.println(request);
    }

    public void receiveResponse() {
        try {
            if (action.equalsIgnoreCase("ADD-COMPLAINT")) {
                Boolean flag = (Boolean) obIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(null, "COMPLAINT RECORDED",
                            "COMPLAINT", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "FAILED TO ADD COMPLAINT",
                            "COMPLAINT", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (ClassCastException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Client client = new Client();
    }

//    class CreateButtonListener implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            // Send a CREATE request to the server
//            String name = nameField.getText();
//            int age = Integer.parseInt(ageField.getText());
//            String request = "CREATE " + name + "," + age;
//            sendRequest(request);
//            receiveResponse();
//        }
//    }
//
//    class ReadButtonListener implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            // Send a READ request to the server
//            String request = "READ";
//            sendRequest(request);
//            receiveResponse();
//        }
//    }
}

