package com.bcgdv.exception;

import com.bcgdv.web.vo.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value
            = {CreateOrderHandler.class })
    protected ResponseEntity<Response<Object>> handleCreateOrderException(CreateOrderHandler exception) {
        return new ResponseEntity<>(new Response<>(false,500,null,exception.getMessage()), null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value
            = {OrderNotFoundHandler.class })
    protected ResponseEntity<Response<Object>> handleOrderNotFoundException(OrderNotFoundHandler exception) {
        return new ResponseEntity<>(new Response<>(false,404,new ArrayList<>(),exception.getMessage()), null, HttpStatus.NOT_FOUND);
    }

}
