package org.ostroukh.dionisus.app.rest.ws;

import org.apache.commons.lang3.math.NumberUtils;
import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.rest.dto.CityDTO;
import org.ostroukh.dionisus.app.rest.ws.base.BaseResource;
import org.ostroukh.dionisus.app.service.CityService;
import org.ostroukh.dionisus.app.service.transform.Transformer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("cities")
/**
 * {@link CityResource} is REST web-ws that handles city-related requests
 * @author Eugene Ostroukh
 */
public class CityResource extends BaseResource{

    /**
     * Underlying source of data
     */
    private final CityService service;

    /**
     * DTO <--> Entity transformer
     */
    private final Transformer transformer;

    @Inject
    public CityResource(CityService service, Transformer transformer) {
        this.service = service;
        this.transformer = transformer;

        City city = new City("Grodno");
        city.setDistrict("gr");
        city.setRegion("GR");
        city.addEstablishment("BAZA", EstablishmentType.CLUB);
        service.saveCity(city);
    }

    /**
     * Returns all of existing cities
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityDTO> findCities(){
        return service.findCities().stream()
                .map(city -> transformer.transform(city, CityDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Saves new city instance
     * @param dto
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCity(CityDTO dto){
        service.saveCity(transformer.untransform(dto, City.class));
    }

    /**
     * Returns city with specified id
     * @param cityId
     * @return
     */
    @Path("/{cityId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCityById(@PathParam("cityId") final String cityId){
        if(!NumberUtils.isCreatable(cityId)){
            return BAD_REQUEST;
        }
        Optional<City> city = service.findCityById(NumberUtils.toInt(cityId));
        if(!city.isPresent()){
            return NOT_FOUND;
        }
        return ok(transformer.transform(city.get(), CityDTO.class));
    }
}
