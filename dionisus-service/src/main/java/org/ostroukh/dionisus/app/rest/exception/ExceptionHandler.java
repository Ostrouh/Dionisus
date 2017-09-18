package org.ostroukh.dionisus.app.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Jersey handler that catches any Exception-based errors
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    private final Response SERVER_ERROR;

    public ExceptionHandler() {
        SERVER_ERROR = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public Response toResponse(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return SERVER_ERROR;
    }
}
