package introsde.finalproject.virtual.resources;

import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
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

@Stateless // only used if the the application is deployed in a Java EE container
@LocalBean // only used if the the application is deployed in a Java EE container
public class PersonReminderTrack {
		@Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    int id;

	    public PersonReminderTrack(UriInfo uriInfo, Request request,int id) {
	        this.uriInfo = uriInfo;
	        this.request = request;
	        this.id = id;
	    }

	    // REQUEST #1 - GET /persontrack/remminders/{personId} - return todays reminders for {personId} 
	    // Application integration
	    @GET
	    @Produces(MediaType.APPLICATION_XML)
	    public Response getPerson() {
	    	System.out.println("Getting XML person...");
	        ClientConfig clientConfig = new ClientConfig();
	        Client client = ClientBuilder.newClient(clientConfig);
	        WebTarget service = client.target(getBaseURI("http://localhost:5580/vLifeCoachTrackingService"));
	        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
	        Response response=service.path("/reminders/"+id).request().accept(media).get();
	        return response;
	    	
	    }
	    
	    private static URI getBaseURI(String URI) {
	  		return UriBuilder.fromUri(URI).build();
	  	}
	  	    

}
