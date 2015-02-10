package introsde.finalproject.client;

import introsde.finalproject.soap.ExternalAPI;

import java.net.URL;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestClient {
	 public static void main(String[] args) throws Exception {
	        URL url = new URL("http://localhost:778/soap/externalapi?wsdl");
	        //1st argument service URI, refer to wsdl document above
	        //2nd argument is service name, refer to wsdl document above
	        QName qname = new QName("http://soap.finalproject.introsde/", "ExternalAPIService");
	        Service service = Service.create(url, qname);
	        ExternalAPI ext = service.getPort(ExternalAPI.class);
	        //System.out.println(ext.sendEmail("pinki.meggi@gmail.com", "TEST FROM CLIENT APP", "Helllo, Testing from Client Program"));
	        System.out.println(ext.getRandomQuote());
	 
	 }
}
