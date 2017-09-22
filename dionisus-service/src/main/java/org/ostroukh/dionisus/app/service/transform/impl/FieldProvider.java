package org.ostroukh.dionisus.app.service.transform.impl;

import org.ostroukh.dionisus.app.infra.util.ReflectionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class caches field names for each transformation pair
 */
public class FieldProvider {
    /**
     * Mapping between transformation pair(class names) and field list.
     * Key is concatenate names of classes, value is list of fields
     */
    private final Map<String, List<String>> cache;

    public FieldProvider() {
        this.cache = new HashMap<>();
    }

    /**
     * Returns list of similar field names for source/destination classes
     * @param src
     * @param dst
     * @return
     */
    public List<String> getFieldNames(Class<?> src, Class<?> dst){
        String key = src.getSimpleName() + dst.getSimpleName();
        List<String> fields = cache.get(key);

        if(fields == null){
            fields = ReflectionUtil.findSimilarFields(src, dst);
            cache.put(key, fields);
        }
        return fields;
    }
}
