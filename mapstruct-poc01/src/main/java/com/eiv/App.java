package com.eiv;

import java.util.Optional;

import com.eiv.data.model.AddressEntity;
import com.eiv.data.repositories.AddressRepository;
import com.eiv.data.repositories.CurrencyRepository;
import com.eiv.data.repositories.PersonRepository;
import com.eiv.data.repositories.SucursalRepository;
import com.eiv.view.mapper.ContactMapper;
import com.eiv.view.mapper.CurrencyMapper;
import com.eiv.view.mapper.SucursalMapper;
import com.eiv.view.model.ContactModel;
import com.eiv.view.model.KeyValuePairModel;

public class App {
    public static final AppContext ctx;

    static {
        ctx = new AppContext();
    }

    public static void main(String[] args) {

        final PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        final AddressRepository addressRepository = ctx.getBean(AddressRepository.class);
        final CurrencyRepository currencyRepository = ctx.getBean(CurrencyRepository.class);
        final SucursalRepository sucursalRepository = ctx.getBean(SucursalRepository.class);

        final ContactMapper contactMapper = ContactMapper.INSTANCE;
        final CurrencyMapper currencyMapper = CurrencyMapper.INSTANCE;
        final SucursalMapper sucursalMapper = SucursalMapper.INSTANCE;

        personRepository.findAll().forEach(personEntity -> {

            Optional<AddressEntity> optional = addressRepository.findAll(personEntity).stream()
                    .filter(p -> p.getMainAddress()).findAny();

            if (optional.isEmpty()) {
                ContactModel contact = contactMapper.fromPersonaEntity(personEntity);
                System.out.println("contact: " + contact);
            } else {
                AddressEntity addressEntity = optional.get();
                ContactModel contact = contactMapper.fromAddressEntity(addressEntity);
                System.out.println("contact: " + contact);
            }
        });

        currencyRepository.findAll().forEach(currencyEntity -> {
            KeyValuePairModel currency = currencyMapper.toKeyValuePair(currencyEntity);
            System.out.println(String.format(
                    "Id: %s - Value: %s",
                    currency.getId(),
                    currency.getValue()));
        });

        sucursalRepository.findAll().forEach(sucursalEntity -> {
            KeyValuePairModel sucursal = sucursalMapper.toKeyValuePair(sucursalEntity);
            System.out.println(String.format("Id: %s - Value: %s",
                    sucursal.getId(),
                    sucursal.getValue()));
        });
    }
}
