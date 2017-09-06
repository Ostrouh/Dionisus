package org.ostroukh.dionisus.app.rest.service;

import jersey.repackaged.com.google.common.collect.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("establishments")
/**
 * {@link EstablishmentResource} is REST web-service that handles city-related requests
 * @author Eugene Ostroukh
 */

public class EstablishmentResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> findCities(){
        return Lists.newArrayList("Палуба", "Гудини");
    }
}
