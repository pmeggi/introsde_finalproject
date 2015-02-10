package introsde.finalproject.virtual.resources;

import introsde.finalproject.virtual.model.MeasureHistory1;

import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
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
public class PersonMeasureResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    int idPerson;
    int idMeasure;
    String measureType;

    public PersonMeasureResource(UriInfo uriInfo, Request request,int personId, String measure, int measureId) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.idPerson = personId;
        this.measureType=measure;
        this.idMeasure=measureId;
    }

    // REQUEST #5 - GET /person/{id}/{measure}/{mid} - return the value of {measure} identified by {mid} for person {id}
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPersonMeasureXML() {
     	System.out.println("Reading XML Measure History ("+measureType+") from DB for person with id: "+idPerson+" with MID ="+idMeasure);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/person/"+idPerson+"/"+measureType+"/"+idMeasure).request().accept(media).get();
        return response;    
    }

    
    // REQUEST #5 - GET /person/{id}/{measure}/{mid} - return the value of {measure} identified by {mid} for person {id}
    // Application integration
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonMeasureJSON() {
    	System.out.println("Reading JSON Measure History ("+measureType+") from DB for person with id: "+idPerson+" with MID ="+idMeasure);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/person/"+idPerson+"/"+measureType+"/"+idMeasure).request().accept(media).get();
        return response;    
    }

    // REQUEST #5 - GET /person/{id}/{measure}/{mid} - return the value of {measure} identified by {mid} for person {id}
    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersonMeasureBrowser() {
    	System.out.println("Reading JSON Measure History ("+measureType+") from DB for person with id: "+idPerson+" with MID ="+idMeasure);
    	ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/person/"+idPerson+"/"+measureType+"/"+idMeasure).request().accept(media).get();
        return response;  
    }
    
    // REQUEST #6 - PUT /person/{id}/{measure}/{mid} - update the value of {measure} identified by {mid} for person {id}
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response putPersonMeasurement(MeasureHistory1 m) {
        System.out.println("--> Updating XML MeasureHistory... " +this.idMeasure);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/person/"+idPerson+"/"+measureType+"/"+idMeasure).request().accept(media).put(Entity.entity(m, media));
        return response;
    }


    // REQUEST #6 - PUT /person/{id}/{measure}/{mid} - update the value of {measure} identified by {mid} for person {id}
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putPersonMeasurementJSON(MeasureHistory1 m) {
        System.out.println("--> Updating JSON MeasureHistory... " +this.idMeasure);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/person/"+idPerson+"/"+measureType+"/"+idMeasure).request().accept(media).put(Entity.entity(m, media));
        return response;
    }

    
    // REQUEST #7 - DELETE /person/{id}/{measure}/{mid} - delete the value of {measure} identified by {mid} for person {id} 
    @DELETE
    @Produces(MediaType.TEXT_XML)
    public Response deletePersonMeasurement() {
    	 System.out.println("--> DELETING MeasureHistory... " +this.idMeasure);
         ClientConfig clientConfig = new ClientConfig();
         Client client = ClientBuilder.newClient(clientConfig);
         WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
         MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
         Response response=service.path("/person/"+idPerson+"/"+measureType+"/"+idMeasure).request().accept(media).delete();
         return response;
    	   	
    }

    private static URI getBaseURI(String URI) {
		return UriBuilder.fromUri(URI).build();
	}
	
}