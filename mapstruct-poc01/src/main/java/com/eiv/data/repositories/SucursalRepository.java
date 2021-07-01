package com.eiv.data.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eiv.data.model.CurrencyEntity;
import com.eiv.data.model.SucursalEntity;

public class SucursalRepository implements DataRepository<SucursalEntity, Long> {

    private Map<Long, SucursalEntity> sucursalMap = new HashMap<>();

    public SucursalRepository(final Map<Long, String[]> SUCURSALES) {

        SUCURSALES.entrySet().forEach(entry -> {
            String[] fields = entry.getValue();

            Long id = Long.valueOf(fields[0]);
            String name = fields[1];
            String abbreviation = fields[2];

            SucursalEntity sucursalEntity = new SucursalEntity(
                    id,
                    name,
                    abbreviation);

            sucursalMap.put(id, sucursalEntity);
        });
    }

    @Override
    public List<SucursalEntity> findAll() {
        return sucursalMap.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    public List<SucursalEntity> findAll(CurrencyEntity personEntity) {
        return sucursalMap.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SucursalEntity> findById(Long id) {
        return Optional.ofNullable(sucursalMap.get(id));
    }
}
