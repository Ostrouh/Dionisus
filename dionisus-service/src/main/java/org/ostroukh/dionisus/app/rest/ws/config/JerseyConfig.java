package org.ostroukh.dionisus.app.rest.ws.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.ostroukh.dionisus.app.config.ComponentFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
/**
 *REST web-ws configuration for Jersey
 * @author Eugene Ostroukh
 */
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig(){
        super(ComponentFeature.class);
        packages("org.ostroukh.dionisus.app.rest");
    }
}
