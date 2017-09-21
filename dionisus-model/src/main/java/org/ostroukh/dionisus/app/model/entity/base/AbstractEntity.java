package org.ostroukh.dionisus.app.model.entity.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.ostroukh.dionisus.app.model.entity.person.Account;

import java.time.LocalDateTime;

/**
 * Base class for all business entities
 * @author Eugene Ostroukh
 */
public abstract class AbstractEntity {
    /**
     * Unique entity identifier
     */
    private int id;

    /**
     * Timestamp of entity creation
     */
    private LocalDateTime createdAt;

    /**
     * Timestamp of entity last modification
     */
    private LocalDateTime modifiedAt;

    /**
     * Person who created specific entity
     */
    private Account createdBy;

    /**
     * Last person who modified entity
     */
    private Account modifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Account getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Account createdBy) {
        this.createdBy = createdBy;
    }

    public Account getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Account modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public int hashCode() {
//        return HashCodeBuilder.reflectionHashCode(17, 37,this);

        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(createdAt)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
