package org.j2os.model.service;

import org.j2os.model.domain.Car;
import org.j2os.model.domain.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ServiceClient {
    private final PersonServiceClient personServiceClient;
    private final CarServiceClient carServiceClient;
    private final FindServiceClient findServiceClient;

    public ServiceClient(PersonServiceClient personServiceClient, CarServiceClient carServiceClient, FindServiceClient findServiceClient) {
        this.personServiceClient = personServiceClient;
        this.carServiceClient = carServiceClient;
        this.findServiceClient = findServiceClient;
    }
    public ResponseEntity<Object> savePerson  (Person person){
        return personServiceClient.savePerson(person.getName(), person.getFamily());
    }
    public ResponseEntity<Object> saveCar (Car car) {
        return carServiceClient.saveCar(car.getModel(), car.getPersonId());
    }
    public Object findPersonWithCars (Long personId){
        return findServiceClient.findPersonWithCars(personId);
    }
}
