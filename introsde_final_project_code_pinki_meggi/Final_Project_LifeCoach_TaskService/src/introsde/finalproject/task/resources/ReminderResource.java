package introsde.finalproject.task.resources;

import introsde.finalproject.soap.Person;
import introsde.finalproject.soap.Reminder;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;
import introsde.finalproject.task.model.Reminder1;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Stateless // only used if the the application is deployed in a Java EE container
@LocalBean // only used if the the application is deployed in a Java EE container
public class ReminderResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;


	public ReminderResource(UriInfo uriInfo, Request request,int id) {
	        this.uriInfo = uriInfo;
	        this.request = request;
	        this.id = id;
	}
	

	// REQUEST #2 - POST /reminder/{id} - should create the new reminder for person {id}  
    @POST
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response createPersonReminder(Reminder1 reminder) {
         
    	Response res;
    	System.out.println("Creating the new reminder for person with ID="+id);
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
    	
        Person p = storage.readPersonInfo(new Long(this.id));
    	if (p==null)
    	{
    		System.out.println("POST: Person ("+this.id+") not found");
    		res = Response.status(404).build();
    	}
 	    else
    	{
 	    	Reminder r = new Reminder();
 	    	
 	    	r.setDescription(reminder.getDescription());
 	    	r.setTypeReminder(reminder.getType());
 	    	r.setWDay(reminder.getWDay());
 	    	r.setMDay(reminder.getMDay());
 	    	r.setSDate(reminder.getSDate());
 	    	r.setDateRegistered(reminder.getCreated());
 	    	r.setStatus(reminder.getStatus());
 	    	
 	    	Reminder newR = storage.registerPersonReminder(new Long(this.id), r);
 	    	
 	    	Reminder1 r1 = new Reminder1(newR.getIdReminder(),newR.getDescription(),newR.getTypeReminder(),newR.getWDay(),newR.getMDay(),newR.getSDate(),newR.getStatus(),newR.getDateRegistered());
 	    	
 	    	res = Response.created(uriInfo.getAbsolutePath()).entity(r1).build();        
    	}
        return res;
    }
	
	// REQUEST #3 - GET /reminder/{id} - return the reminders of person with {id} 
    // Application integration
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getPersonReminders() {
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Reading the reminders for person with ID="+id);
        Person person=storage.readPersonInfo(new Long(this.id));
        
        
    	if (person == null)
        {
            System.out.println("Get: Person with " + id + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	List<Reminder> rList=storage.readPersonReminders(new Long(this.id));
        	
    		if (rList == null)
    		{
    			System.out.println("Get: Reminders History of Person with ID=" + id + " not found");
    			res = Response.status(404).build();
    		}
    		else
    		{
    			List<Reminder1> r1List = new ArrayList<Reminder1>();
    			for (int i=0; i<rList.size();i++){
    				Reminder r = rList.get(i);
    				Reminder1 r1 = new Reminder1(r.getIdReminder(),r.getDescription(),r.getTypeReminder(),r.getWDay(),r.getMDay(),r.getSDate(),r.getStatus(),r.getDateRegistered());
    	 	    	System.out.println(r1);
    				r1List.add(r1);
    			}
    	        res = Response.ok().entity(new GenericEntity<List<Reminder1>>(r1List){}).build();
    		}         
        }
        return res;
    }

    // REQUEST #3 - GET /reminder/{id} - return the reminders of person with {id} 
    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersonRemindersHTML() {
 	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Reading the reminders for person with ID="+id);
        Person person=storage.readPersonInfo(new Long(this.id));
        
        
    	if (person == null)
        {
            System.out.println("Get: Person with " + id + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	List<Reminder> rList=storage.readPersonReminders(new Long(this.id));
        	
    		if (rList == null)
    		{
    			System.out.println("Get: Reminders History of Person with ID=" + id + " not found");
    			res = Response.status(404).build();
    		}
    		else
    		{
    			List<Reminder1> r1List = new ArrayList<Reminder1>();
    			for (int i=0; i<rList.size();i++){
    				Reminder r = rList.get(i);
    				Reminder1 r1 = new Reminder1(r.getIdReminder(),r.getDescription(),r.getTypeReminder(),r.getWDay(),r.getMDay(),r.getSDate(),r.getStatus(),r.getDateRegistered());
    	 	    	System.out.println(r1);
    				r1List.add(r1);
    			}
    	        res = Response.ok().entity(new GenericEntity<List<Reminder1>>(r1List){}).build();
    		}         
        }
        return res;
    }
    
}
