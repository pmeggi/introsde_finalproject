package introsde.finalproject.resources;

import introsde.finalproject.model.MeasureHistory1;
import introsde.finalproject.soap.MeasureHistory;
import introsde.finalproject.soap.MeasureType;

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
public class PersonMeasureResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    int idPerson;
    int idMeasure;
    String measureType;

    public PersonMeasureResource(UriInfo uriInfo, Request request,int personId, String measure, int measureId) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.idPerson = personId;
        this.measureType=measure;
        this.idMeasure=measureId;
    }

    // REQUEST #5 - GET /person/{id}/{measure}/{mid} - return the value of {measure} identified by {mid} for person {id}
    // Application integration
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getPersonMeasure() {
    	Response res;
    	System.out.println("Reading Measure History ("+measureType+") from DB for person with id: "+idPerson+" with MID ="+idMeasure);
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        MeasureType mType=storage.readMeasureType(this.measureType);
    	
    	if (mType==null)
        {
        	System.out.println("Get: Measure ("+measureType+") not found");
    		res = Response.status(404).build();
        }
        else
        {
        	MeasureHistory measureH = storage.readPersonMeasurement(new Long(this.idPerson), this.measureType,new Long(this.idMeasure));
        	if (measureH == null)
        	{	
        		System.out.println("Get: Measure ("+measureType+") with MID="+ idMeasure +" of Person with ID=" + idPerson + " not found");
        		res = Response.status(404).build();
        	}
        	else
        	{
        		MeasureHistory1 m1 = new MeasureHistory1(measureH.getMid(), measureH.getMeasureType().getMeasure(), measureH.getMeasureValue(), measureH.getDateRegistered());
        		
        		res = Response.ok().entity(m1).build();   
        	}
        }
        return res;
    }

    // REQUEST #5 - GET /person/{id}/{measure}/{mid} - return the value of {measure} identified by {mid} for person {id}
    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersonMeasureBrowser() {
       	Response res;
    	System.out.println("Reading Measure History ("+measureType+") from DB for person with id: "+idPerson+" with MID ="+idMeasure);
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        MeasureType mType=storage.readMeasureType(this.measureType);
    	
    	if (mType==null)
        {
        	System.out.println("Get: Measure ("+measureType+") not found");
    		res = Response.status(404).build();
        }
        else
        {
        	MeasureHistory measureH = storage.readPersonMeasurement(new Long(this.idPerson), this.measureType,new Long(this.idMeasure));
        	if (measureH == null)
        	{	
        		System.out.println("Get: Measure ("+measureType+") with MID="+ idMeasure +" of Person with ID=" + idPerson + " not found");
        		res = Response.status(404).build();
        	}
        	else
        	{
        		res = Response.ok().entity(measureH).build();   
        	}
        }
        return res;
    }
    
    
    // REQUEST #6 - PUT /person/{id}/{measure}/{mid} - update the value of {measure} identified by {mid} for person {id}
    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response putPersonMeasurement(MeasureHistory1 m) {
        System.out.println("--> Updating MeasureHistory... " +this.idMeasure);
       
        Response res;
        
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        MeasureHistory existing = storage.readPersonMeasurement(new Long(this.idPerson), this.measureType, new Long(this.idMeasure));
        
        if (existing == null) {
        	res = Response.status(404).build();
        } else {
        	System.out.println("--> Existing Measurement... " +existing.getMid());
            existing.setDateRegistered(m.getCreated());
            existing.setMeasureValue(m.getValue());
            
            MeasureHistory updated = storage.editPersonMeasurement(new Long(this.idPerson), measureType, existing);
        	MeasureHistory1 updated1 = new MeasureHistory1(updated.getMid(),updated.getMeasureType().getMeasure(),updated.getMeasureValue(),updated.getDateRegistered());
            
        	res = Response.created(uriInfo.getAbsolutePath()).entity(updated1).build();
        }
        return res;
    }

    // REQUEST #7 - DELETE /person/{id}/{measure}/{mid} - delete the value of {measure} identified by {mid} for person {id} 
    @DELETE
    @Produces(MediaType.TEXT_XML)
    public Response deletePersonMeasurement() {
    	
    	Response res;
    	
    	StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        MeasureHistory existing = storage.readPersonMeasurement(new Long(this.idPerson), this.measureType, new Long(this.idMeasure));
        if (existing== null)
        {
            System.out.println("DELETE: Measurement with MID=" + this.idMeasure + " not found");
            res = Response.status(404).build();
        }
        else
        {
        	System.out.println("Deleting measurement... " + existing.getMid());
        	storage.removePersonMeasurement(new Long(this.idMeasure));
        	
        	res = Response.ok().build();          
        }
        return res;
    	   	
    }

   
}