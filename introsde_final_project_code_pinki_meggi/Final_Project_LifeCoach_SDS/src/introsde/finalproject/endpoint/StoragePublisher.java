package introsde.finalproject.endpoint;

import introsde.finalproject.storage.soap.StorageImpl;

import javax.xml.ws.Endpoint;

public class StoragePublisher {
    public static String SERVER_URL = "http://localhost";
    public static String PORT = "666";
    public static String BASE_URL = "/soap/storage";

    public static String getEndpointURL() {
        return SERVER_URL+":"+PORT+BASE_URL;
    }

    public static void main(String[] args) {
        String endpointUrl = getEndpointURL();
        System.out.println("Starting Storage Service...");
        System.out.println("--> Published at = "+endpointUrl);
        Endpoint.publish(endpointUrl, new StorageImpl());
    }
}