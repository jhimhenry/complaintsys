package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import tcpip.Client;


public class LiveChat extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public LiveChat(String serverAddress, int serverPort)throws Exception  {
    	
    	  socket = new Socket(serverAddress, serverPort);
	      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      out = new PrintWriter(socket.getOutputStream(), true);
    	
        setTitle("Live Chat");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the components
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        messageField = new JTextField();
        sendButton = new JButton("Send");
        //sendButton.addActionListener(new SendButtonListener());


        // Set up the layout
        setLayout(new BorderLayout());
        add(chatScrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws Exception {
    	 String serverAddress = "localhost";
         int serverPort = 3306;
        LiveChat liveChat = new LiveChat(serverAddress, serverPort);
        liveChat.setVisible(true);
    }

//    class SendButtonListener implements ActionListener {
//        public void actionPerformed(ActionEventevent e) {
//      
//            sendRequest(request);
//            receiveResponse();
//        }
//    }
    
}
