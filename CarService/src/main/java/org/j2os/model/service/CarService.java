package org.j2os.model.service;

import org.j2os.common.exception.RollbackException;
import org.j2os.model.domain.Car;
import org.j2os.model.repository.CarRepository;
import org.j2os.model.repository.Crud;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Scope("singleton")
public class CarService {
    private final Crud<Car, Long> carCrud;
    private final CarRepository carRepository;

    public CarService(Crud<Car, Long> carCrud, CarRepository carRepository) {
        this.carCrud = carCrud;
        this.carRepository = carRepository;
    }
    @Transactional(rollbackFor = RollbackException.class)
    public void save (Car car) {
        carCrud.insert(car);
    }
    public Optional<Car> findByCarId (Car car){
        return Optional.ofNullable(carCrud.selectOne(Car.class, car.getCarId()));
    }
}
