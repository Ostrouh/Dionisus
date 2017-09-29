package org.ostroukh.dionisus.app.model.entity.person;

import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity that encapsulates user of the application
 * @author Eugene Ostroukh
 */
@Table(name = "ACCOUNT")
@Entity
public class Account extends AbstractEntity {
    @Column(name = "IS_ADMIN", length = 1)
    private boolean isAdmin;

}
