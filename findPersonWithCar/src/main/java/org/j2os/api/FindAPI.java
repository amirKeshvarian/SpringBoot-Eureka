package org.j2os.api;

import org.j2os.model.domain.Person;
import org.j2os.model.service.FindService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("singleton")
public class FindAPI {
    private final FindService findService;

    public FindAPI(FindService findService) {
        this.findService = findService;
    }
        @RequestMapping("/findPersonWithCars")
    public List<Person> findPersonWithCars(@ModelAttribute Person person){
        return findService.findAllByPersonId(person);
    }

}
