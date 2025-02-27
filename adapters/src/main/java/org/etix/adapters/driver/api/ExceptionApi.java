package org.etix.adapters.driver.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.ConstraintViolationException;
import org.etix.domain.exceptions.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ExceptionApi {


    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseApi> alreadyExist(EntityAlreadyExistsException error) {
        return new ResponseEntity<>(new ErrorResponseApi(error.getMessage(), error.getStatus()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ApplicationAuthenticationException.class)
    public ResponseEntity<ErrorResponseApi> authentification(ApplicationAuthenticationException error) {
        return new ResponseEntity<>(new ErrorResponseApi(error.getMessage(), error.getStatus()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ExpressionEvaluationException.class)
    public ResponseEntity<ErrorResponseApi> validation(ExpressionEvaluationException error) {
        return new ResponseEntity<>(new ErrorResponseApi(error.getMessage(), error.getStatus()), HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseApi> badCredential(BadRequestException error) {
        return new ResponseEntity<>(new ErrorResponseApi(error.getMessage(), error.getStatus()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseApi> global(Exception error) {
        return new ResponseEntity<>(new ErrorResponseApi("Une erreur est survenue", 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotExistsException.class)
    public ResponseEntity<ResponseApi> notFound(EntityNotExistsException error) {
        ResponseApi responseApi = new ResponseApi(error.getMessage(), error.getStatus(), null);
        return new ResponseEntity<>(responseApi, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(MethodArgumentNotValidException ex) {
        // Récupérer les messages d'erreur.
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));


        System.out.println("+++++++++++++++++++++++" + errors + "+++++++++++++++++++++++++");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(DataIntegrityViolationException ex) {
        // Récupérer les messages d'erreur.
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        System.out.println("+++++++++++++++++++++++" + errors + "+++++++++++++++++++++++++");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseApi> handleConstraintViolation(ConstraintViolationException ex) {
        // Récupérer les messages d'erreur.
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        ResponseApi responseApi = new ResponseApi(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), null);
        System.out.println("+++++++++++++++++++++++ handleConstraintViolation" + errors + "+++++++++++++++++++++++++");
        return new ResponseEntity<>(responseApi, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ResponseApi> notFound(HttpClientErrorException error) throws JsonProcessingException {
        String message = error.getResponseBodyAsString();
//        Map<String, Object> objectMap = parse(message);
        error.printStackTrace();
        return new ResponseEntity<>(new ResponseApi(error.getMessage(), error.getStatusCode().value(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ResponseApi> resourceAccess(ResourceAccessException exception) {
        exception.printStackTrace();
        System.out.println("une erreur est survenue *************************");
        return new ResponseEntity<>(new ResponseApi("Une erreur est survenue", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ResponseApi> serverError(HttpServerErrorException exception) {
        exception.printStackTrace();
        System.out.println("une erreur est survenue *************************");
        return new ResponseEntity<>(new ResponseApi("Une erreur est survenue", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ResponseApi> serverError(RestClientException exception) {
        exception.printStackTrace();
        System.out.println("une erreur est survenue *************************");
        return new ResponseEntity<>(new ResponseApi(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), null), HttpStatus.NOT_FOUND);
    }

}
