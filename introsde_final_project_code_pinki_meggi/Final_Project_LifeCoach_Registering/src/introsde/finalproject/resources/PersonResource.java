package introsde.finalproject.resources;

import introsde.finalproject.model.Person1;
import introsde.finalproject.soap.Person;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getPerson() {
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        Person person=storage.readPersonInfo(new Long(this.id));
        
        
    	if (person == null)
        {
            System.out.println("Get: Person with " + id + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	Person1 p = new Person1();
        	p.setPersonId(person.getIdPerson());
        	p.setFirstname(person.getFirstname());
        	p.setLastname(person.getLastname());
        	p.setBirthdate(person.getBirthdate());
        	p.setEmail(person.getEmail());
        	p.setUsername(person.getUsername());
        	p.setPassword(person.getPassword());
        	System.out.println("Returning person... " + p.getPersonId());
        	res = Response.ok().entity(p).build();          
        }
        return res;
    }

    // REQUEST #2 - GET /person/{id} - return the profile of person with {id} 
    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersonHTML() {
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        Person person=storage.readPersonInfo(new Long(this.id));
        if (person == null)
        {
            System.out.println("Get: Person with " + id + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	System.out.println("Returning person... " + person.getIdPerson());
        	res = Response.ok().entity(person).build();          
        }
        return res;
    }

    
}