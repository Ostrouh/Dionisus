package org.ostroukh.dionisus.app.service;

import org.ostroukh.dionisus.app.model.entity.geography.City;

import java.util.List;

/**
 * Entry point to perform operations
 * over geographic entities
 * @author Eugene Ostroukh
 */
public interface GeographicService {
    /**
     * Returns list of existing cities
     * @return
     */
    List<City> findCities();

    /**
     * Saves specified city instance
     * @param city
     */
    void saveCity(City city);
}
