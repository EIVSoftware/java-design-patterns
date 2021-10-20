package com.eiv;

public interface ParameterContainer {

    <T> Parameter<T> getByName(String name);

    <T> ParameterContainerImpl addParameter(String name, Class<T> clazz, T value);
    
}