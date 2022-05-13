package com;

import model.user;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/user")

public class userService {
	user userObj = new user();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readpayment()
	 {
		return userObj.readUser(); 
	 } 
	
	


	// insert user details
		@POST
		@Path("/insert")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertPayment(
		
		@FormParam("userName") String userName,
		@FormParam("noOfUnits") String noOfUnits
		)
		
				{
					 String output = userObj.insertUser(userName,noOfUnits);
					 return output;
				}
						
						
						
	//update user details
		@PUT
		@Path("/update")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updatePayment(String userData)
		{
		   //Convert the input string to a JSON object
			JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
							 
		    //Read the values from the JSON object
							
				String UserID = userObject.get("UserID").getAsString();
				String userName = userObject.get("userName").getAsString();
				String noOfUnits = userObject.get("noOfUnits").getAsString();
				
				String output = userObj.updateUser(UserID,userName,noOfUnits);
				return output;
		}
						
		
		
	//delete user details
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(String userData)
		{
		 //Convert the input string to an XML document
		 Document doc = Jsoup.parse(userData, "", Parser.xmlParser());
					
		//Read the value from the element <idUnit>
		 String UserID = doc.select("UserID").text();
		 String output = userObj.deleteUser(UserID);
		 return output;
		 
		}

}
