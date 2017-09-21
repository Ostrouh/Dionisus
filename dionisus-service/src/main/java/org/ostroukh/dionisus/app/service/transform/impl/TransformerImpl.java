package org.ostroukh.dionisus.app.service.transform.impl;

import org.ostroukh.dionisus.app.infra.util.Checks;
import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.infra.util.ReflectionUtil;
import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.rest.dto.base.BaseDTO;
import org.ostroukh.dionisus.app.service.transform.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Default transformation engine that uses reflection to transform objects
 */
public class TransformerImpl implements Transformer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformerImpl.class);

    private final FieldCache cache;

    public TransformerImpl() {
        cache = new FieldCache();
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clazz) {
        checkParams(entity, clazz);

        P dto = ReflectionUtil.createInstance(clazz);

        //copy all the similar fields
        ReflectionUtil.copyFields(entity, dto, cache.getFieldNames(entity.getClass(), clazz));

        dto.transform(entity);

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("TransformerImpl.transform: {} DTO object", CommonUtil.toString(dto));
        }

        return dto;
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(P dto, Class<T> clazz) {
        checkParams(dto, clazz);

        T entity = ReflectionUtil.createInstance(clazz);

       ReflectionUtil.copyFields(dto, entity, cache.getFieldNames(dto.getClass(), clazz));
        dto.untransform(entity);

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("SimpledTOTransformer.transform: {} entity",CommonUtil.toString(dto));
        }

        return entity;
    }

    private void checkParams(Object obj, Class<?> clazz){
        Checks.checkParameter(obj != null, "Source transformation object is not initialized");
        Checks.checkParameter(clazz != null, "No class is defined for transformation");
    }
}
