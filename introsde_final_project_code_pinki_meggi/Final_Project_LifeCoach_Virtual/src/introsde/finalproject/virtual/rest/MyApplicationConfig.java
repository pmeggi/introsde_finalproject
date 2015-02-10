package introsde.finalproject.virtual.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("vLifeCoachService/resources")
public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig () {
        packages("introsde.finalproject.virtual.resources"); // Jersey will load all the resources under this package
    }
}