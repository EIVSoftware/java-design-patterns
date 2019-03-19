package com.eiv.poc.jaspernestedreport;

import java.util.Arrays;
import java.util.Collection;

public class PersonaBeanFactory {

    public static Collection<? extends PersonaBean> getCollection() {
        
        Collection<PersonaBeanImpl> personas = Arrays.asList(
                new PersonaBeanImpl(1L, "HOMERO SIMPSON", 
                        Arrays.asList(
                                new PersonaDireccionBeanImpl("Evergreen Terrace 1", "742"),
                                new PersonaDireccionBeanImpl("Evergreen Terrace 2", "742"),
                                new PersonaDireccionBeanImpl("Evergreen Terrace 3", "742"))
                        ),
                new PersonaBeanImpl(2L, "MARGE SIMPSON"),
                new PersonaBeanImpl(3L, "BART SIMPSON"),
                new PersonaBeanImpl(4L, "LISA SIMPSON"),
                new PersonaBeanImpl(5L, "MAGGIE SIMPSON")
            );
        
        return personas;
    }
}
