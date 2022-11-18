package com.bcgdv.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private boolean success;
    private int status;
    private T price;
    private Exception exception;
    private String error;

    public Response(boolean success, int status, T price, String error) {
        this.success = success;
        this.status = status;
        this.price = price;
        this.error = error;
    }
}
