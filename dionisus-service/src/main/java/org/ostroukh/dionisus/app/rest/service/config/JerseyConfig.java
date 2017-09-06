package org.ostroukh.dionisus.app.rest.service.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
/**
 *REST web-service configuration for Jersey
 * @author Eugene Ostroukh
 */
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig(){
        packages("org.ostroukh.dionisus.app.rest");
    }
}
