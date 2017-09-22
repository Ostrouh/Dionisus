package org.ostroukh.dionisus.app.service.transform.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostroukh.dionisus.app.infra.util.ReflectionUtil;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import sun.security.krb5.internal.crypto.Des;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Verifies functionality of the {@link FieldProvider} unit
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ReflectionUtil.class)
public class FieldProviderTest {

    private FieldProvider provider;

    @Before
    public void setup(){
        provider = new FieldProvider();
    }

    @Test
    public void GetFieldNamesSuccess(){
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertTrue(fields.contains("value"));
    }

    @Test
    public void GetFieldNamesCachedSuccess(){
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);
        List<String> fieldsFromCache = provider.getFieldNames(Source.class, Destination.class);

        assertFalse(fields.isEmpty());
        assertEquals(fields, fieldsFromCache);
    }

    @Test
    public void GetFieldNamesAreCached(){
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);

        PowerMockito.mockStatic(ReflectionUtil.class);
        when(ReflectionUtil.findSimilarFields(Source.class, Destination.class))
                .thenReturn(Collections.emptyList());

        assertTrue(ReflectionUtil.findSimilarFields(Source.class, Destination.class).isEmpty());
        List<String> fieldsFromCache = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertEquals(fields, fieldsFromCache);
    }

}

class Source{
    int value;
}

class Destination{
    int value;
}
