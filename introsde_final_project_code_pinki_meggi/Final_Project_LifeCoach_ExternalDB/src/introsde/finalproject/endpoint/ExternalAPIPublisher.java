package introsde.finalproject.endpoint;

import introsde.finalproject.soap.ExternalAPIImpl;

import javax.xml.ws.Endpoint;

public class ExternalAPIPublisher {

    public static String SERVER_URL = "http://localhost";
    public static String PORT = "778";
    public static String BASE_URL = "/soap/externalapi";

    public static String getEndpointURL() {
        return SERVER_URL+":"+PORT+BASE_URL;
    }

    public static void main(String[] args) {
        String endpointUrl = getEndpointURL();
        System.out.println("Starting EXTERNAL API service...");
        System.out.println("--> Published at = "+endpointUrl);
        Endpoint.publish(endpointUrl, new ExternalAPIImpl());
    }
}