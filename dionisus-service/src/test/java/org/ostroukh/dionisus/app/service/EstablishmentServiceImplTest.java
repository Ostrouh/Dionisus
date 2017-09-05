package org.ostroukh.dionisus.app.service;

import org.junit.Before;
import org.junit.Test;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.service.impl.EstablishmentServiceImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contain unit-tests for {@link EstablishmentServiceImpl}
 * @author Eugene Ostroukh
 */
public class EstablishmentServiceImplTest {
    private EstablishmentService service;

    @Before
    public void setup(){
        service = new EstablishmentServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart(){
        List<Establishment> establishments = service.findEstablishments();
        assertTrue(establishments.isEmpty());
    }

    @Test
    public void testSaveNewEstablishmentSuccess(){
        Establishment establishment = new Establishment("Aurora", new City("Grodno"), EstablishmentType.CAFE);

        service.saveEstablishment(establishment);
        List<Establishment> establishments = service.findEstablishments();

        assertEquals(establishments.size(),1);
        assertEquals(establishments.get(0).getName(), "Aurora");
        assertEquals(establishments.get(0).getCity().getName(), "Grodno");
    }
}
