package org.ostroukh.dionisus.app.rest.service;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.ostroukh.dionisus.app.rest.service.config.JerseyConfig;
import static org.junit.Assert.*;

import javax.ws.rs.core.Application;
import java.util.List;

/**
 * {@link EstablishmentResourseTest} is integration test that verifies
 * {@link EstablishmentResource}
 * @author Eugene Ostroukh
 */
public class EstablishmentResourseTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    public void testFindEstablishmentsSuccess(){
        List<?> establishments = target("establishments").request().get(List.class);

        assertNotNull(establishments);
        assertTrue(establishments.contains("Paluba"));
        assertTrue(establishments.contains("Hudini"));
    }
}
