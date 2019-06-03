package app.api.config.controller.advice;

import app.api.config.exeception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@ControllerAdvice
public class ErrorHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String ERROR = "error: ";

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> illegalArgumentException(IllegalArgumentException iae) {
        logger.error(ERROR, iae);
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException iae) {
        logger.error(ERROR, iae);
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionResponse> indexOutOfBoundsException(IndexOutOfBoundsException iae) {
        logger.error(ERROR, iae);
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResponse> nullPointerException(NullPointerException iae) {
        logger.error(ERROR, iae);
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException iae) {
        logger.error(ERROR, iae);
        ExceptionResponse er = new ExceptionResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> indexOutOfBoundsException(Exception iae) {
        logger.error(ERROR, iae);
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundException(Exception iae) {
        logger.error(ERROR, iae);
        ExceptionResponse er = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ExceptionResponse> httpMessageConversionException(HttpMessageConversionException e) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> httpRequestMethodNotSupportedException(HttpMessageConversionException e) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ExceptionResponse> numberFormatException(HttpMessageConversionException e) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}
