package org.ostroukh.dionisus.app.model.entity.geography;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;

/**
 * Contains unit-tests to check functionality of {@link City} class
 * @author Eugene Ostroukh
 */
public class CityTest {
    private City city;

    @Before
    public void setup(){
        city = new City("Grodno");
    }

    @Test
    public void testAddValidEstablishmentSuccess() {
        Establishment establishment = city.addEstablishment("Aurora", EstablishmentType.BAR);

        assertTrue(containsEstablishment(city, establishment));
        assertEquals(city, establishment.getCity());
    }

    @Test(expected = NullPointerException.class)
    public void testAddEstablNullEstablishmentTypeFailure(){
        city.addEstablishment("Aurora",null);

        assertTrue(false);
    }

    @Test
    public void testRemoveEstablishmentSuccess(){
        Establishment establishment = city.addEstablishment("BAZA",EstablishmentType.CLUB);

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
