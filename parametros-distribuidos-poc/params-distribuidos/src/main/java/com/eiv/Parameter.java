package com.eiv;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class Parameter<T> {

    private String name;
    
    private Class<T> type;
    
    private T value;
    
}
