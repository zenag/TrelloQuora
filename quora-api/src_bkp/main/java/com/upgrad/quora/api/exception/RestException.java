package com.upgrad.quora.api.exception;

import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.SignUpRestrictedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestException extends Exception {
   @ExceptionHandler(SignUpRestrictedException.class)
   public ResponseEntity<ErrorResponse> userExists(SignUpRestrictedException signupexception, WebRequest request){
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(signupexception.getCode()).message(signupexception.getMessage()), HttpStatus.CONFLICT);
   }
}
