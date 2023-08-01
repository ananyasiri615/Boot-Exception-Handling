package com.ars.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ars.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ProductExceptionController {
   @ExceptionHandler(value = ProductNotFoundException.class)
   public ResponseEntity<Object> exception(ProductNotFoundException exception) {
      return new ResponseEntity<>("Product is not found", HttpStatus.NOT_FOUND);
   }
}
