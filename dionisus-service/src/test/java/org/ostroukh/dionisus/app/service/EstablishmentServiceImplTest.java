package org.ostroukh.dionisus.app.service;

import org.junit.Before;
import org.junit.Test;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.service.impl.EstablishmentServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Contain unit-tests for {@link EstablishmentServiceImpl}
 * @author Eugene Ostroukh
 */
public class EstablishmentServiceImplTest {
    private final static int DEFAULT_ESTABL_ID = 1;
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

    @Test
    public void testFindEstablByIdSuccess(){
        Establishment establishment = new Establishment("BAZA", new City("Grodno"), EstablishmentType.CLUB);
        service.saveEstablishment(establishment);

        Optional<Establishment> foundEstabls = service.findEstablById(DEFAULT_ESTABL_ID);

        assertTrue(foundEstabls.isPresent());
        assertEquals(foundEstabls.get().getId(), DEFAULT_ESTABL_ID);
    }

    @Test
    public void testFindEstablByIdNotFound(){
        Optional<Establishment> foundEstabls = service.findEstablById(DEFAULT_ESTABL_ID);

        assertFalse(foundEstabls.isPresent());
    }
}
