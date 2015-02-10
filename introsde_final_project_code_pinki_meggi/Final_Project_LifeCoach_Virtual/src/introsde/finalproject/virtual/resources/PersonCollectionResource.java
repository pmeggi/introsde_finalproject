package introsde.finalproject.virtual.resources;

import introsde.finalproject.virtual.model.Person1;

import java.io.IOException;
import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/person")
public class PersonCollectionResource {

	
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    
    // REQUEST #1 - POST /person - create a new person 
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response newPerson(Person1 person) throws IOException {
        System.out.println("Creating new person XML");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
        MediaType media1 = MediaType.valueOf(MediaType.APPLICATION_XML);
        Response response=service.path("/person/").request().post(Entity.entity(person, media1));
        return response;
    }
    
 // REQUEST #1 - POST /person - create a new person 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPersonJSON(Person1 person) throws IOException {
        System.out.println("Creating new person JSON");
        
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://localhost:5550/vLifeCoachPeopleService"));
       // MediaType media = MediaType.valueOf(MediaType.TEXT_XML);
        MediaType media1 = MediaType.valueOf(MediaType.APPLICATION_JSON);
        Response response=service.path("/person/").request().post(Entity.entity(person, media1));
        return response;
    }
    
    @Path("{personId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public PersonResource getPerson(@PathParam("personId") int id) {
        return new PersonResource(uriInfo, request, id);
    }
    
    
 // REQUEST #3 - GET /person/{id}/{measure} - return the {measure} history of person {id} 
    // REQUEST #4 - POST /person/{id}/{measure} - should create the value of {measure} for person {id} 
    @Path("{personId}/{measure}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public PersonMeasureHistoryResource getPersonMeasureHistory(@PathParam("personId") int id, 
    															@PathParam("measure") String m) {
        return new PersonMeasureHistoryResource(uriInfo, request, id, m);
    }
    
    // REQUEST #5 - GET /person/{id}/{measure}/{mid} - return the value of {measure} identified by {mid} for person {id}
    // REQUEST #6 - PUT /person/{id}/{measure}/{mid} - update the value of {measure} identified by {mid} for person {id}
    // REQUEST #7 - DELETE /person/{id} - delete the value of {measure} identified by {mid} for person {id} 
    @Path("{personId}/{measure}/{mid}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public PersonMeasureResource getPersonMeasureByMeasureId(@PathParam("personId") int id, @PathParam("measure") String m, @PathParam("mid") int mid) {
        return new PersonMeasureResource(uriInfo, request, id, m, mid);
    }
    
       
    private static URI getBaseURI(String URI) {
		return UriBuilder.fromUri(URI).build();
	}
	
}
