package org.ostroukh.dionisus.app.model.entity.geography;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Contains unit-tests to check functionality of {@link City} class
 * @author Eugene Ostroukh
 */
public class CityTest {
    private City city;

    @Before
    public void setup(){
        city = new City();
    }

    @Test
    public void testAddValidEstablishmentSuccess() {
        Establishment establishment = new Establishment();

        City city = new City();
        city.addEstablishment(establishment);

        assertTrue(containsEstablishment(city, establishment));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullEstablishmentFailure(){
        city.addEstablishment(null);

        assertTrue(false);
    }

    @Test
    public void testDuplicateEstablishmentFailure(){
        Establishment establishment = new Establishment();
        city.addEstablishment(establishment);
        city.addEstablishment(establishment);

        assertEquals(city.getEstablishments().size(), 1);
    }

    @Test
    public void testRemoveEstablishmentSuccess(){
        Establishment establishment = new Establishment();
        city.addEstablishment(establishment);
        city.removeEstablishment(establishment);

        assertTrue(city.getEstablishments().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullEstablishmentFailure(){
        city.removeEstablishment(null);

        assertTrue(false);
    }

    private boolean containsEstablishment(City city, Establishment establishment) {
        return city.getEstablishments().contains(establishment);
    }

}
