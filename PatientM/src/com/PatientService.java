package com;
import model.Patient;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

import model.Patient;

import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/mytable")
public class PatientService {

		Patient patientObj = new Patient();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readPatient()
		{
		return patientObj.readPatient();
		}

		@POST 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String insertpatient(
				@FormParam("pName") String pName,
				@FormParam("pPassword") String pPassword,    
				@FormParam("pReport") String pReport ) 
		
		{  
			String output = patientObj.insertpatient(pName, pPassword, pReport);  
			return output; 
		} 

		@PUT 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updatepatient(String patientData) 
		{  
			//Convert the input string to a JSON object  
			JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject(); 
			 
			//Read the values from the JSON object  
			String pid = patientObject.get("pid").getAsString();  
			String pName = patientObject.get("pName").getAsString();  
			String pPassword =patientObject.get("pPassword").getAsString();  
			String pReport = patientObject.get("pReport").getAsString(); 
			 
			       String output = patientObj.updatepatient(pid, pName, pPassword, pReport); 
			 
			 return output; 
			 
		} 

		@DELETE 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deletepatient(String patientData)
		{  
			//Convert the input string to an XML document  
			Document doc = Jsoup.parse(patientData, "", Parser.xmlParser());     
			
			
			//Read the value from the element <itemID>  
			String pid = doc.select("pid").text(); 
			 
			String output = patientObj.deletepatient(pid); 
			 
			 return output; 
			 
		}









































}













































