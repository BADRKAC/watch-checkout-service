package com.bcgdv.exception;

import com.bcgdv.web.vo.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value
            = {CreateOrderHandler.class })
    protected ResponseEntity<Response<Object>> handleCreateOrderException(CreateOrderHandler exception) {
        return new ResponseEntity<>(new Response<>(false,500,null,exception.getMessage()), null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
