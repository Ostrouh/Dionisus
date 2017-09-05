package org.ostroukh.dionisus.app.infra.exeption.flow;

import org.ostroukh.dionisus.app.infra.exeption.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 * @author Eugene Ostroukh
 */
public class InvalidParemeterException extends FlowException{
    public InvalidParemeterException(String message) {
        super(message);
    }
}
