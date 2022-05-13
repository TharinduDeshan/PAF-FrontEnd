package com;

import model.payment;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/payment")

public class paymentService {
	payment paymentObj = new payment();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readpayment()
	 {
		return paymentObj.readPayment(); 
	 } 

	// insert user details
		@POST
		@Path("/insert")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertPayment(
		
		@FormParam("minUnit") String minUnit,
		@FormParam("maxUnit") String maxUnit,
		@FormParam("unitPrice") String unitPrice)
		
				{
					 String output = paymentObj.insertPayment(minUnit,maxUnit,unitPrice);
					 return output;
				}
						
						
						
	//update user details
		@PUT
		@Path("/update")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updatePayment(String paymentData)
		{
		   //Convert the input string to a JSON object
			JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
							 
		    //Read the values from the JSON object
							
				String PayID = paymentObject.get("PayID").getAsString();
				String minUnit = paymentObject.get("minUnit").getAsString();
				String maxUnit = paymentObject.get("maxUnit").getAsString();
				String unitPrice = paymentObject.get("unitPrice").getAsString();
				
				String output = paymentObj.updatePayment(PayID,minUnit,maxUnit,unitPrice);
				return output;
		}
						
		
		
	//delete user details
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String paymentData)
		{
		 //Convert the input string to an XML document
		 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());
					
		//Read the value from the element <idUnit>
		 String PayID = doc.select("PayID").text();
		 String output = paymentObj.deletePayment(PayID);
		 return output;
		 
		}

}
