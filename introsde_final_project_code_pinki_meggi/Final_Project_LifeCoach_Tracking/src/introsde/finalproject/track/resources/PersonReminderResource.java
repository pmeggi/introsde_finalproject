package introsde.finalproject.track.resources;

import introsde.finalproject.soap.Person;
import introsde.finalproject.soap.Reminder;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;
import introsde.finalproject.track.model.Reminder1;

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
public class PersonReminderResource {
	
	@Context
    UriInfo uriInfo;
	@Context
	Request request;
	int id;


	public PersonReminderResource(UriInfo uriInfo, Request request,int id) {
	        this.uriInfo = uriInfo;
	        this.request = request;
	        this.id = id;
	}
		
	// REQUEST #1 - GET /reminders/{id} - return the today reminders of person with {id} 
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
        	System.out.println("Person found");
        	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        	Date date = new Date();
        	System.out.println(dateFormat.format(date));
        	
        	List<Reminder> result = new ArrayList<Reminder>();
        	
        	//specific date reminder
        	List<Reminder> rList=storage.readPersonRemindersByDate(new Long(this.id),dateFormat.format(date));
        	for(int i=0;i<rList.size();i++)
        	{
        		System.out.println(rList.get(i));
        		result.add(rList.get(i));
        	}
        	
        	//daily reminder
        	List<Reminder> r1List=storage.readPersonReminders(new Long(this.id));
        	for(int i=0;i<r1List.size();i++)
        	{
        		Reminder r = r1List.get(i);
        		if (r.getTypeReminder().equals("daily"))
        			result.add(r);
        		else
        			if (r.getTypeReminder().equals("weekly"))
        			{
        				String wDay = r.getWDay();
        				if (wDay.equals(getTodaysDayOfWeek()))
        					result.add(r);
        	     	}
        			else
        				if (r.getTypeReminder().equals("monthly"))
            			{
        					dateFormat = new SimpleDateFormat("dd");
        		        	
        					String mDay = r.getMDay();
        					if (mDay.equals(dateFormat.format(date)))
        						result.add(r);
        				}
           	}
        	
        	if (result.size() == 0)
    		{
    			System.out.println("Get: Reminders History of Person with ID=" + id + " not found");
    			res = Response.status(404).build();
    		}
    		else
    		{
    			List<Reminder1> result1 = new ArrayList<Reminder1>();
    			for (int i=0; i<result.size();i++){
    				Reminder r = result.get(i);
    				Reminder1 r1 = new Reminder1(r.getIdReminder(),r.getDescription(),r.getTypeReminder(),r.getWDay(),r.getMDay(),r.getSDate(),r.getStatus(),r.getDateRegistered());
    	 	    	System.out.println(r1);
    				result1.add(r1);
    			}
    	        res = Response.ok().entity(new GenericEntity<List<Reminder1>>(result1){}).build();
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
