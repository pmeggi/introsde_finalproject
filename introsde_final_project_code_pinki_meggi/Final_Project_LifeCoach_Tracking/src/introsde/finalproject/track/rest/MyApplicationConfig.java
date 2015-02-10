package introsde.finalproject.track.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("vLifeCoachTrackingService/resources")
public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig () {
        packages("introsde.finalproject.track.resources"); // Jersey will load all the resources under this package
    }
}