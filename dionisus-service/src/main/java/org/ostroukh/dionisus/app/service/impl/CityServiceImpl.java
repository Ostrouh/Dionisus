package org.ostroukh.dionisus.app.service.impl;

import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.model.search.criteria.EstablishmentCriteria;
import org.ostroukh.dionisus.app.model.search.criteria.range.RangeCriteria;
import org.ostroukh.dionisus.app.service.CityService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Default implementation of the {@link CityService}
 * @author Eugene Ostroukh
 */
public class CityServiceImpl implements CityService {

    private final List<City> cities;
    private int counter = 0;

    public CityServiceImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public Optional<City> findCityById(int id) {
        return cities.stream()
                .filter(city -> city.getId() == id)
                .findFirst();
    }

    @Override
    public List<Establishment> searchEstablishments(EstablishmentCriteria criteria, RangeCriteria rangeCriteria) {
        Set<Establishment> establishments = new HashSet<>();

        for(City city: cities){
            establishments.addAll(city.getEstablishments());
        }

        return establishments.stream()
                .filter(establishment -> establishment.match(criteria))
                .collect(Collectors.toList());
    }

    @Override
    public void saveCity(City city) {
        if(!cities.contains(city)){
            city.setId(++counter);
            cities.add(city);
        }
    }
}
