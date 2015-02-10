package introsde.finalproject.virtual.resources;

import introsde.finalproject.virtual.model.MeasureHistory1;

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
public class PersonMeasureHistoryResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    int id;
    String measure;

    public PersonMeasureHistoryResource(UriInfo uriInfo, Request request,int id, String measure) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.measure=measure;
    }

    // REQUEST #3 - GET /person/{id}/{measure} - return the {measure} history of person {id} 
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPersonMeasureHistory() {
    	System.out.println("Reading XML Measure History ("+measure+") from DB for person with id: "+id);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/person/"+id+"/"+measure).request().accept(media).get();
        return response;    
     }


    // REQUEST #3 - GET /person/{id}/{measure} - return the {measure} history of person {id} 
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonMeasureHistoryJSON() {
    	System.out.println("Reading JSON Measure History ("+measure+") from DB for person with id: "+id);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/person/"+id+"/"+measure).request().accept(media).get();
        return response;    
     }
    
    // for the browser
    // REQUEST #3 - GET /person/{id}/{measure} - return the {measure} history of person {id} 
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersonMeasureHistoryBrowser() {
    	System.out.println("Reading HTML Measure History ("+measure+") from DB for person with id: "+id);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
        Response response=service.path("/person/"+id+"/"+measure).request().accept(media).get();
        return response;    
    }
    
    // REQUEST #4 - POST /person/{id}/{measure} - should update the new value of {measure} of person {id} and archive the old 
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateMeasure(MeasureHistory1 measureH) {
    	System.out.println("Creating new measure XML");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/person/"+this.id+"/"+this.measure).request().accept(media).post(Entity.entity(measureH, media));
        return response;  
    }
    
    // REQUEST #4 - POST /person/{id}/{measure} - should update the new value of {measure} of person {id} and archive the old 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMeasureJSON(MeasureHistory1 measureH) {
    	System.out.println("Creating new measure JSON");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/person/"+this.id+"/"+this.measure).request().accept(media).post(Entity.entity(measureH, media));
        return response;  
    }

    
    private static URI getBaseURI(String URI) {
 		return UriBuilder.fromUri(URI).build();
 	}
 	
      
}