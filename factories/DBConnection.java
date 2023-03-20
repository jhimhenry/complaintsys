package factories;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnection {
	
static String url = "";//url to connect to our database
	
	private static Connection connect = null;
	
	public static Connection getDatabaseConnection()
	{
	try
	{
		if(connect == null)
		{
			connect = DriverManager.getConnection(url,"root","");
			JOptionPane.showMessageDialog(null, "Connection established", "JBDC connection status", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return connect;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
