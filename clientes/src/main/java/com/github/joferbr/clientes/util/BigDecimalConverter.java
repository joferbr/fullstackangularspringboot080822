package com.github.joferbr.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    private String value;

    //Converter 1.000,00 para 1000,00
    public BigDecimal converter(String value) {
        this.value = value;
        if(value == null) {
            return null;
        }
        value = value.replace(".", "").replace(",", ".");
        return new BigDecimal(value);
    }
}
