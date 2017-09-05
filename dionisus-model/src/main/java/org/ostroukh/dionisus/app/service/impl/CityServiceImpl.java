package org.ostroukh.dionisus.app.service.impl;

import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.service.CityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the {@link CityService}
 * @author Eugene Ostroukh
 */
public class CityServiceImpl implements CityService {

    private final List<City> cities;

    public CityServiceImpl() {
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
