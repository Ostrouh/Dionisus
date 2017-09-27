package org.ostroukh.dionisus.app.rest.ws;

import org.ostroukh.dionisus.app.rest.ws.base.BaseResource;
import org.ostroukh.dionisus.app.service.EstablishmentService;
import org.ostroukh.dionisus.app.service.impl.EstablishmentServiceImpl;
import org.ostroukh.dionisus.app.service.transform.Transformer;
import org.ostroukh.dionisus.app.service.transform.impl.TransformerImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("establishments")
/**
 * {@link EstablishmentResource} is REST web-ws that handles city-related requests
 * @author Eugene Ostroukh
 */

public class EstablishmentResource extends BaseResource{
    /**
     * Underlying source of data
     */
    private final EstablishmentService service;

    /**
     * DTO <--> Entity transformer
     */
    private final Transformer transformer;

    public EstablishmentResource() {
        service = new EstablishmentServiceImpl();
        transformer = new TransformerImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> findEstablishments(){
        return Arrays.asList("Paluba", "Hudini");
    }
}
