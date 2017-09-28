package org.ostroukh.dionisus.app.service.impl;

import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.model.search.criteria.EstablishmentCriteria;
import org.ostroukh.dionisus.app.model.search.criteria.range.RangeCriteria;
import org.ostroukh.dionisus.app.persistence.repository.CityRepository;
import org.ostroukh.dionisus.app.service.CityService;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Default implementation of the {@link CityService}
 * @author Eugene Ostroukh
 */
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Inject
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findCityById(int id) {
        return Optional.ofNullable(cityRepository.findById(id));
    }

    @Override
    public List<Establishment> searchEstablishments(EstablishmentCriteria criteria, RangeCriteria rangeCriteria) {
        Set<Establishment> establishments = new HashSet<>();

        cityRepository.findAll().forEach(city -> establishments.addAll(city.getEstablishments()));
        return establishments.stream()
                .filter(establishment -> establishment.match(criteria))
                .collect(Collectors.toList());
    }

    @Override
    public void saveCity(City city) {
       cityRepository.save(city);
    }
}
