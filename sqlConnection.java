import java.sql.*;
import javax.swing.*;

public class sqlConnection {
   Connection conne = null;
	public static Connection dbconnect()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conne = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hardh\\Desktop\\Mountain.sqlite");
			JOptionPane.showMessageDialog(null,"connection successful");
			return conne;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}
}
