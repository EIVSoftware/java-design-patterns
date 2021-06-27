package com.eiv;

import java.util.Optional;

import com.eiv.data.model.AddressEntity;
import com.eiv.data.repositories.AddressRepository;
import com.eiv.data.repositories.PersonRepository;
import com.eiv.view.mapper.ContactMapper;
import com.eiv.view.model.ContactModel;

public class App 
{
    public static final AppContext ctx;

    static {
        ctx = new AppContext();
    }

    public static void main( String[] args ) {

        final PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        final AddressRepository addressRepository = ctx.getBean(AddressRepository.class);

        final ContactMapper contactMapper = ContactMapper.INSTANCE;

        personRepository.findAll().forEach(personEntity -> {

            Optional<AddressEntity> optional = addressRepository.findAll(personEntity)
                .stream()
                .filter(p -> p.getMainAddress())
                .findAny();

            if (optional.isEmpty()) {
                ContactModel contact = contactMapper.fromPersonaEntity(personEntity);
                System.out.println( "contact: " + contact );
            } else {
                AddressEntity addressEntity = optional.get();
                ContactModel contact = contactMapper.fromAddressEntity(addressEntity);
                System.out.println( "contact: " + contact );
            }
        });
        
    }
}
