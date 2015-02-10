package introsde.finalproject.resources;

import introsde.finalproject.model.MeasureType;
import introsde.finalproject.storage.soap.Storage;
import introsde.finalproject.storage.soap.StorageService;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/measures")
public class MeasureCollectionResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // REQUEST #7 - GET /measures 
    // Return the list of measures to the user in the browser
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String[] getMeasuresJSON() {
        System.out.println("Getting list of JSON measure type...");
        
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        
        List<String> measures=storage.readMeasureTypes();
       
        return measures.toArray(new String[measures.size()]);
 	       
    }
    
    // REQUEST #7 - GET /measures 
    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    public List<MeasureType> getMeasuresXML() {
        System.out.println("Getting list of XML measure type...");
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        List<String> measures=storage.readMeasureTypes();
        
        List<MeasureType> mList = new ArrayList<MeasureType>(); 
        
        for (int i=0;i<measures.size();i++)
        {
        	mList.add(new MeasureType(measures.get(i)));
        }
     
        return mList;
    }
}