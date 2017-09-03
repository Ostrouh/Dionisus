package org.ostroukh.dionisus.app.service.impl;

import org.ostroukh.dionisus.app.infra.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.service.GeographicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the {@link GeographicService}
 * @author Eugene Ostroukh
 */
public class GeographicServiceImpl implements GeographicService {

    private final List<City> cities;

    public GeographicServiceImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public void saveCity(City city) {
        if(!cities.contains(city)){
            cities.add(city);
        }
    }
}
