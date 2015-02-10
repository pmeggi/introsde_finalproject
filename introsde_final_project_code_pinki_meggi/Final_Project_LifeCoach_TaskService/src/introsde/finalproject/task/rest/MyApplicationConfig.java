package introsde.finalproject.task.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("vLifeCoachTaskService/resources")
public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig () {
        packages("introsde.finalproject.task.resources"); // Jersey will load all the resources under this package
    }
}