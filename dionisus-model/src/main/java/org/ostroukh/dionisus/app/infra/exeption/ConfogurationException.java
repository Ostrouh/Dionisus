package org.ostroukh.dionisus.app.infra.exeption;

import org.ostroukh.dionisus.app.infra.exeption.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 * @author Eugene Ostroukh
 */
public class ConfogurationException extends AppException{
    public ConfogurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfogurationException(String message) {
        super(message);
    }
}
