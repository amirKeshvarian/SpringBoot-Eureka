package org.j2os.model.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("person-service")
public interface PersonServiceClient {
    @GetMapping("/person/savePerson.do")
    ResponseEntity<Object> savePerson (@RequestParam("name") String name, @RequestParam("family") String family);
}
