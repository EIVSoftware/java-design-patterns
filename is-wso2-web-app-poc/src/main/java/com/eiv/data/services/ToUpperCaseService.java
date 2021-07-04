package com.eiv.data.services;

import com.eiv.data.model.ResponseModel;

/**
 * 
 * @author Diego Cairone (diegocairone@gmail.com)
 * @see https://spring.io/blog/2018/03/06/using-spring-security-5-to-integrate-with-oauth-2-secured-services-such-as-facebook-and-github
 *
 */
public class ToUpperCaseService extends ApiBinding {

    public ToUpperCaseService(String accessToken) {
        super(accessToken);
    }
    
    public String toUpperCase(String value) {
        ResponseModel response = restTemplate.getForObject(
                String.format("http://localhost:5000/api/touppercase?msg=%s", value), 
                ResponseModel.class);
        return response.getMessage();
    }
}
