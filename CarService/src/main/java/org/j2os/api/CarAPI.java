package org.j2os.api;

import org.j2os.model.domain.Car;
import org.j2os.model.service.CarService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Scope("singleton")
@RequestMapping("/car")
public class CarAPI {
    private final CarService carService;

    public CarAPI(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/saveCar.do")
    public ResponseEntity<Object> saveCar(@ModelAttribute Car car){
        if(car.getPersonId() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            carService.save(car);
            return new ResponseEntity<>(carService.findByCarId(car), HttpStatus.OK);
        }
    }

}
