package org.ostroukh.dionisus.app.service.transform;

import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.rest.dto.base.BaseDTO;

/**
 * Represents transformation engine to convert business entities
 * into DTO objects
 */
public interface Transformer {

    /**
     * Converts specified entity into DTO object
     * @param entity
     * @param clazz
     * @param <T>
     * @param <P>
     * @return
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clazz);

    /**
     * Converts specified DTO object into business entity
     * @param dto
     * @param clazz
     * @param <T>
     * @param <P>
     * @return
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(P dto, Class<T> clazz);
}
