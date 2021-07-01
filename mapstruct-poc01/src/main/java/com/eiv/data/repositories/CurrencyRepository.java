package com.eiv.data.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eiv.data.model.CurrencyEntity;


public class CurrencyRepository implements DataRepository<CurrencyEntity, Long> {
    
    private Map<Long, CurrencyEntity> currencyMap = new HashMap<>();

    public CurrencyRepository(final Map<Long, String[]> CURRENCIES) {
                
        CURRENCIES.entrySet().forEach(entry -> {
            String[] fields = entry.getValue();

            Long id = Long.valueOf(fields[0]);
            String name = fields[1];
            String code = fields[2];
            String symbol = fields[3];
            
            CurrencyEntity currencyEntity = new CurrencyEntity(
                    id, name, code, symbol);
            
            currencyMap.put(id, currencyEntity);
        });
    }

    @Override
    public List<CurrencyEntity> findAll() {
        return currencyMap.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    public List<CurrencyEntity> findAll(CurrencyEntity personEntity) {
        return currencyMap.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CurrencyEntity> findById(Long id) {
        return Optional.ofNullable(currencyMap.get(id));
    }
}
