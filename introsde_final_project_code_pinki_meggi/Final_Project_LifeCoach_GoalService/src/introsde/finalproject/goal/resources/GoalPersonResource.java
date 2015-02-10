package introsde.finalproject.goal.resources;


import introsde.finalproject.goal.model.Goal1;

import introsde.finalproject.soap.Goal;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;

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
public class GoalPersonResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;
	int gid;


	public GoalPersonResource(UriInfo uriInfo, Request request,int id, int gid) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.gid=gid;
	}
	
    // REQUEST #4 - GET /goal/{id}/{gid} - return the info of goal identified by {gid} for person {id} 
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getPersonGoal() {
    	
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Reading goal ... " + this.gid+" of person ID="+this.id);
        Goal g =storage.readPersonGoal(new Long(this.id), new Long(this.gid));
        
        if (g == null){
        	System.out.println("Get: Goals GID=" + gid + " not found");
         	res = Response.status(404).build();       
        }
        else
        {
        	Goal1 g1 = new Goal1(g.getIdGoal(),g.getGoalValue(),g.getGoalType().getMeasureType().getMeasure(),g.getGoalType().getType(),g.getDateRegistered(),g.getStatus());
 	    	
        	res = Response.ok().entity(g1).build();         
        }
        
        return res;
    	   	
    }
    
    
    // REQUEST #5 - DELETE /goal/{id}/{gid} - delete the goal identified by {gid} for person {id} 
    @DELETE
    @Produces(MediaType.TEXT_XML)
    public Response deletePersonGoal() {
    	
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Deleting goal ... " + this.gid+" of person ID="+this.id);
        Goal existing = storage.readPersonGoal(new Long(this.id), new Long (this.gid));
        
        if (existing== null)
        {
            System.out.println("DELETE: Goal with GID=" + this.gid + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	System.out.println("Deleting goal... " + existing.getIdGoal());
       	
        	int result=storage.removePersonGoal(new Long(this.gid));
            
            if (result == 1)
            	res = Response.ok().build();
            else
            	res = Response.status(404).build();       
        }
        return res;

       	   	
    }
    
    // REQUEST #6 - PUT /goal/{id}/{gid} - update the value of goal identified by {gid} for person {id}
    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response putPersonGoal(Goal1 g) {
        System.out.println("--> Updating Gaol... " +this.gid);
       
        Response res;
        
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        Goal existing = storage.readPersonGoal(new Long(this.id), new Long(this.gid));
        
        if (existing == null) {
        	res = Response.status(404).build();
        } else {
        	System.out.println("--> Existing Goal... " +existing.getIdGoal());
            existing.setDateRegistered(g.getCreated());
            existing.setGoalValue(g.getValue());
            existing.setStatus(g.getStatus());
        	
        	Goal updated = storage.editPersonGoal(new Long(this.id), g.getMeasure(),g.getType(), existing);
        	Goal1 updated1 = new Goal1(updated.getIdGoal(),updated.getGoalValue(),updated.getGoalType().getMeasureType().getMeasure(),updated.getGoalType().getType(),updated.getDateRegistered(),updated.getStatus());
 	    	
        	res = Response.created(uriInfo.getAbsolutePath()).entity(updated1).build();
        }
        return res;
    }

    
    
}
