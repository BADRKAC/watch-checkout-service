package com.bcgdv.exception;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateOrderHandler extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CreateOrderHandler(String errorMessage, Throwable err) {
        super(errorMessage, err);
        log.error("Error while creating the Order : ",err);
    }
}