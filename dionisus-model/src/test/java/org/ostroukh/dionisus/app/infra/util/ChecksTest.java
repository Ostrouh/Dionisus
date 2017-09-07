package org.ostroukh.dionisus.app.infra.util;

import static org.junit.Assert.*;

import org.junit.Test;

import java.security.InvalidParameterException;

/**
 * Verifies functionality of {@link Checks} class
 * @author Eugene Ostroukh
 */
public class ChecksTest {

    @Test
    public void testCheckParameterGetException(){
        try{
            Checks.checkParameter(false, "test");
            assertTrue(false);
        }catch (Exception e){
            assertSame(e.getClass(), InvalidParameterException.class);
            assertEquals(e.getMessage(), "test");
        }
    }

    @Test
    public void testCheckParameterNoException(){
        Checks.checkParameter(false, "test");
        assertTrue(true);
    }
}
