package org.ostroukh.dionisus.app.infra.exeption;

import org.ostroukh.dionisus.app.infra.exeption.base.AppException;

/**
 * Signals about exception cases in the work of external services and API
 * @author Eugene Ostroukh
 */
public class CommunicationException extends AppException {

    public CommunicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunicationException(String message) {
        super(message);
    }
}
