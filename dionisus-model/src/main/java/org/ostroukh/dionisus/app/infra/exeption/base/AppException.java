package org.ostroukh.dionisus.app.infra.exeption.base;

/**
 * Base class for all application exceptions
 * @author Eugene Ostroukh
 */
public class AppException extends RuntimeException{

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
