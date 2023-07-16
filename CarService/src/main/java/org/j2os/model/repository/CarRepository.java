package org.j2os.model.repository;

import org.j2os.model.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select o from car o where o.personId=:personId")
    Optional<Object>  findCarByPersonId (@Param("personId") Long personId);
}
