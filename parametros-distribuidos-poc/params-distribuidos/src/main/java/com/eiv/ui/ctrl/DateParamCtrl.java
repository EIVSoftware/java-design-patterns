package com.eiv.ui.ctrl;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.ParameterContainer;
import com.eiv.redis.RedisProducer;
import com.eiv.ui.payload.UpdateDateRequest;
import com.eiv.ui.response.ParamResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/date")
@RequiredArgsConstructor
public class DateParamCtrl {

    private static final String PARAM_NAME = "param-date";
    
    private final ParameterContainer container;
    private final RedisProducer redisProducer;
    
    @GetMapping
    public ParamResponse getParamValue() {
        return new ParamResponse( container.getByName(PARAM_NAME) );
    }
    
    @PutMapping
    public ParamResponse setParamValue(
            @RequestBody UpdateDateRequest request) {
        container.addParameter(PARAM_NAME, LocalDate.class, request.getDate().plusDays(5l));
        redisProducer.send(container.getByName(PARAM_NAME));
        return new ParamResponse(container.getByName(PARAM_NAME));
    }
    
}
