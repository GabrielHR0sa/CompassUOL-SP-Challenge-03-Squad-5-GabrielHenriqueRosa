package br.com.compassuol.pb.challenge.msproducts.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.nio.channels.AcceptPendingException;
import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    @Test
    void handleResourceNotFoundException() {
        String message = "Product";
        String field = "Product";
        Long Id = 1L;

        try {
            throw new ResourceNotFoundException(message, field, Id);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            assertEquals(message, resourceNotFoundException.getResourceName());
            assertEquals(field, resourceNotFoundException.getResourceName());
            assertEquals(Id, resourceNotFoundException.getFieldValue());
        }
    }

    @Test
    void handleAccessDeniedException() {
        String message = "UNAUTHORIZED";

        try {
            throw new AccessDeniedException(message);
        } catch (AccessDeniedException accessDeniedException) {
            assertEquals(message, accessDeniedException.getMessage());
        }
    }

    @Test
    void handleApplicationException() {
        String message = "Not Found";

        try {
            throw new ApplicationException(HttpStatus.BAD_REQUEST, message);
        } catch (ApplicationException applicationException) {
            assertEquals(message, applicationException.getMessage());
            assertEquals(HttpStatus.BAD_REQUEST, applicationException.getStatus());
        }
    }
}