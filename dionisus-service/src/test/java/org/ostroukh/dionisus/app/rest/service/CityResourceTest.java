package org.ostroukh.dionisus.app.rest.service;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.ostroukh.dionisus.app.rest.service.config.JerseyConfig;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;
import java.util.List;

/**
 * {@link CityResourceTest} is integration test that verifies
 * {@link CityResource}
 * @author Eugene Ostroukh
 */
public class CityResourceTest extends JerseyTest{

    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    public void testFindCitiesSuccess(){
        List<?> cities = target("cities").request().get(List.class);
        assertNotNull(cities);
        assertTrue(cities.contains("Grodno"));
        assertTrue(cities.contains("Minsk"));
    }
}
