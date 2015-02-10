package introsde.finalproject.goal.resources;
import introsde.finalproject.goal.model.GoalType1;

import introsde.finalproject.soap.GoalType;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/goal")
public class GoalCollectionResource {

	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    
    // REQUEST #1 - GET /goal - list all goals type in database
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GoalType1[] getGoalsBrowser() {
        System.out.println("Getting list of goals type...");
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        List<GoalType> gList=storage.readGoalTypes();
        
        List<GoalType1> g1List= new ArrayList<GoalType1>();
        for (int i=0;i<gList.size();i++)
        {
        	GoalType g = gList.get(i);
        	//System.out.println(g);
        	g1List.add(new GoalType1(g.getIdGoalType(),g.getDescription(),g.getMeasureType().getMeasure(),g.getType(),g.getValueType()));
        }
        
        System.out.println("returning g1List");
        
        return g1List.toArray(new GoalType1[g1List.size()]);
    }
    
    @GET
    @Produces({MediaType.TEXT_XML,MediaType.APPLICATION_XML})
    public List<GoalType1> getGoalsXML() {
        System.out.println("Getting list of goals type...");
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        List<GoalType> gList=storage.readGoalTypes();
        
        List<GoalType1> g1List= new ArrayList<GoalType1>();
        for (int i=0;i<gList.size();i++)
        {
        	GoalType g = gList.get(i);
        	g1List.add(new GoalType1(g.getIdGoalType(),g.getDescription(),g.getMeasureType().getMeasure(),g.getType(),g.getValueType()));
        }
        
        return g1List;
    }
    
    // REQUEST #2 - POST /goal/{id} - create goal for person with {id}
    // REQUEST #3 - GET /goal/{id} - return the goals of person with {id}
    @Path("{personId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public GoalResource getPerson(@PathParam("personId") int id) {
        return new GoalResource(uriInfo, request, id);
    }
    
    
    // REQUEST #4 - GET /goal/{id}/{gid} - return the goal identified by {gid} of person {id} 
    // REQUEST #5 - DELETE /goal/{id}/{gid} - delete the goal identified by {gid} of person {id} 
    // REQUEST #6 - PUT /goal/{id}/{gid} - edit the goal identified by {gid} of person {id} 
    @Path("{personId}/{gid}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public GoalPersonResource deletePersonGoal(@PathParam("personId") int id, @PathParam("gid") int gid) {
        return new GoalPersonResource(uriInfo, request, id, gid);
    }
    
    
}
