package com.eiv.data.repositories;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eiv.data.model.GenderEnum;
import com.eiv.data.model.PersonEntity;

public class PersonRepository implements DataRepository<PersonEntity, Long> {

    private Map<Long, PersonEntity> personMap = new HashMap<>();
    
    public PersonRepository(Map<Long, String[]> PERSONS) {

        PERSONS.entrySet().forEach(entry -> {
            String[] fields = entry.getValue();

            Long id = Long.valueOf(fields[0]);
            String names = fields[1];
            LocalDate birthDate = LocalDate.parse(fields[2]);
            GenderEnum gender = GenderEnum.valueOf(fields[3]);

            PersonEntity personEntity = new PersonEntity(id, names, birthDate, gender);
            personMap.put(id, personEntity);
        });
    }

    @Override
    public List<PersonEntity> findAll() {
        return personMap.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonEntity> findById(Long id) {
        return Optional.ofNullable(personMap.get(id));
    }
    
}
