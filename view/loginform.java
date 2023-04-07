package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class loginform {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JFrame frame;
    private JTextField nameField;
    private JTextField transField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField threadField;
    private JTextArea resultArea;


    public loginform()
    {
        frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Transaction ID:"));
       transField=new  JTextField();

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel("Category :"));
        categoryField = new JTextField();
        panel.add(categoryField);
        
        
        panel.add(new JLabel("Cost :"));
        costField = new JTextField();
        panel.add(costField);
        
        
        panel.add(new JLabel("Name Thread:"));
        threadField = new JTextField();
        panel.add(threadField);

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
    
}
