package introsde.finalproject.virtual.resources;

import introsde.finalproject.virtual.model.Reminder1;

import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
public class ReminderPersonResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;
	int rid;


	public ReminderPersonResource(UriInfo uriInfo, Request request,int id, int rid) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.rid=rid;
	}
	
    // REQUEST #4 - GET /reminder/{id}/{rid} - return the info of reminder identified by {rid} for person {id} 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPersonReminder() {
    	
    	System.out.println("Reading XML REMINDER from DB for person with id: "+id+" with RID ="+rid);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/reminder/"+id+"/"+rid).request().accept(media).get();
        return response;   
    	   	    	   	
    }
    
    // REQUEST #4 - GET /reminder/{id}/{rid} - return the info of reminder identified by {rid} for person {id} 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonReminderJSON() {
    	
    	System.out.println("Reading JSON REMINDER from DB for person with id: "+id+" with RID ="+rid);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/reminder/"+id+"/"+rid).request().accept(media).get();
        return response;   
    	   	    	   	
    }
    
    // REQUEST #5 - DELETE /reminder/{id}/{rid} - delete the reminder identified by {rid} for person {id} 
    @DELETE
    @Produces(MediaType.TEXT_XML)
    public Response deletePersonReminder() {
    	System.out.println("--> DELETING Person Reminder... " +this.rid);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
        Response response=service.path("/reminder/"+id+"/"+rid).request().accept(media).delete();
        return response;
    
    }

    // REQUEST #6 - EDIT /reminder/{id}/{rid} - Edit the reminder identified by {rid} for person {id} 
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPersonReminderJSON(Reminder1 r) {
    	System.out.println("--> EDITING JSON Person Goal... " +this.rid);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/reminder/"+id+"/"+rid).request().accept(media).put(Entity.entity(r, media));
        return response;
      }
    
    // REQUEST #6 - EDIT /reminder/{id}/{rid} - Edit the reminder identified by {rid} for person {id} 
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public Response editPersonReminder(Reminder1 r) {
    	System.out.println("--> EDITING XML Person Goal... " +this.rid);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5570/vLifeCoachTaskService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/reminder/"+id+"/"+rid).request().accept(media).put(Entity.entity(r, media));
        return response;
      }
    
    
    private static URI getBaseURI(String URI) {
  		return UriBuilder.fromUri(URI).build();
  	}
    
}