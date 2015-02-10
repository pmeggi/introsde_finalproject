package introsde.finalproject.goal.resources;

import java.util.ArrayList;
import java.util.List;

import introsde.finalproject.goal.model.Goal1;
import introsde.finalproject.soap.Goal;
import introsde.finalproject.soap.Person;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;

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
public class GoalResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;


	public GoalResource(UriInfo uriInfo, Request request,int id) {
	        this.uriInfo = uriInfo;
	        this.request = request;
	        this.id = id;
	}
	

	// REQUEST #2 - POST /goal/{id} - should create the new goal for person {id}  
    @POST
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response createPersonGoal(Goal1 goal) {
         
    	Response res;
    	System.out.println("Creating the new goal for person with ID="+id);
    	
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
 	    	Goal g = new Goal();
 	    	
 	    	g.setGoalValue(goal.getValue());
 	    	g.setDateRegistered(goal.getCreated());
 	    	g.setStatus(goal.getStatus());
 	    	
 	    	Goal newG = storage.registerPersonGoal(new Long(this.id), goal.getMeasure(), goal.getType(), g);
 	    	
			Goal1 g1 = new Goal1(newG.getIdGoal(),newG.getGoalValue(),newG.getGoalType().getMeasureType().getMeasure(),newG.getGoalType().getType(),newG.getDateRegistered(),newG.getStatus());
 	    	
 	    	res = Response.created(uriInfo.getAbsolutePath()).entity(g1).build();        
    	}
        return res;
    }
	
	// REQUEST #3 - GET /goal/{id} - return the goals of person with {id} 
    // Application integration
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getPersonGoals() {
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Reading the goals for person with ID="+id);
        Person person=storage.readPersonInfo(new Long(this.id));
        
        
    	if (person == null)
        {
            System.out.println("Get: Person with " + id + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	List<Goal> gList=storage.readPersonGoals(new Long(this.id));
        	
    		if (gList == null)
    		{
    			System.out.println("Get: Goals History of Person with ID=" + id + " not found");
    			res = Response.status(404).build();
    		}
    		else
    		{
    			List<Goal1> g1List = new ArrayList<Goal1>();
    			for (int i=0; i<gList.size();i++){
    				Goal g = gList.get(i);
    				Goal1 g1 = new Goal1(g.getIdGoal(),g.getGoalValue(),g.getGoalType().getMeasureType().getMeasure(),g.getGoalType().getType(),g.getDateRegistered(),g.getStatus());
    				System.out.println(g1);
    				g1List.add(g1);
    			}
    	        res = Response.ok().entity(new GenericEntity<List<Goal1>>(g1List){}).build();
    		}         
        }
        return res;
    }
    
}
