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
    public String createMicroservice(@RequestBody MicroserviceRequest microserviceRequest) {
        try {
            microserviceService.createMicroservice(microserviceRequest);
            return "Microservice created successfully";
        } catch (Exception e) {
            return "Failed to create microservice: " + e.getMessage();
        }
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MicroserviceResponse> getAllMicroservices(){
        return microserviceService.getAllMicroservice();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getMicroserviceById(@PathVariable int id) {
        MicroserviceResponse microservice = microserviceService.getMicroserviceById(id);

        if (microservice != null) {
            return microservice;
        } else {
            return "Microservice not found";
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateMicroservice(@PathVariable int id, @RequestBody MicroserviceRequest microserviceRequest) {
        boolean isUpdated = microserviceService.updateMicroservice(id, microserviceRequest);

        if (isUpdated) {
            return "Microservice updated successfully";
        } else {
            return "Microservice has been updated";
        }
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteMicroservice(@PathVariable int id) {
        boolean isDeleted = microserviceService.deleteMicroservice(id);

        if (isDeleted) {
            return "Microservice deleted successfully";
        } else {
            return "Microservice could not be deleted";
        }
    }
}
