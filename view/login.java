package view;

import javax.swing.JFrame;


import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class login extends JFrame {

    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public login(String serverAddress, int serverPort)throws Exception {
        
     socket = new Socket(serverAddress, serverPort);
       in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
        
        setTitle("Login");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the components
        titleLabel = new JLabel("Welcome to My Application");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        // Set up the layout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(titleLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(usernameLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        add(usernameTextField, c);
        c.gridx = 0;
        c.gridy = 2;
        add(passwordLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        add(passwordField, c);
        c.gridx = 0;
        c.gridy = 3;
        add(loginButton, c);
        c.gridx = 1;
        c.gridy = 3;
        add(cancelButton, c);
    }

    public static void main(String[] args)throws Exception {
          String serverAddress = "localhost";
          int serverPort = 3306;
        login loginPage = new login(serverAddress, serverPort);
        loginPage.setVisible(true);
    }
}

