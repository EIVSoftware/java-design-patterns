package com.eiv;

import com.eiv.data.repositories.AddressRepository;

public class App 
{
    public static final AppContext context;

    static {
        context = new AppContext();
    }

    public static void main( String[] args ) {
        
        AddressRepository addressRepository = new AddressRepository();

        addressRepository.findAll().forEach(address -> {

            System.out.println( "address: " + address );
        });
    }
}
