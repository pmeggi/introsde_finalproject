package introsde.finalproject.virtual.resources;

import introsde.finalproject.virtual.model.Reminder1;

import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.ClientConfig;


@Stateless // only used if the the application is deployed in a Java EE container
@LocalBean // only used if the the application is deployed in a Java EE container
public class ReminderResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;


	public ReminderResource(UriInfo uriInfo, Request request,int id) {
	        this.uriInfo = uriInfo;
	        this.request = request;
	        this.id = id;
	}
	

	// REQUEST #2 - POST /reminder/{id} - should create the new reminder for person {id}  
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPersonReminder(Reminder1 reminder) {
    	System.out.println("Creating new Reminder XML");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/reminder/"+this.id).request().accept(media).post(Entity.entity(reminder, media));
        return response;  		
    	
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPersonReminderJSON(Reminder1 reminder) {
    	System.out.println("Creating new Reminder JSON");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/reminder/"+this.id).request().accept(media).post(Entity.entity(reminder, media));
        return response;  		
    	
    	
    }
	
	// REQUEST #3 - GET /reminder/{id} - return the reminders of person with {id} 
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPersonReminders() {
    	
    	System.out.println("Reading XML REMINDER History from DB for person with id: "+id);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/reminder/"+id).request().accept(media).get();
        return response;   
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonRemindersJSON() {
    	System.out.println("Reading JSON REMINDER History from DB for person with id: "+id);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/reminder/"+id).request().accept(media).get();
        return response;   
    }
  
    private static URI getBaseURI(String URI) {
 		return UriBuilder.fromUri(URI).build();
 	}
}
