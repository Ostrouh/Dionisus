package org.ostroukh.dionisus.app.infra.exeption;

import org.ostroukh.dionisus.app.infra.exeption.base.AppException;

/**
 * Signals about data access layer unexpected situations
 * @author Eugene Ostroukh
 */
public class PersistenceException extends AppException{
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(String message) {
        super(message);
    }
}
