package org.ostroukh.dionisus.app.rest.dto.base;

import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;

/**
 * Base class for all DTO classes.
 * @author Eugene Ostroukh
 */
public class BaseDTO<T extends AbstractEntity> {
    /**
     * Unique entity id
     */
    private int id;

    /**
     * Should be overridden in the derived classes if additional transformation
     * domain model -> DTO is needed.
     * Overridden methods should call super.transform()
     * @param t
     */
    public void transform(T t){
        id = t.getId();
    }

    /**
     * Should be overridden in the derived classes if additional transformation
     * logic DTO -> domain model is needed
     * @param t
     * @return
     */
    public T untransform(T t){
        t.setId(getId());
        return t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
