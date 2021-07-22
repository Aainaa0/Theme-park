package controller.calculation;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PriceCalculator {
	
	public static Double calculateTotalPrice(String customerID)
	{
		double total = 0;
		
		try {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/theme park", "root", "");
			st = (Statement) con.createStatement();
			String s = "SELECT a.price FROM attraction a, entryrecord er WHERE a.AttractionID=er.AttractionID AND er.CustomerID='"+customerID+"'";
			rs = (ResultSet) st.executeQuery(s);

			while(rs.next()) {
				total = total  + rs.getDouble(1);
			}
		} catch (Exception e) {
			
		}
		
		
		return total;
		
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
