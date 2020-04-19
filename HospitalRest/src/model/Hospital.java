package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Hospital {
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

}
	
	public String insertHospital(String hospitalCode, String hospitalName, String hospitalAdress, String hospitalPhoneNo) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the Database when inserting data";
			}
			
			String query = " insert into hospitals(`HospitalID`,`hospitalCode`,`hospitalName`,`hospitalAdress`,`hospitalPhoneNo`)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, hospitalCode);
			preparedStmt.setString(3, hospitalName);
			preparedStmt.setString(4, hospitalAdress);
			preparedStmt.setString(5, hospitalPhoneNo);
			
			preparedStmt.execute();
			con.close();
			output = "Hospital Data insertered successfully";
		} catch (Exception e) {
			output = "Error while inserting hospital data.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readHospital()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading hospital data."; }
	
	 output = "<table border=\"1\"><tr><th>hospitalCode</th><th>hospitalName</th><th>hospitalAdress</th><th>hospitalPhoneNo</th><th>Update</th><th>Remove</th></tr>";
	 String query = "select * from hospitals";
	 Statement stmt = (Statement) con.createStatement();
	 ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
	 
	 while (rs.next())
	 {
	 String HospitalID = Integer.toString(rs.getInt("HospitalID"));
	 String hospitalCode = rs.getString("hospitalCode");
	 String hospitalName = rs.getString("hospitalName");
	 String hospitalAdress = rs.getString("hospitalAdress");
	 String hospitalPhoneNo = Integer.toString(rs.getInt("hospitalPhoneNo"));
	 
	
	 
	 
	 output += "<tr><td>" + hospitalCode + "</td>";
	 output += "<td>" + hospitalName + "</td>";
	 output += "<td>" + hospitalAdress + "</td>";
	 output += "<td>" + hospitalPhoneNo + "</td>";
	
	
	 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">"+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
	 + "<input name=\"HospitalID\" type=\"hidden\" value=\"" + HospitalID
	 + "\">" + "</form></td></tr>";
	 }
	 con.close();
	
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the hospital data.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	public String updateHospital(String HospitalID,String hospitalCode, String hospitalName, String hospitalAdress, String hospitalPhoneNo)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating hospital data."; }
	
	 String query = "UPDATE hospitals SET hospitalCode=?, hospitalName=?,hospitalAdress=?,hospitalPhoneNo=? WHERE HospitalID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	
	 preparedStmt.setString(1, hospitalCode);
	 preparedStmt.setString(2, hospitalName);
	 preparedStmt.setString(3, hospitalAdress);
	 preparedStmt.setString(4, hospitalPhoneNo);
	 
	 preparedStmt.setInt(5, Integer.parseInt(HospitalID));
	 
	 preparedStmt.execute();
	 con.close();
	 output = "Hospital data updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the hospital data.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String deleteHospital(String HospitalID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting hospital data."; }
	
	 String query = "delete from hospitals where HospitalID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);

	 preparedStmt.setInt(1, Integer.parseInt(HospitalID));
	 
	 preparedStmt.execute();
	 con.close();
	 output = "Hospital deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the hospital.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 

}
