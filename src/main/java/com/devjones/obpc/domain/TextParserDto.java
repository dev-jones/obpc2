package com.devjones.obpc.domain;

import jakarta.validation.constraints.NotNull;

public class TextParserDto {
    @NotNull
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
