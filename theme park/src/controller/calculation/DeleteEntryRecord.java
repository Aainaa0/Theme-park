package controller.calculation;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DeleteEntryRecord {
	
	public static void sqldelete(String customerID)
	{
		try {
			theQuery("DELETE FROM entryrecord WHERE CustomerID='"+customerID+"' ");
			System.out.println("okayy");
			
		} catch (Exception e) {
			
		}
	}
	public static void theQuery(String query) {
		Connection con = null;
		Statement st = null;
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/theme park", "root", "");
			st = (Statement) con.createStatement();
			st.executeUpdate(query);
			System.out.println("Delete successfully");
		} catch (Exception ex) {

		}
	}

}
