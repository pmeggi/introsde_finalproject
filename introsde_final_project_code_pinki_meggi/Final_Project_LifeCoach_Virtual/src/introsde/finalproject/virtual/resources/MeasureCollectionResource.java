package introsde.finalproject.virtual.resources;

import java.net.URI;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
@Path("/measures")
public class MeasureCollectionResource {
	
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // REQUEST #7 - GET /measures 
    // Return the list of measures to the user in the browser
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMeasuresJSON() {
        System.out.println("Getting list of JSON measure type...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        
        Response response = service.path("/measures").request().accept(media).get();
        return response;
    }
    
    // REQUEST #7 - GET /measures 
    // Return the list of measures to the user in the browser
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response getMeasuresXML() {
        System.out.println("Getting list of XML measure type...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_XML);
        
        Response response = service.path("/measures").request().accept(media).get();
        return response;
    }
    
    // REQUEST #7 - GET /measures 
    // Return the list of measures to the user in the browser
    @GET
    @Produces({MediaType.TEXT_XML})
    public Response getMeasuresHTML() {
        System.out.println("Getting list of HTML measure type...");
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
        
        Response response = service.path("/measures").request().accept(media).get();
        return response;
    }
    
    private static URI getBaseURI(String URI) {
		return UriBuilder.fromUri(URI).build();
	}

}
