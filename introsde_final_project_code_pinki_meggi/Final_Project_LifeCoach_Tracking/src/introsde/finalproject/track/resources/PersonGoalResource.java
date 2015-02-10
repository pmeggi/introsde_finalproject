package introsde.finalproject.track.resources;

import introsde.finalproject.soap.Goal;
import introsde.finalproject.soap.MeasureHistory;
import introsde.finalproject.soap.Person;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;




import introsde.finalproject.track.model.Goal1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless // only used if the the application is deployed in a Java EE container
@LocalBean // only used if the the application is deployed in a Java EE container
public class PersonGoalResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;


	public PersonGoalResource(UriInfo uriInfo, Request request,int id) {
	        this.uriInfo = uriInfo;
	        this.request = request;
	        this.id = id;
	}
		
	// REQUEST #1 - GET /goals/{id} - return the today reminders of person with {id} 
    // Application integration
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getPersonGoals() {
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        System.out.println("Reading the achieved goals for person with ID="+id);
        Person person=storage.readPersonInfo(new Long(this.id));
        
        
    	if (person == null)
        {
            System.out.println("Get: Person with " + id + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	System.out.println("Person found");
        	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        	Date date = new Date();
        	System.out.println(dateFormat.format(date));
        	
        	List<Goal> result = new ArrayList<Goal>();
        	
        	// get list of person goals
        	List<Goal> gList=storage.readPersonGoals(new Long(this.id));
        	
        	for(int i=0;i<gList.size();i++)
        	{
        		//for each defined goal, check if it is daily goal, then get the Today measure, ad check if goal achieved
        		System.out.println(gList.get(i));
        		Goal g = gList.get(i);
        		if (g.getGoalType().getType().equals("daily"))
        		{
        			MeasureHistory m = storage.readPersonMeasurementByDate(person.getIdPerson(),g.getGoalType().getMeasureType().getMeasure(), dateFormat.format(date));
        			if (m!=null)
        			{
        				if (g.getGoalType().getValueType().equals("minimum"))
        				{
        					if(Integer.parseInt(m.getMeasureValue())>=Integer.parseInt(g.getGoalValue()))
        						result.add(g);
        				}
        				else
        					if (g.getGoalType().getValueType().equals("maximum"))
            				{
            					if(Integer.parseInt(m.getMeasureValue())<=Integer.parseInt(g.getGoalValue()))
            						result.add(g);
            				}
        			}
        		}
        		
        	}	
        	
        	if (result.size() == 0)
    		{
    			System.out.println("Get: GOALS ACHIEVED of Person with ID=" + id + " not found");
    			res = Response.status(404).build();
    		}
    		else
    		{
    			String body = "";
    			List<Goal1> result1 = new ArrayList<Goal1>();
    			for (int i=0; i<result.size();i++){
    				Goal g = result.get(i);
    				Goal1 g1 = new Goal1(g.getIdGoal(),g.getGoalValue(),g.getGoalType().getMeasureType().getMeasure(),g.getGoalType().getType(),g.getDateRegistered(),g.getStatus());
    	 	    	
    	 	    	System.out.println(g1);
    				result1.add(g1);
    				body=body.concat(g1.getMeasure()+" "+g1.getValue()).concat("\n");
    			}
    			//send email to the person informing about the achieved goals of today
    			storage.sendPersonEmail(person.getEmail(), "TODAYS ACHIEVED GOALS", body);
    	        res = Response.ok().entity(new GenericEntity<List<Goal1>>(result1){}).build();
    		}         
        }
        return res;
    }

    public String getTodaysDayOfWeek() {
    	  final Calendar c = Calendar.getInstance();
    	  int d= c.get(Calendar.DAY_OF_WEEK);
    	  switch (d) {
    	    case 1: return "Sunday";
    	    case 2: return "Monday";
    	    case 3: return "Tuesday";
    	    case 4: return "Wednesday";
    	    case 5: return "Thursday";
    	    case 6: return "Friday";
    	    case 7: return "Saturday";
      	  }
    	  return "";
    }
}
