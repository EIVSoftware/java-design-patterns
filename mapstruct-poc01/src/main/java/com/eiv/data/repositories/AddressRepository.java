package com.eiv.data.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eiv.data.model.AddressEntity;
import com.eiv.data.model.PersonEntity;

public class AddressRepository implements DataRepository<AddressEntity, Long> {
    
    private Map<Long, AddressEntity> addressMap = new HashMap<>();

    public AddressRepository(
            final PersonRepository personRepository, final Map<Long, String[]> ADDRESSES) {
                
        ADDRESSES.entrySet().forEach(entry -> {
            String[] fields = entry.getValue();

            Long id = Long.valueOf(fields[0]);
            Long personId = Long.valueOf(fields[1]);
            String street = fields[2];
            String number = fields[3];
            Boolean mainAddress = fields[4].equals("1");
            
            PersonEntity person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException(
                    "Person with ID {} does not exists!"));

            AddressEntity addressEntity = new AddressEntity(
                id, person, street, number, mainAddress);
            
            addressMap.put(id, addressEntity);
        });
    }

    @Override
    public List<AddressEntity> findAll() {
        return addressMap.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    public List<AddressEntity> findAll(PersonEntity personEntity) {
        return addressMap.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(p -> p.getPerson().equals(personEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AddressEntity> findById(Long id) {
        return Optional.ofNullable(addressMap.get(id));
    }
}
