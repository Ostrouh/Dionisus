package org.ostroukh.dionisus.app.service;

import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.model.search.criteria.EstablishmentCriteria;
import org.ostroukh.dionisus.app.model.search.criteria.range.RangeCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Entry point to perform operations
 * over geographic entities
 * @author Eugene Ostroukh
 */
public interface CityService {
    /**
     * Returns list of existing cities
     * @return
     */
    List<City> findCities();

    /**
     * Returns city with specified id.
     * If no city is found then returns empty optional.
     * @param id
     * @return
     */
    Optional<City> findCityById(int id);

    /**
     * Returns all establishments that match specified criteria
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    List<Establishment> searchEstablishments(EstablishmentCriteria criteria, RangeCriteria rangeCriteria);

    /**
     * Saves specified city instance
     * @param city
     */
    void saveCity(City city);
}
