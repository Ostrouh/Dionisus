package org.ostroukh.dionisus.app.service.impl;

import org.apache.commons.lang3.StringUtils;
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
        Optional<Set<Establishment>> establs = cities.stream()
                .filter(city -> StringUtils.isEmpty(criteria.getName())
                                || criteria.getCity().getName().equals(city.getName()))
                .map(city -> city.getEstablishments())
                .reduce((establs1, establs2) -> {
                    Set<Establishment> newEstabls = new HashSet<>(establs2);
                    return newEstabls;
                });
        if(!establs.isPresent()){
            return Collections.emptyList();
        }

        return establs.get()
                .stream()
                .filter(establishment -> criteria.getEstablishmentType() == null
                || establishment.getEstablishmentType() == criteria.getEstablishmentType())
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
