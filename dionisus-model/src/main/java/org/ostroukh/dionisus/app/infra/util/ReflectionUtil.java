package org.ostroukh.dionisus.app.infra.util;

import org.ostroukh.dionisus.app.infra.exeption.ConfigurationException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains reflection-related utility operations
 */
public class ReflectionUtil {
    private ReflectionUtil(){
    }

    /**
     * Creates an instance of the specified class.
     * This method throws unchecked exception if creation fails
     * @param clazz
     * @param <T>
     * @return
     * @throws ConfigurationException
     */
    public static <T> T createInstance(Class<T> clazz)throws ConfigurationException {
        try{
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex){
            throw new ConfigurationException(ex);
        }
    }

    /**
     * Returns list of fields with identical names irregardles of their
     * modifiers
     * @param clazz1
     * @param clazz2
     * @return
     * @throws ConfigurationException
     */
    public static List<String> findSimilarFields(Class<?> clazz1, Class<?> clazz2)
                                                    throws ConfigurationException{
        try{
            Field[] fields = clazz1.getDeclaredFields();
            List<String> targetFields = Stream.of(clazz2.getDeclaredFields())
                    .map(field -> field.getName())
                    .collect(Collectors.toList());

            return Stream.of(fields)
                    .map(field -> field.getName())
                    .filter(name -> targetFields.contains(name))
                    .collect(Collectors.toList());
        }catch (SecurityException ex){
            throw new ConfigurationException(ex);
        }
    }

    public static void copyFields(Object src, Object dst, List<String> fields)
                                                throws ConfigurationException{
        Checks.checkParameter(src != null, "Source object is not initialized");
        Checks.checkParameter(dst != null, "Destination object is not initialized");

        try{
            for (String fld: fields) {
                Field field = src.getClass().getDeclaredField(fld);
                //Skip unknown fields
                if(field != null){
                    field.setAccessible(true);
                    Object value = field.get(src);

                    Field fieldDest = dst.getClass().getDeclaredField(fld);
                    if (fieldDest != null){
                        fieldDest.setAccessible(true);
                        fieldDest.set(dst, value);
                    }
                }
            }
        }catch (SecurityException | ReflectiveOperationException | IllegalArgumentException ex){
            throw new ConfigurationException(ex);
        }
    }
}
