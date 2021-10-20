package com.eiv.ui.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.Parameter;
import com.eiv.ParameterContainer;
import com.eiv.redis.RedisProducer;
import com.eiv.ui.response.ParamResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boolean")
@RequiredArgsConstructor
public class BoolParamCtrl {

    private static final String PARAM_NAME = "param-bool";
    
    private final ParameterContainer container;
    private final RedisProducer redisProducer;
    
    @GetMapping
    public ParamResponse getParamValue() {
        redisProducer.send("Se lee mensaje");
        return new ParamResponse( container.getByName(PARAM_NAME) );
    }
    
    @PutMapping
    public ParamResponse setParamValue() {
        Parameter<Boolean> current = container.getByName(PARAM_NAME);
        container.addParameter(PARAM_NAME, Boolean.class, !current.getValue());
        return new ParamResponse(container.getByName(PARAM_NAME));
    }
    
}
