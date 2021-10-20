package com.eiv;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Parameter<T> {

    private final String name;
    
    private final Class<T> type;
    
    private final T value;
    
}
