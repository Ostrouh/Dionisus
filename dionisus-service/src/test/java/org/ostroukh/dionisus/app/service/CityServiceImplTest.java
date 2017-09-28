package org.ostroukh.dionisus.app.service;

import org.junit.Before;
import org.junit.Test;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.model.search.criteria.EstablishmentCriteria;
import org.ostroukh.dionisus.app.model.search.criteria.range.RangeCriteria;
import org.ostroukh.dionisus.app.persistence.repository.inmemory.CityRepositoryInMemory;
import org.ostroukh.dionisus.app.service.impl.CityServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 *Contain unit-tests for {@link CityServiceImpl}
 * @author Eugene Ostroukh
 */
public class CityServiceImplTest {
    private final static int DEFAULT_CITY_ID = 1;
    private CityService service;

    @Before
    public void setup(){
        service = new CityServiceImpl(new CityRepositoryInMemory());
    }

    @Test
    public void testNoDataReturnedAtStart(){
        List<City> cities = service.findCities();
        assertTrue(cities.isEmpty());
    }

    @Test
    public void testFindCityByIdSuccess(){
        City city = new City("Grodno");
        service.saveCity(city);

        Optional<City> foundCity = service.findCityById(DEFAULT_CITY_ID);

        assertTrue(foundCity.isPresent());
        assertEquals(foundCity.get().getId(), DEFAULT_CITY_ID);
    }

    @Test
    public void testFoundCityByIdNotFound(){
        Optional<City> foundCity = service.findCityById(DEFAULT_CITY_ID);
        assertFalse(foundCity.isPresent());
    }

    @Test
    public void testSearchEstablByCityNameSuccess(){
        City city = new City("Grodno");
        city.setId(DEFAULT_CITY_ID);
        city.addEstablishment("Paluba", EstablishmentType.CAFE);
        city.addEstablishment("BAZA", EstablishmentType.CLUB);
        service.saveCity(city);

        List<Establishment> establishments =
                service.searchEstablishments(EstablishmentCriteria.byCityName("Grodno"), new RangeCriteria(1, 5));

        assertNotNull(establishments);
        assertEquals(establishments.size(), 2);
        assertEquals(establishments.get(0).getCity(), city);
    }

    @Test
    public void testSearchEstablByCityNameNotFound(){
        List<Establishment> establishments =
                service.searchEstablishments(EstablishmentCriteria.byCityName("Grodno"), new RangeCriteria(1, 5));
        assertNotNull(establishments);
        assertTrue(establishments.isEmpty());
    }
    @Test
    public void testSearchEstablByEstablTypeSuccess(){
        City city = new City("Grodno");

        city.addEstablishment("Paluba", EstablishmentType.CAFE);
        city.addEstablishment("Veras", EstablishmentType.CAFE);

        service.saveCity(city);

        List<Establishment> establishments =
        service.searchEstablishments(EstablishmentCriteria.byType(EstablishmentType.CAFE), new RangeCriteria(1, 5));

        assertNotNull(establishments);
        assertEquals(establishments.size(), 2);
    }

    @Test
    public void testSearchEstablByEstablTypeNotFound(){
        City city = new City("Grodno");

        city.addEstablishment("Paluba", EstablishmentType.CAFE);
        city.addEstablishment("Veras", EstablishmentType.CAFE);

        List<Establishment> establishments =
                service.searchEstablishments(new EstablishmentCriteria(EstablishmentType.CAFE), new RangeCriteria(1, 5));

        assertNotNull(establishments);
        assertTrue(establishments.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess(){
        City city = new City("Grodno");
        service.saveCity(city);

        List<City> cities = service.findCities();

        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Grodno");
    }
}
