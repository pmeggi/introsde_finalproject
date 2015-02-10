package introsde.finalproject.task.resources;

import introsde.finalproject.soap.Reminder;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;
import introsde.finalproject.task.model.Reminder1;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless // only used if the the application is deployed in a Java EE container
@LocalBean // only used if the the application is deployed in a Java EE container
public class ReminderPersonResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;
	int rid;


	public ReminderPersonResource(UriInfo uriInfo, Request request,int id, int rid) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.rid=rid;
	}
	
    // REQUEST #4 - GET /reminder/{id}/{rid} - return the info of reminder identified by {rid} for person {id} 
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getPersonReminder() {
    	
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Reading reminder ... " + this.rid+" of person ID="+this.id);
        Reminder r =storage.readPersonReminder(new Long(this.id), new Long(this.rid));
        
        if (r == null){
        	System.out.println("Get: Reminder RID=" + rid + " not found");
         	res = Response.status(404).build();       
        }
        else
        {
        	Reminder1 r1 = new Reminder1(r.getIdReminder(),r.getDescription(),r.getTypeReminder(),r.getWDay(),r.getMDay(),r.getSDate(),r.getStatus(),r.getDateRegistered());
 	    	
 	        res = Response.ok().entity(r1).build();         
        }
        
        return res;
    	   	
    }
    
    
    // REQUEST #5 - DELETE /reminder/{id}/{rid} - delete the reminder identified by {rid} for person {id} 
    @DELETE
    @Produces(MediaType.TEXT_XML)
    public Response deletePersonReminder() {
    	
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Deleting reminder ... " + this.rid+" of person ID="+this.id);
        Reminder existing = storage.readPersonReminder(new Long(this.id), new Long (this.rid));
        
        if (existing== null)
        {
            System.out.println("DELETE: Reminder with GID=" + this.rid + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	System.out.println("Deleting reminder... " + existing.getIdReminder());
       	
        	int result=storage.removePersonReminder(new Long(this.rid));
            
            if (result == 1)
            	res = Response.ok().build();
            else
            	res = Response.status(404).build();       
        }
        return res;
    }

    // REQUEST #6 - PUT /reminder/{id}/{rid} - update the reminder identified by {rid} for person {id}
    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response putPersonReminder(Reminder1 r) {
        System.out.println("--> Updating Reminder... " +this.rid);
       
        Response res;
        
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        Reminder existing = storage.readPersonReminder(new Long(this.id), new Long(this.rid));
        
        if (existing == null) {
        	res = Response.status(404).build();
        } else {
        	System.out.println("--> Existing Reminder... " +existing.getIdReminder());
        	existing.setDescription(r.getDescription());
        	existing.setTypeReminder(r.getType());
        	existing.setWDay(r.getWDay());
        	existing.setMDay(r.getMDay());
        	existing.setSDate(r.getSDate());
        	existing.setDateRegistered(r.getCreated());
        	existing.setStatus(r.getStatus());
 	    	
            Reminder updated = storage.editPersonReminder(new Long(this.id), existing);
            Reminder1 updated1 = new Reminder1(updated.getIdReminder(),updated.getDescription(),updated.getTypeReminder(),updated.getWDay(),updated.getMDay(),updated.getSDate(),updated.getStatus(),updated.getDateRegistered());
 	    	
        	res = Response.created(uriInfo.getAbsolutePath()).entity(updated1).build();
        }
        return res;
    }
    
    
}