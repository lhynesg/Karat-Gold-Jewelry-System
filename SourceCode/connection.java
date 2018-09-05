PACKAGE: Model					CLASS: ConnectionModel
package model;
import java.sql.*;

import javax.swing.JOptionPane;

public class connection {
	
		private PreparedStatement pst;
		Statement st;
		ResultSet rs;
		Connection conn;
	
		public connection(){
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            System.out.println("DB2 driver is loaded successfully");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Please include Classpath  Where your DB2 Driver is located");
            e.printStackTrace();
            return;
        }
       
        conn = null;
        pst = null;
        st = null;
        rs = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:db2://localhost:50000/karat","USER","alliswell");
            if (conn != null)
            {
                System.out.println("DB2 Database Connected");
            }
            else
            {
                System.out.println("Db2 connection Failed ");
            }
        } catch (SQLException e) {
        	
            System.out.println("DB2 Database connection Failed huhu");
            e.printStackTrace();
        }
    }
    public void insertItem(String tableName, String code, String price, String description)
    {
    	String query = "";
    	
    	if (tableName == "Ring")
			query = "insert into rings values(?, ?, ?)";
    	else if (tableName == "Earring")
    		query = "insert into earrings values(?, ?, ?)";
    	else if (tableName == "Bracelet")
    		query = "insert into bracelets values(?, ?, ?)";
    	else if (tableName == "Necklace")
    		query = "insert into necklaces values(?, ?, ?)";
    	try {
			pst = conn.prepareStatement(query);
			pst.setString(1, code);
			pst.setString(2, price);
			pst.setString(3, description);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Adding Completed");
		} catch (SQLException e) {
			System.out.println("The Insert statement cannot be made");
		}
    }
    public void closeConnection(boolean b)
    {
    	if (b == true)
    	{
    		try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("The connection cannot be closed");
			}
    	}
    }
}
