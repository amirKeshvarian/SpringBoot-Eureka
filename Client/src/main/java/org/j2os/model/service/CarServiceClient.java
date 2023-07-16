package org.j2os.model.service;

import jakarta.ws.rs.QueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("car-service")
public interface CarServiceClient {
    @GetMapping("/car/saveCar.do")
    ResponseEntity<Object> saveCar (@RequestParam("model") String model,
                                    @RequestParam("personId") Long personId);
}
