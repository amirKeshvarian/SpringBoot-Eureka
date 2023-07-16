package org.j2os.model.service;

import org.j2os.common.exception.RollbackException;
import org.j2os.model.domain.Person;
import org.j2os.model.repository.Crud;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Scope("singleton")
public class PersonService {
    private final Crud<Person, Long> personCrud;

    public PersonService(Crud<Person, Long> personCrud) {
        this.personCrud = personCrud;
    }

    @Transactional(rollbackFor = RollbackException.class)
    public void save(Person person) {
        personCrud.insert(person);
    }
    public Optional<Person> findOne (Person person){
        return Optional.ofNullable(personCrud.selectOne(Person.class, person.getPersonId()));
    }
}
