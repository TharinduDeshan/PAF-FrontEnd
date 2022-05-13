package model;

import java.sql.*; 

public class payment {
	
	//A common method to connect to the DB
	
	private Connection connect()
	 {
		 Connection con = null;
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
		
			 //Provide the correct details: DBServer/DBName, username, password
			 
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elecbill", "root", "root");
		 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
	 }
	
	// insert method
			public String insertPayment(String minUnit, String maxUnit, String unitPrice)
	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for inserting."; }
			 
			 // create a prepared statement
			 
			 String query = " insert into payment (`PayID`,`minUnit`,`maxUnit`,`unitPrice`)" + " values (?, ?, ?, ?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, minUnit);
			 preparedStmt.setString(3, maxUnit);
			 preparedStmt.setString(4, unitPrice);
			 
			 // execute the statement
			 
			 preparedStmt.execute();
			 con.close();
			 output = "Inserted successfully..";
		 }
		 catch (Exception e)
		 {
			 output = "Error while inserting..";
			 System.err.println(e.getMessage());
		 }
		 return output;
	}
			
			//view method
		public String readPayment()
		 {
			String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for reading."; }
				 
				 // Prepare the html table to be displayed
				 
				 output = "<table border='1'><tr><th>PAYMENT ID</th>" +"<th>MIN UNIT</th>" + "<th>MAX UNIT</th>" +"<th>UNIT PRICE</th>" +
				 "<th>Update</th><th>Remove</th></tr>";
			
				 String query = "select * from payment";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 // iterate through the rows in the result set
				 
				 while (rs.next())
				 {
					 String PayID = Integer.toString(rs.getInt("PayID"));
					 String minUnit = rs.getString("minUnit");
					 String maxUnit = rs.getString("maxUnit");
					 String unitPrice = rs.getString("unitPrice");
					 
					 // Add into the html table
					 
					 output += "<td>" + PayID + "</td>";
					 output	+= "<td>" + minUnit + "</td>";
					 output += "<td>" + maxUnit + "</td>";
					 output += "<td>" + unitPrice + "</td>";
					 
					 // buttons
					 
					 output += "<td><form method='post' action='updatePayment.jsp'>"
					 		+ "<input name='btnUpdate' type='submit' value='Update'class='btn btn-secondary'>"
					 		+ "<input name='ID' type='hidden' value='" + PayID + "'>" + "</form></td>"
							 + "<td><form method='post' action='viewPayment.jsp'>"
							 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
							 + "<input name='PayID' type='hidden' value='" + PayID + "'>" + "</form></td></tr>";
				 }
				 con.close();
				 
				 // Complete the html table
				 
				 output += "</table>";
			 }
			 catch (Exception e)
			 {
				 output = "Error while reading the .";
				 System.err.println(e.getMessage());
			 }
			 return output;
		 }
		
		//update method
		 public String updatePayment(String PayID, String minUnit, String maxUnit, String unitPrice)
		 {
			 String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for updating."; }
				 
				 // create a prepared statement
				 
				 String query = "UPDATE payment SET minUnit=?,maxUnit=?,unitPrice=? WHERE PayID=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 
				 preparedStmt.setString(1, minUnit);
				 preparedStmt.setString(2, maxUnit);
				 preparedStmt.setString(3, unitPrice);
				 preparedStmt.setInt(4, Integer.parseInt(PayID));
				 
				 // execute the statement
				 
				 preparedStmt.execute();
				 con.close();
				 output = "Updated successfully";
			 }
			 catch (Exception e)
			 {
				 output = "Error while updating the payment.";
				 System.err.println(e.getMessage());
			 }
			 return output;
		}
		 
		 //delete method
		public String deletePayment(String PayID)
		{
			 String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for deleting."; }
				 // create a prepared statement
				 String query = "delete from payment where PayID=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(PayID));
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
				 output = "Error while deleting the item.";
				 System.err.println(e.getMessage());
			 }
			 return output;
		 }
}


