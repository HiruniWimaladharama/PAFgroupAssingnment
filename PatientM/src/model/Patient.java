package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patient {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String insertpatient(String name, String password, String report)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 // create a prepared statement
	 String query = " insert into mytable(`pid`,`pName`,`pPassword`,`pReport`)"
	 + " values (?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, name);
	 preparedStmt.setString(3, password);
	 preparedStmt.setString(4, report);
	// execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting the patient details..";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

     
	public String readPatient()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading purpose."; }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>pName</th><th>pPassword</th><th>pReport</th><th>Update</th><th>Remove</th></tr>";
	 String query = "select * from mytable";
	 Statement stmt = (Statement) con.createStatement();
	 ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String pid = Integer.toString(rs.getInt("pid"));
	 String pName = rs.getString("pName");
	 String pPassword = rs.getString("pPassword");
	 String pReport = rs.getString("pReport");
	 // Add into the html table
	 output += "<tr><td>" + pName + "</td>";
	 output += "<td>" + pPassword + "</td>";
	 output += "<td>" + pReport + "</td>";
	 // buttons
	 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"mytable.jsp\">"+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
	 + "<input name=\"doctorID\" type=\"hidden\" value=\"" + pid
	 + "\">" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the patient details.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String updatepatient(String id, String name, String password, String report)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE mytable SET pName=?,pPassword=?,pReport=? WHERE pid=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, name);
	 preparedStmt.setString(2, password);
	 preparedStmt.setString(3, report);
	 preparedStmt.setInt(4, Integer.parseInt(id));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Database is updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the patient.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String deletepatient(String pid)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from mytable where pid=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(pid));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the patient.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 


}
