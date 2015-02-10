package introsde.finalproject.virtual.resources;

import java.io.IOException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/persontrack")
public class PersonTrackingResource {
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    
    // REQUEST #1 - GET /persontrack/reminders/{personId} - return todays reminders for {personId} 
    @Path("reminders/{personId}")
    @Consumes(MediaType.APPLICATION_XML)
    public PersonReminderTrack getRemindersTrack(@PathParam("personId") int id) throws IOException {
   
    	return new PersonReminderTrack(uriInfo, request, id);
    
    }
}
