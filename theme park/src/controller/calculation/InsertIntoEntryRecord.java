package controller.calculation;

import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class InsertIntoEntryRecord {
	public static void sqlEntryRecord(ArrayList array, String customerID) 
	{
		System.out.println(array);
		
		for(int i=0; i<array.size(); i++)
		{
			try {
				theQuery("insert into entryrecord (AttractionID,CustomerID) values('" + array.get(i)+ "','"+customerID+"') ");
				System.out.println("okayy");
				
			} catch (Exception e) {
				
			}
		}

	}

	public static void theQuery(String query) {
		Connection con = null;
		Statement st = null;
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/theme park", "root", "");
			st = (Statement) con.createStatement();
			st.executeUpdate(query);
			System.out.println("Inserted successfully");
		} catch (Exception ex) {

		}
	}
}
