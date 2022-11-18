package com.bcgdv.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("com.bcgdv")
public class Parameters {
    private Double rolexPrice;
    private Double michaelkorsPrice;
    private Double swatchPrice;
    private Double casioPrice;
    private String rolexID;
    private String michaelkorsID;
    private String swatchID;
    private String casioID;
    private int rolexDiscountPrice;
    private int michaelkorsDiscountPrice;
    private int rolexDiscountQuantity;
    private int michaelkorsDiscountQuantity;


}
