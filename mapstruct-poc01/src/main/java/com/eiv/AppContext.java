package com.eiv;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eiv.data.repositories.AddressRepository;
import com.eiv.data.repositories.CurrencyRepository;
import com.eiv.data.repositories.PersonRepository;
import com.eiv.data.repositories.SucursalRepository;
import com.opencsv.CSVReader;

public class AppContext {
    
    private final Map<Long, String[]> PERSONS = new HashMap<>();
    private final Map<Long, String[]> ADDRESSES = new HashMap<>();
    private final Map<Long, String[]> CURRENCIES = new HashMap<>();
    private final Map<Long, String[]> SUCURSALES = new HashMap<>();

    private final Map<Class<?>, Object> container = new HashMap<>();

    public AppContext() {
        initRepository(PERSONS, "persons.csv");
        initRepository(ADDRESSES, "addresses.csv");
        initRepository(CURRENCIES, "currencies.csv");
        initRepository(SUCURSALES, "sucursales.csv");

        PersonRepository personRepository = new PersonRepository(
                PERSONS);
        container.put(PersonRepository.class, personRepository);
        
        CurrencyRepository currencyRepository = new CurrencyRepository(
                CURRENCIES);
        container.put(CurrencyRepository.class, currencyRepository);
        
        SucursalRepository sucursalRepository = new SucursalRepository(
                SUCURSALES);
        container.put(SucursalRepository.class, sucursalRepository);


        AddressRepository addressRepository = new AddressRepository(
                personRepository, ADDRESSES);
        container.put(AddressRepository.class, addressRepository);
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> type) {
        return (T) container.get(type);
    }
    
    private void initRepository(Map<Long, String[]> map, String fileName) {

        List<String[]> sucursales = new ArrayList<>();
        Reader reader = readCsv(fileName);
        CSVReader csvReader = new CSVReader(reader);
        String[] line;

        try {
            while ((line = csvReader.readNext()) != null) {
                sucursales.add(line);
            }
            reader.close();
            csvReader.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        sucursales.forEach(fields -> {
            Long id = Long.valueOf(fields[0]);
            map.put(id, fields);
        });
    }

    private Reader readCsv(String fileName) {
        try {
            Reader reader = Files.newBufferedReader(
                    Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
            return reader;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
