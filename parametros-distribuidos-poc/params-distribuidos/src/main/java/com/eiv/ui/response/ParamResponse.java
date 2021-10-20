package com.eiv.ui.response;

import com.eiv.Parameter;

import lombok.Value;

@Value
public class ParamResponse {

    private String name;
    private Object value;
    
    public ParamResponse(Parameter<?> param) {
        this.name = param.getName();
        this.value = param.getValue();
    }
}
