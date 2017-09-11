package org.ostroukh.dionisus.app.infra.exeption;

import org.ostroukh.dionisus.app.infra.exeption.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 * @author Eugene Ostroukh
 */
public class ConfigurationException extends AppException{
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(Throwable cause) {
        super(cause);
    }
}
