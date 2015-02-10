package introsde.finalproject.resources;

import introsde.finalproject.soap.Person;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;
import introsde.finalproject.model.Person1;
import introsde.finalproject.resources.PersonResource;

import java.io.IOException;

import javax.ejb.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

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
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public int newPerson(Person1 person) throws IOException {
        System.out.println("Creating new person...");
        
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        Person p = new Person();
        p.setFirstname(person.getFirstname());
        p.setLastname(person.getLastname());
        p.setBirthdate(person.getBirthdate());
        p.setEmail(person.getEmail());
        p.setUsername(person.getUsername());
        p.setPassword(person.getPassword());
        
        Person newPersonCreated=storage.registerPerson(p);
                       
        return Integer.parseInt(newPersonCreated.getIdPerson().toString());   
    }
    
    // REQUEST #2 - GET /person/{id} - return the profile of person with {id} 
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
    
}