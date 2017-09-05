package org.ostroukh.dionisus.app.infra.exeption;

import org.ostroukh.dionisus.app.infra.exeption.base.AppException;

/**
 * Signals about exceptional cases in the application logic
 * @author Eugene Ostroukh
 */
public class FlowException extends AppException{
    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlowException(String message) {
        super(message);
    }
}
