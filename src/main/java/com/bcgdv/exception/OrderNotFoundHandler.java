package com.bcgdv.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderNotFoundHandler extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public OrderNotFoundHandler(String errorMessage, Throwable err) {
        super(errorMessage, err);
        log.error("Order not found : ",err);
    }
}