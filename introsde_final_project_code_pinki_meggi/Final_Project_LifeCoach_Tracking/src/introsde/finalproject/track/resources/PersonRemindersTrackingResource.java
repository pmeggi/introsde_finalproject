package introsde.finalproject.track.resources;


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
@Path("/reminders")
public class PersonRemindersTrackingResource {


	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // REQUEST #1 - GET /reminders/{id} - return the today reminders of person with {id} 
    @Path("{personId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public PersonReminderResource getPersonReminder(@PathParam("personId") int id) {
    	 return new PersonReminderResource(uriInfo, request, id);
    }
}
