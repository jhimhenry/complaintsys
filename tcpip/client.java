package tcpip;


 

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea resultArea;

    public Client(String serverAddress, int serverPort) throws Exception {
        // Connect to the server
        socket = new Socket(serverAddress, serverPort);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

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
            String response = in.readLine();
            resultArea.setText(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String serverAddress = "localhost";
        int serverPort = 1234;

        Client client = new Client(serverAddress, serverPort);
    }

    class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Send a CREATE request to the server
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String request = "CREATE " + name + "," + age;
            sendRequest(request);
            receiveResponse();
        }
    }

    class ReadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Send a READ request to the server
            String request = "READ";
            sendRequest(request);
            receiveResponse();
        }
    }
}

    
}
