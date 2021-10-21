package com.eiv;

import java.util.HashMap;
import java.util.Map;

public class ParameterContainerImpl implements ParameterContainer {

    private Map<String, Parameter<?>> map;
    
    public ParameterContainerImpl() {
        this.map = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Parameter<?> getByName(String name) {
        return map == null ? null : map.get(name);
    }
    
    @Override
    public <T> ParameterContainerImpl addParameter(String name, Class<T> clazz, T value) {
        Parameter<T> param = new Parameter<T>(name, clazz, value);
        return addParameter(param);
    }

    public ParameterContainerImpl addParameter(Parameter<?> param) {
        this.map.put(param.getName(), param);
        return this;
    }
    
}
