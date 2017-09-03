package org.ostroukh.dionisus.app.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.service.impl.GeographicServiceImpl;

import java.util.List;

/**
 *Contain unit-tests for {@link GeographicServiceImpl}
 * @author Eugene Ostroukh
 */
public class GeographicServiceImplTest {
    private GeographicService service;

    @Before
    public void setup(){
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart(){
        List<City> cities = service.findCities();
        assertTrue(cities.isEmpty());
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
