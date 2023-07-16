package org.j2os.api;

import org.j2os.common.wrapper.ErrorHandler;
import org.j2os.model.domain.Person;
import org.j2os.model.service.PersonService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Scope("singleton")
@RequestMapping("/person")
public class PersonAPI {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map> onException (Exception e){
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorHandler.getError(e));

    }    private final PersonService personService;

    public PersonAPI(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/savePerson.do")
    public ResponseEntity<Object> savePerson (@ModelAttribute Person person){
        personService.save(person);
        return new ResponseEntity<>(personService.findOne(person) ,HttpStatus.OK);
    }
}
