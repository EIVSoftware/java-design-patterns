package com.eiv;

import com.eiv.data.repositories.PersonRepository;

public class App 
{
    public static final AppContext ctx;

    static {
        ctx = new AppContext();
    }

    public static void main( String[] args ) {

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);

        personRepository.findAll().forEach(person -> {
            System.out.println( "person: " + person );
        });
        
    }
}
