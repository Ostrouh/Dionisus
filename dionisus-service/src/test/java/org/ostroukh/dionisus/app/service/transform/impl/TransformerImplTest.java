package org.ostroukh.dionisus.app.service.transform.impl;

import org.junit.Before;
import org.junit.Test;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.rest.dto.CityDTO;
import org.ostroukh.dionisus.app.service.transform.Transformer;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link TransformerImpl}
 * unit
 */
public class TransformerImplTest {
    private Transformer transformer;

    @Before
    public void setup(){
        transformer = new TransformerImpl();
    }

    @Test
    public void testCityTransformSuccess(){
        City city = new City("Grodno");
        city.setId(1);
        city.setRegion("Gr");
        city.setDistrict("None");

        CityDTO dto = transformer.transform(city, CityDTO.class);

        assertNotNull(dto);
        assertEquals(city.getId(), dto.getId());
        assertEquals(city.getName(), dto.getName());
        assertEquals(city.getRegion(), dto.getRegion());
        assertEquals(city.getDistrict(), dto.getDistrict());
    }

    @Test(expected = InvalidParameterException.class)
    public void testNullCityTransformFailure(){
        transformer.transform(null, CityDTO.class);
    }

    @Test(expected = InvalidParameterException.class)
    public void testNullDTOClassTransformFailure(){
        transformer.transform(new City("Grodno"), null);
    }

    @Test
    public void testCityUntransformSuccess(){
        CityDTO dto = new CityDTO();
        dto.setId(1);
        dto.setName("Grodno");
        dto.setDistrict("None");
        dto.setRegion("Gr");

        City city = transformer.untransform(dto, City.class);

        assertNotNull(city);
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getRegion(), city.getRegion());
        assertEquals(dto.getId(), city.getId());
    }

    @Test(expected = InvalidParameterException.class)
    public void testNullCityDtoUntransformFailure(){
        transformer.untransform(null, City.class);
    }

    @Test(expected = InvalidParameterException.class)
    public void testNullEntityClassUntransformFailure(){
        transformer.untransform(new CityDTO(), null);
    }
}
