package com.eiv;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class AppContext {
    
    public final Map<Long, String[]> PERSONS = new HashMap<>();

    public final Map<Long, String[]> ADDRESSES = new HashMap<>();

    public AppContext() {
        initPersons();
        initAddresses();
    }

    private void initPersons() {

        List<String[]> persons = new ArrayList<>();
        Reader reader = readPersonsCsv();
        CSVReader csvReader = new CSVReader(reader);
        String[] line;

        try {
            while ((line = csvReader.readNext()) != null) {
                persons.add(line);
            }
            reader.close();
            csvReader.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        persons.forEach(fields -> {
            Long id = Long.valueOf(fields[0]);
            PERSONS.put(id, fields);
        });
    }

    private void initAddresses() {

        List<String[]> addresses = new ArrayList<>();
        Reader reader = readAddressesCsv();
        CSVReader csvReader = new CSVReader(reader);
        String[] line;

        try {
            while ((line = csvReader.readNext()) != null) {
                addresses.add(line);
            }
            reader.close();
            csvReader.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        addresses.forEach(fields -> {
            Long id = Long.valueOf(fields[0]);
            ADDRESSES.put(id, fields);
        });
    }

    private Reader readPersonsCsv() {
        try {
            Reader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("persons.csv").toURI()));
            return reader;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Reader readAddressesCsv() {
        try {
            Reader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("addresses.csv").toURI()));
            return reader;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
