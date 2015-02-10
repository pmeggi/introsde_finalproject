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
public class PersonResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    int id;


    public PersonResource(UriInfo uriInfo, Request request,int id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    // REQUEST #2 - GET /person/{id} - return the profile of person with {id} 
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPerson() {
    	System.out.println("Getting XML person...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/person/"+id).request().accept(media).get();
        return response;
    	
    }
    
 // REQUEST #2 - GET /person/{id} - return the profile of person with {id} 
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonJson() {
    	System.out.println("Getting JSON person...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/person/"+id).request().accept(media).get();
        return response;
    	
    }


    // REQUEST #2 - GET /person/{id} - return the profile of person with {id} 
    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersonHTML() {
    	System.out.println("Getting HTML person...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
        Response response=service.path("/person/"+id).request().accept(media).get();
        return response;      
    }

    private static URI getBaseURI(String URI) {
  		return UriBuilder.fromUri(URI).build();
  	}
  	    

    
}