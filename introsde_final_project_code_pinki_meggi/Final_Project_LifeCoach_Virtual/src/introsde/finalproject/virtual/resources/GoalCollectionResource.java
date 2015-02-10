package introsde.finalproject.virtual.resources;

import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.ClientConfig;

@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/goal")
public class GoalCollectionResource {

	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // REQUEST #1 - GET /goal - list all goals type in database
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getGoalsBrowser() {
        System.out.println("Getting list of XML goals type...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
        Response response = service.path("/goal").request().accept(media).get();
        return response; 
    }
    
    
    // REQUEST #1 - GET /goal - list all goals type in database
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getGoalsXML() {
        System.out.println("Getting list of XML goals type...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        
        Response response = service.path("/goal").request().accept(media).get();
        return response; 
    }
    
    
    // REQUEST #1 - GET /goal - list all goals type in database
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGoalsJSON() {
        System.out.println("Getting list of JSON goals type...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5560/vLifeCoachGoalService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        
        Response response = service.path("/goal").request().accept(media).get();
        return response; 
    }
    
    
    // REQUEST #2 - POST /goal/{id} - create goal for person with {id}
    // REQUEST #3 - GET /goal/{id} - return the goals of person with {id}
    @Path("{pId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public GoalResource getPerson(@PathParam("pId") int id) {
        return new GoalResource(uriInfo, request, id);
    }
    
    
    // REQUEST #4 - GET /goal/{id}/{gid} - return the goal identified by {gid} of person {id} 
    // REQUEST #5 - DELETE /goal/{id}/{gid} - delete the goal identified by {gid} of person {id} 
    // REQUEST #6 - PUT /goal/{id}/{gid} - edit the goal identified by {gid} of person {id} 
    @Path("{personId}/{gid}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public GoalPersonResource deletePersonGoal(@PathParam("personId") int id, @PathParam("gid") int gid) {
        return new GoalPersonResource(uriInfo, request, id, gid);
    }
    
    private static URI getBaseURI(String URI) {
		return UriBuilder.fromUri(URI).build();
	}

}