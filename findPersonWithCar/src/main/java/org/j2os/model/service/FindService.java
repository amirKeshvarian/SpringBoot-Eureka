package org.j2os.model.service;

import org.j2os.model.domain.Person;
import org.j2os.model.repository.Crud;
import org.springframework.context.annotation.Scope;

import java.util.List;

@org.springframework.stereotype.Service
@Scope("singleton")
public class FindService {
    private final Crud<Person, Long> personCrud;

    public FindService(Crud<Person, Long> personCrud) {
        this.personCrud = personCrud;
    }

    public List<Person> findAllByPersonId(Person person){
        return personCrud.findAllByPersonId(Person.class, "cars");
    }
}
