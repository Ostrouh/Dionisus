package org.ostroukh.dionisus.app.persistence.repository.inmemory;

import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.persistence.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the {@link CityRepository} that stores
 * data in the RAM
 */
public class CityRepositoryInMemory implements CityRepository {
    /**
     * Internal list of cities
     */
    private final List<City> cities;

    /**
     * Autoincrement counter for city id generation
     */
    private int counter = 0;

    private int establCounter = 0;

    public CityRepositoryInMemory() {
        cities = new ArrayList<>();
    }

    @Override
    public void save(City city) {
        if(!cities.contains(city)){
            city.setId(++counter);
            cities.add(city);
        }
        city.getEstablishments().forEach(establishment -> {
            if(establishment.getId() == 0){
                establishment.setId(++establCounter);
            }
        });

    }

    @Override
    public City findById(int cityId) {
        return cities.stream()
                .filter(city -> city.getId() == cityId)
                .findFirst().orElse(null);
    }

    @Override
    public void delete(int cityId) {

    }

    @Override
    public List<City> findAll() {
        return CommonUtil.getSafeList(cities);
    }
}
