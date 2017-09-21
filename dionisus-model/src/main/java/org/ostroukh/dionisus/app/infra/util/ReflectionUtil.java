package org.ostroukh.dionisus.app.infra.util;

import org.ostroukh.dionisus.app.infra.exeption.ConfigurationException;
import org.ostroukh.dionisus.app.infra.util.annotation.Skip;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
     * Returns list of fields with identical names excluding static and final fields
     * @param clazz1
     * @param clazz2
     * @return
     * @throws ConfigurationException
     */
    public static List<String> findSimilarFields(Class<?> clazz1, Class<?> clazz2)
                                                    throws ConfigurationException{
        try{
            List<Field> fields = getFields(clazz1);

            List<String> targetFields = getFields(clazz2).stream()
                    .filter(field -> !field.isAnnotationPresent(Skip.class))
                    .map(field -> field.getName())
                    .collect(Collectors.toList());

            return fields.stream()
                    .filter(field -> !field.isAnnotationPresent(Skip.class))
                    .filter(field -> !Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers()))
                    .map(field -> field.getName())
                    .filter(name -> targetFields.contains(name))
                    .collect(Collectors.toList());

        }catch (SecurityException ex){
            throw new ConfigurationException(ex);
        }
    }

    /**
     * Returns all declared fields of the specified class and superclasses
     * @param clazz
     * @return
     */
    public static List<Field> getFields(Class<?> clazz){
        List<Field> fields = new ArrayList<>();
        while (clazz != null){
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    /**
     * Copy specified field value from source to destination object
     * @param src
     * @param dst
     * @param fields
     * @throws ConfigurationException
     */
    public static void copyFields(Object src, Object dst, List<String> fields)
                                                throws ConfigurationException{
        Checks.checkParameter(src != null, "Source object is not initialized");
        Checks.checkParameter(dst != null, "Destination object is not initialized");

        try{
            for (String fld: fields) {
                Field field = getField(src.getClass(), fld);
                //Skip unknown fields
                if(field != null){
                    field.setAccessible(true);
                    Object value = field.get(src);

                    Field fieldDest = getField(dst.getClass(), fld);
                    if (fieldDest != null){
                        fieldDest.setAccessible(true);
                        fieldDest.set(dst, value);
                    }
                }
            }
        }catch (SecurityException | ReflectiveOperationException | IllegalArgumentException e){
            throw new ConfigurationException(e);
        }
    }

    /**
     * Returns field by its name from class and superclasses
     * @param clazz
     * @param name
     * @param <T>
     * @return
     */
    public static <T> Field getField(final Class<T> clazz, String name){
        Class<?> current = clazz;
        while (current != null){
            try{
                return current.getDeclaredField(name);
            } catch (NoSuchFieldException | SecurityException e) {
                current = current.getSuperclass();
            }
        }
        throw new ConfigurationException("No field " + name + " in the class " + clazz);
    }
}
