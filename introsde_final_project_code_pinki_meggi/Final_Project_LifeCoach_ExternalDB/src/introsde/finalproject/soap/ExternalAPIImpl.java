package introsde.finalproject.soap;

import introsde.finalproject.model.PostmarkEmail;

import java.net.URI;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

//Service Implementation

@WebService(endpointInterface = "introsde.finalproject.soap.ExternalAPI",
  serviceName="ExternalAPIService")
public class ExternalAPIImpl implements ExternalAPI{

	@Override
	public int sendEmail(String email, String subject, String content)
	{
		ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("https://api.postmarkapp.com"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        
        PostmarkEmail e = new PostmarkEmail("pmeggi@isctem.ac.mz", email, subject, content);
        
        Response response = service.path("/email").request(MediaType.APPLICATION_JSON)
        		.header("Content-type","application/json")
        		.header("X-Postmark-Server-Token","1190c977-cbe4-4dba-bfbe-c11d897d3c5f")
        		.post(Entity.entity(e, media));
         
        return response.getStatus();
       
     }
	
	@Override
	public String getRandomQuote()
	{
		ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget service = client.target(getBaseURI("http://www.iheartquotes.com"));
        MediaType media = MediaType.valueOf(MediaType.APPLICATION_JSON);
        
        Response response = service.path("/api/v1/random").request().accept(media).get();
        
        String quote = response.readEntity(String.class).toString();
        
         
        System.out.println(response.getStatus());
        System.out.println(quote);
        
        return quote;
       
     }
	
	 private static URI getBaseURI(String URI) {
			return UriBuilder.fromUri(URI).build();
		}
   
}
