package org.j2os.api;

import org.j2os.common.annotation.TestURL;
import org.j2os.model.domain.Car;
import org.j2os.model.domain.Person;
import org.j2os.model.service.ServiceClient;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("singleton")
@RequestMapping("/execute")
public class ReadServiceController {
    private final ServiceClient serviceClient;

    public ReadServiceController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }
    @TestURL(url = "http://localhost:9909/execute/savePerson.do?name=daryoush&family=abdoulahi")
    @GetMapping("/savePerson.do")
    public ResponseEntity<Object> savePerson(@RequestParam("name") String name,
                                             @RequestParam("family")String family){
        return serviceClient.savePerson(new Person().setName(name).setFamily(family));
    }
    @TestURL(url = "http://localhost:9909/execute/saveCar.do?model=benz&personId=1")
    @GetMapping("/saveCar.do")
    public ResponseEntity<Object> saveCar(@RequestParam("model")String model,
                                          @RequestParam("personId") String personId){
        return  serviceClient.saveCar(new Car().setModel(model).setPersonId(Long.parseLong(personId)));
    }
    @TestURL(url = "http://localhost:9909/execute/findPersonWithCars.do?personId=1")
    @GetMapping("findPersonWithCars.do")
    public Object findPersonWithCars (@RequestParam("personId") String personId){
        return serviceClient.findPersonWithCars(Long.parseLong(personId));
    }
}
