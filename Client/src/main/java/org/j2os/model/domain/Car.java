package org.j2os.model.domain;

import java.io.Serializable;
import java.util.List;

public class Car implements Serializable {
    private Long carId;
    private String model;
    private Long personId;

    public Car() {
    }

    public Car(Long carId, String model, Long personId) {
        this.carId = carId;
        this.model = model;
        this.personId = personId;
    }

    public Long getCarId() {
        return carId;
    }

    public Car setCarId(Long carId) {
        this.carId = carId;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getPersonId() {
        return personId;
    }

    public Car setPersonId(Long personId) {
        this.personId = personId;
        return this;
    }
}
