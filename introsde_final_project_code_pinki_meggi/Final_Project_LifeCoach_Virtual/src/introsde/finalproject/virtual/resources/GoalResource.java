package introsde.finalproject.virtual.resources;

import introsde.finalproject.virtual.model.Goal1;

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
public class GoalResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;


	public GoalResource(UriInfo uriInfo, Request request,int id) {
	        this.uriInfo = uriInfo;
	        this.request = request;
	        this.id = id;
	}
	

	// REQUEST #2 - POST /goal/{id} - should create the new goal for person {id}  
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPersonGoal(Goal1 goal) {
    	System.out.println("Creating new goal XML");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/goal/"+this.id).request().accept(media).post(Entity.entity(goal, media));
        return response;  		
    	
    }

    // REQUEST #2 - POST /goal/{id} - should create the new goal for person {id}  
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPersonGoalJSON(Goal1 goal) {
         
    	System.out.println("Creating new goal JSON");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/goal/"+this.id).request().accept(media).post(Entity.entity(goal, media));
        return response;  		
    	
    }
    
	// REQUEST #3 - GET /goal/{id} - return the goals of person with {id} 
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPersonGoals() {
    	System.out.println("Reading XML GOAL History from DB for person with id: "+id);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/goal/"+id).request().accept(media).get();
        return response;   
    }

    // REQUEST #3 - GET /goal/{id} - return the goals of person with {id} 
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonGoalsJSON() {
    	System.out.println("Reading JSON GOAL History from DB for person with id: "+id);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/goal/"+id).request().accept(media).get();
        return response;   
    }
    
    private static URI getBaseURI(String URI) {
 		return UriBuilder.fromUri(URI).build();
 	}
}
