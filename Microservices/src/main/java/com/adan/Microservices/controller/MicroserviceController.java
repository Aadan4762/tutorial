package com.adan.Microservices.controller;


import com.adan.Microservices.dto.MicroserviceRequest;
import com.adan.Microservices.dto.MicroserviceResponse;
import com.adan.Microservices.service.MicroserviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/microservice")
public class MicroserviceController {

    private final MicroserviceService microserviceService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMicroservice(@RequestBody MicroserviceRequest microserviceRequest){
        microserviceService.createMicroservice(microserviceRequest);

    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MicroserviceResponse> getAllMicroservices(){
        return microserviceService.getAllMicroservice();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MicroserviceResponse getMicroserviceById(@PathVariable int id) {
        return microserviceService.getMicroserviceById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMicroservice(@PathVariable int id, @RequestBody MicroserviceRequest microserviceRequest) {
        microserviceService.updateMicroservice(id, microserviceRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMicroservice(@PathVariable int id) {
        microserviceService.deleteMicroservice(id);
    }
}
