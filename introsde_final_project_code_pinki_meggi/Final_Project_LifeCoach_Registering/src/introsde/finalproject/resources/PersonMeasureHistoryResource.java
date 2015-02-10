package introsde.finalproject.resources;

import java.util.ArrayList;
import java.util.List;

import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;
import introsde.finalproject.soap.MeasureHistory;
import introsde.finalproject.soap.MeasureType;
import introsde.finalproject.soap.Person;
import introsde.finalproject.model.MeasureHistory1;

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
public class PersonMeasureHistoryResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    int id;
    String measure;

    public PersonMeasureHistoryResource(UriInfo uriInfo, Request request,int id, String measure) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        this.measure=measure;
    }

    // REQUEST #3 - GET /person/{id}/{measure} - return the {measure} history of person {id} 
    // Application integration
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getPersonMeasureHistory() {
    	List<MeasureHistory> measureH=null;
    	Response res;
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        MeasureType m = storage.readMeasureType(measure);
    	
    	if (m==null)
		{
			System.out.println("Get: Measure ("+measure+") not found");
			res = Response.status(404).build();
		}
		else
		{	
			measureH=storage.readPersonMeasureHistory(new Long(this.id), this.measure);
	                		
    		if (measureH == null)
    		{
    			System.out.println("Get: Measure History ("+measure+") of Person with ID=" + id + " not found");
    			res = Response.status(404).build();
    		}
    		else
    		{
    			List<MeasureHistory1> list = new ArrayList<MeasureHistory1>();
    			for (int i=0; i<measureH.size();i++){
    				MeasureHistory mh = measureH.get(i);
    				MeasureHistory1 mh1 = new MeasureHistory1(mh.getMid(),mh.getMeasureType().getMeasure(), mh.getMeasureValue(),mh.getDateRegistered());
    				list.add(mh1);
    				System.out.println(mh1);
    			}
    	        res = Response.ok().entity(new GenericEntity<List<MeasureHistory1>>(list){}).build();
    		}
    	}
    	return res;
     }

    // for the browser
    // REQUEST #3 - GET /person/{id}/{measure} - return the {measure} history of person {id} 
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersonMeasureHistoryBrowser() {
    	List<MeasureHistory> measureH=null;
    	Response res;
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        MeasureType m = storage.readMeasureType(measure);
    	
    	if (m==null)
		{
			System.out.println("Get: Measure ("+measure+") not found");
			res = Response.status(404).build();
		}
		else
		{	
			measureH=storage.readPersonMeasureHistory(new Long(this.id), this.measure);
	                		
    		if (measureH == null)
    		{
    			System.out.println("Get: Measure History ("+measure+") of Person with ID=" + id + " not found");
    			res = Response.status(404).build();
    		}
    		else
    		{
    			List<MeasureHistory1> list = new ArrayList<MeasureHistory1>();
    			for (int i=0; i<measureH.size();i++){
    				MeasureHistory mh = measureH.get(i);
    				MeasureHistory1 mh1 = new MeasureHistory1(mh.getMid(),mh.getMeasureType().getMeasure(), mh.getMeasureValue(),mh.getDateRegistered());
    				list.add(mh1);
    			}
    	        res = Response.ok().entity(new GenericEntity<List<MeasureHistory1>>(list){}).build();
    		}
    	}
    	return res;
    }
    
    // REQUEST #4 - POST /person/{id}/{measure} - should update the new value of {measure} of person {id} and archive the old 
    @POST
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response updateMeasure(MeasureHistory1 measureH) {
         
    	Response res;
    	System.out.println("Creating the new value of measure "+measure+" for person with ID="+id);
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
    	
    	Person p = storage.readPersonInfo(new Long(this.id));
    	System.out.println("MEASURE VALUE: "+measureH.getValue());
    	
    	if (p==null)
    	{
    		System.out.println("POST: Person ("+this.id+") not found");
    		res = Response.status(404).build();
    	}
 	    else
    	{
 	    	MeasureHistory m = new MeasureHistory();
 	    	MeasureHistory1 m1 = new MeasureHistory1();
 	    	
 	    	m.setMeasureValue(measureH.getValue());
 	    	m.setDateRegistered(measureH.getCreated());
 	    	m= storage.registerPersonMeasure(p.getIdPerson(), this.measure, m);
 	    	
 	    	m1.setMid(m.getMid());
 	    	m1.setMeasure(m.getMeasureType().getMeasure());
 	    	m1.setValue(m.getMeasureValue());
 	    	m1.setCreated(m.getDateRegistered());
 	    	
 	    	res = Response.created(uriInfo.getAbsolutePath()).entity(m1).build();        
    	}
        return res;
    }
      
}