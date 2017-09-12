package org.ostroukh.dionisus.app.service.transform.impl;

import org.ostroukh.dionisus.app.infra.util.Checks;
import org.ostroukh.dionisus.app.infra.util.ReflectionUtil;
import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.rest.dto.base.BaseDTO;
import org.ostroukh.dionisus.app.service.transform.Transformer;

import java.util.List;

/**
 * Default transformation engine that uses reflection to transform objects
 */
public class SimpleDTOTransformer implements Transformer {
    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clazz) {
        checkParams(entity, clazz);

        P dto = ReflectionUtil.createInstance(clazz);

        //copy all the similar fields
        List<String> fields = ReflectionUtil.findSimilarFields(entity.getClass(), clazz);
        ReflectionUtil.copyFields(entity, dto, fields);

        dto.transform(entity);

        return dto;
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(P dto, Class<T> clazz) {
        checkParams(dto, clazz);

        T entity = ReflectionUtil.createInstance(clazz);

        List<String> fields = ReflectionUtil.findSimilarFields(entity.getClass(), clazz);
        ReflectionUtil.copyFields(dto, entity, fields);
        dto.untransform(entity);

        return entity;

    }

    private void checkParams(Object param, Class<?> clazz){
        Checks.checkParameter(param != null, "Source transformation object is not initialized");
        Checks.checkParameter(clazz != null, "No class is defined for transformation");
    }
}
