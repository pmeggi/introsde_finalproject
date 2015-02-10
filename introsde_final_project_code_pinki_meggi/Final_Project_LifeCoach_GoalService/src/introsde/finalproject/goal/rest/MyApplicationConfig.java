package introsde.finalproject.goal.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("vLifeCoachGoalService/resources")
public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig () {
        packages("introsde.finalproject.goal.resources"); // Jersey will load all the resources under this package
    }
}