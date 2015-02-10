package introsde.finalproject.task.resources;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/reminder")
public class ReminderCollectionResource {


	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    
      
    // REQUEST #1 - POST /reminder/{id} - create reminder for person with {id}
    // REQUEST #3 - GET /reminder/{id} - return the reminders of person with {id}
    @Path("{personId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public ReminderResource getPersonReminder(@PathParam("personId") int id) {
        return new ReminderResource(uriInfo, request, id);
    }
    
    
    // REQUEST #4 - GET /reminder/{id}/{rid} - return the reminder identified by {rid} of person {id} 
    // REQUEST #5 - DELETE /reminder/{id}/{rid} - delete the reminder identified by {rid} of person {id} 
    // REQUEST #6 - PUT /reminder/{id}/{rid} - edit the reminder identified by {rid} of person {id} 
    @Path("{personId}/{rid}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public ReminderPersonResource deletePersonReminder(@PathParam("personId") int id, @PathParam("rid") int rid) {
        return new ReminderPersonResource(uriInfo, request, id, rid);
    }
    
    
}
