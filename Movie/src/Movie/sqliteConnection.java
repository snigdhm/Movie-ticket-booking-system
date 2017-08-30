package Movie;
import java.sql.*;

import javax.swing.JOptionPane;
public class sqliteConnection {
	Connection connect=null;
	public static Connection  dataConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection connect=DriverManager.getConnection("jdbc:sqlite:/C:/Users/veda/Desktop/movie3.sqlite");
			//JOptionPane.showMessageDialog(null, "Successful connection");
			return connect;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error in connection");
			return null;
		}
	}
}
