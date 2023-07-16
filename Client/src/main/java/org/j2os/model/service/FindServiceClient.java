package org.j2os.model.service;

import org.j2os.model.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("find-person-with-car")
public interface FindServiceClient {
    @GetMapping("findPersonWithCars")
    Object findPersonWithCars (@RequestParam("personId") Long personId);
}
