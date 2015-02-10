package introsde.finalproject.virtual.resources;


import introsde.finalproject.virtual.model.Goal1;

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
public class GoalPersonResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;
	int gid;


	public GoalPersonResource(UriInfo uriInfo, Request request,int id, int gid) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.gid=gid;
	}
	
    // REQUEST #4 - GET /goal/{id}/{gid} - return the info of goal identified by {gid} for person {id} 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPersonGoal() {
    	System.out.println("Reading XML GOAL from DB for person with id: "+id+" with GID ="+gid);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/goal/"+id+"/"+gid).request().accept(media).get();
        return response;   
    	   	
    }
    
    // REQUEST #4 - GET /goal/{id}/{gid} - return the info of goal identified by {gid} for person {id} 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonJSON() {
    	System.out.println("Reading JSON GOAL from DB for person with id: "+id+" with GID ="+gid);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/goal/"+id+"/"+gid).request().accept(media).get();
        return response;   
    	   	
    }
    
    // REQUEST #5 - DELETE /goal/{id}/{gid} - delete the goal identified by {gid} for person {id} 
    @DELETE
    @Produces(MediaType.TEXT_XML)
    public Response deletePersonGoal() {
    	System.out.println("--> DELETING Person Goal... " +this.gid);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
        Response response=service.path("/goal/"+id+"/"+gid).request().accept(media).delete();
        return response;
      }
    
    // REQUEST #6 - EDIT /goal/{id}/{gid} - Edit the goal identified by {gid} for person {id} 
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public Response editPersonGoal(Goal1 g) {
    	System.out.println("--> EDITING Person Goal... " +this.gid);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/goal/"+id+"/"+gid).request().accept(media).put(Entity.entity(g, media));
        return response;
      }

    // REQUEST #6 - EDIT /goal/{id}/{gid} - Edit the goal identified by {gid} for person {id} 
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPersonGoalJSON(Goal1 g) {
    	System.out.println("--> EDITING JSON Person Goal... " +this.gid);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/goal/"+id+"/"+gid).request().accept(media).put(Entity.entity(g, media));
        return response;
      }


    private static URI getBaseURI(String URI) {
  		return UriBuilder.fromUri(URI).build();
  	}
    
}
