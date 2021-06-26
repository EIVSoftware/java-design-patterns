package com.eiv.data.repositories;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> {
    
    public List<T> findAll();

    public Optional<T> findById(ID id);

}
